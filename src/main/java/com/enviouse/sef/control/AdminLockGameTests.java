package com.enviouse.sef.control;

import com.enviouse.sef.audit.CommandEffectEvidenceWriter;
import com.enviouse.sef.kernel.KernelServices;
import com.enviouse.sef.permissions.DelegatedPermissionScope;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

import java.util.Set;

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
