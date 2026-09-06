package com.enviouse.sef.control;

import com.enviouse.sef.audit.CommandEffectEvidenceWriter;
import com.enviouse.sef.kernel.KernelServices;
import com.enviouse.sef.kernel.command.CommandDefinition;
import com.enviouse.sef.permissions.DelegatedPermissionScope;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

import java.util.Set;
import java.util.UUID;

@GameTestHolder("sef")
@PrefixGameTestTemplate(false)
public final class AdminLockGameTests {
    private AdminLockGameTests() {
    }

    @GameTest(template = "empty")
    public static void adminLockCommandsEnforceChallengeBeforeUnlock(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        try {
            int lockResult = execute(helper, player, "adminlock lock audit lock", "lock");
            helper.assertTrue(lockResult > 0, "admin lock command did not report success");
            helper.assertTrue(
                    KernelServices.adminLocks().status(player.getUUID()).locked(),
                    "admin lock command did not persist the lock");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.lock",
                    "adminLockCommandsEnforceChallengeBeforeUnlock",
                    "success",
                    true,
                    true,
                    "none");

            int rejectedUnlock = execute(helper, player, "adminlock unlock", "unlock");
            helper.assertTrue(rejectedUnlock <= 0, "unlock command bypassed the challenge");
            helper.assertTrue(
                    KernelServices.adminLocks().status(player.getUUID()).locked(),
                    "rejected unlock command changed the lock state");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.unlock",
                    "adminLockCommandsRejectUnlockWithoutChallenge",
                    "failure",
                    false,
                    true,
                    "confirmation_required");

            int challengeResult = execute(helper, player, "adminlock challenge", "challenge");
            helper.assertTrue(challengeResult > 0, "admin lock challenge command did not report success");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.challenge",
                    "adminLockCommandsEnforceChallengeBeforeUnlock",
                    "success",
                    KernelServices.adminLocks().status(player.getUUID()).locked(),
                    true,
                    "none");

            int unlockResult = execute(helper, player, "adminlock unlock", "unlock");
            helper.assertTrue(unlockResult > 0, "unlock command did not report success after challenge");
            helper.assertTrue(
                    !KernelServices.adminLocks().status(player.getUUID()).locked(),
                    "unlock command did not clear the administrative lock");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.unlock",
                    "adminLockCommandsUnlockAfterChallenge",
                    "success",
                    true,
                    true,
                    "none");
            helper.succeed();
        } finally {
            KernelServices.adminLocks().logout(player.getUUID());
            KernelServices.adminLocks().unlock(player.getUUID(), player.getUUID(), true);
        }
    }

    @GameTest(template = "empty")
    public static void adminLockSessionPolicyAndRecoveryRoutesPersistEffects(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        UUID playerId = player.getUUID();
        Set<CommandDefinition.AccessClass> originalRequiredClasses =
                Set.copyOf(KernelServices.adminLockRepository().requiredClasses());
        try {
            int statusResult = execute(helper, player, "adminlock status", "status.self");
            helper.assertTrue(statusResult > 0, "admin lock status command did not report success");
            CommandEffectEvidenceWriter.recordReadOnly(
                    "sef:adminlock.status",
                    "adminLockSessionPolicyAndRecoveryRoutesPersistEffects");

            int historyResult = execute(helper, player, "adminlock history", "history.self");
            helper.assertTrue(historyResult > 0, "admin lock history command did not report success");
            CommandEffectEvidenceWriter.recordReadOnly(
                    "sef:adminlock.history",
                    "adminLockSessionPolicyAndRecoveryRoutesPersistEffects");

            int openResult = execute(
                    helper,
                    player,
                    "adminlock session open 10m command audit",
                    "session.open");
            helper.assertTrue(openResult > 0, "admin lock session open command did not report success");
            helper.assertTrue(
                    KernelServices.adminLocks().status(playerId).session().isPresent(),
                    "admin lock session open command did not persist a session");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.session.open",
                    "adminLockSessionPolicyAndRecoveryRoutesPersistEffects",
                    "success",
                    true,
                    true,
                    "none");

            int closeResult = execute(helper, player, "adminlock session close", "session.close");
            helper.assertTrue(closeResult > 0, "admin lock session close command did not report success");
            helper.assertTrue(
                    KernelServices.adminLocks().activeSessionCount() == 0,
                    "admin lock session close command did not clear the session");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.session.close",
                    "adminLockSessionPolicyAndRecoveryRoutesPersistEffects",
                    "success",
                    true,
                    true,
                    "none");

            int requireResult = execute(helper, player, "adminlock require staff true", "require");
            helper.assertTrue(requireResult > 0, "admin lock require command did not report success");
            helper.assertTrue(
                    KernelServices.adminLockRepository().requiredClasses()
                            .contains(CommandDefinition.AccessClass.STAFF),
                    "admin lock require command did not persist the required class");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.require",
                    "adminLockSessionPolicyAndRecoveryRoutesPersistEffects",
                    "success",
                    true,
                    true,
                    "none");

            int invalidateOpenResult = execute(
                    helper,
                    player,
                    "adminlock session open 10m invalidate-me",
                    "session.open");
            helper.assertTrue(invalidateOpenResult > 0, "admin lock invalidate setup did not open a session");
            int invalidateResult = execute(
                    helper,
                    player,
                    "adminlock invalidate @s invalidated-by-test",
                    "invalidate");
            helper.assertTrue(invalidateResult > 0, "admin lock invalidate command did not report success");
            helper.assertTrue(
                    KernelServices.adminLocks().activeSessionCount() == 0,
                    "admin lock invalidate command did not clear the session");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.invalidate",
                    "adminLockSessionPolicyAndRecoveryRoutesPersistEffects",
                    "success",
                    true,
                    true,
                    "none");

            int lockResult = execute(helper, player, "adminlock lock recovery-lock", "lock");
            helper.assertTrue(lockResult > 0, "admin lock recovery setup did not lock the account");
            int releaseResult = execute(
                    helper,
                    player,
                    "adminlock release @s released-by-test",
                    "release");
            helper.assertTrue(releaseResult > 0, "admin lock release command did not report success");
            helper.assertTrue(
                    !KernelServices.adminLocks().status(playerId).locked(),
                    "admin lock release command did not clear the lock");
            CommandEffectEvidenceWriter.record(
                    "sef:adminlock.release",
                    "adminLockSessionPolicyAndRecoveryRoutesPersistEffects",
                    "success",
                    true,
                    true,
                    "none");
            helper.succeed();
        } finally {
            KernelServices.adminLocks().logout(playerId);
            KernelServices.adminLocks().unlock(playerId, playerId, true);
            boolean currentlyRequired = KernelServices.adminLockRepository().requiredClasses()
                    .contains(CommandDefinition.AccessClass.STAFF);
            boolean originallyRequired = originalRequiredClasses.contains(CommandDefinition.AccessClass.STAFF);
            if (currentlyRequired != originallyRequired) {
                KernelServices.adminLockRepository().commit(() -> KernelServices.adminLockRepository().require(
                        CommandDefinition.AccessClass.STAFF,
                        originallyRequired,
                        playerId));
            }
        }
    }

    private static int execute(GameTestHelper helper, ServerPlayer player, String command, String action) {
        String actionId = "sef:adminlock." + action;
        return DelegatedPermissionScope.preview(
                player.getUUID(),
                "adminlock",
                actionId,
                Set.of("sef.commands.adminlock." + action),
                () -> {
                    try {
                        return helper.getLevel().getServer().getCommands().getDispatcher().execute(
                                command,
                                player.createCommandSourceStack());
                    } catch (CommandSyntaxException exception) {
                        throw new IllegalStateException("admin lock command syntax was rejected", exception);
                    }
                });
    }
}
