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
public final class CommunityCommandGameTests {
    private CommunityCommandGameTests() {
    }

    @GameTest(template = "empty")
    public static void interactionBlockCommandAddsAndRemovesDurableState(GameTestHelper helper) {
        ServerPlayer actor = helper.makeMockServerPlayerInLevel();
        ServerPlayer target = helper.makeMockServerPlayerInLevel();
        String key = target.getUUID() + ":messages";

        try {
            int addResult = executeWithPermissions(
                    helper,
                    actor,
                    "blocks add @a[uuid=" + target.getUUID() + "] messages",
                    "sef:control.interaction_blocks.set",
                    Set.of(
                            "sef.commands.control.interaction_blocks.view",
                            "sef.commands.control.interaction_blocks.create"));
            helper.assertTrue(addResult > 0, "interaction block add did not report success");
            helper.assertTrue(
                    KernelServices.communityState()
                            .find("interaction_block", actor.getUUID(), key)
                            .isPresent(),
                    "interaction block add did not persist state");

            int removeResult = executeWithPermissions(
                    helper,
                    actor,
                    "blocks remove @a[uuid=" + target.getUUID() + "] messages",
                    "sef:control.interaction_blocks.set",
                    Set.of(
                            "sef.commands.control.interaction_blocks.view",
                            "sef.commands.control.interaction_blocks.create"));
            helper.assertTrue(removeResult > 0, "interaction block remove did not report success");
            helper.assertTrue(
                    KernelServices.communityState()
                            .find("interaction_block", actor.getUUID(), key)
                            .isEmpty(),
                    "interaction block remove did not clear state");
            CommandEffectEvidenceWriter.record(
                    "sef:control.interaction_blocks.set",
                    "interactionBlockCommandAddsAndRemovesDurableState",
                    "success",
                    true,
                    true,
                    "none");
            helper.succeed();
        } finally {
            KernelServices.communityState().remove("interaction_block", actor.getUUID(), key);
        }
    }

    @GameTest(template = "empty")
    public static void interactionBlockCommandRejectsSelfTargetWithoutMutation(GameTestHelper helper) {
        ServerPlayer actor = helper.makeMockServerPlayerInLevel();
        String key = actor.getUUID() + ":messages";
        int result = executeWithPermissions(
                helper,
                actor,
                "blocks add @a[uuid=" + actor.getUUID() + "] messages",
                "sef:control.interaction_blocks.set",
                Set.of(
                        "sef.commands.control.interaction_blocks.view",
                        "sef.commands.control.interaction_blocks.create"));

        helper.assertTrue(result <= 0, "self interaction block was accepted");
        helper.assertTrue(
                KernelServices.communityState().find("interaction_block", actor.getUUID(), key).isEmpty(),
                "self interaction block changed state");
        CommandEffectEvidenceWriter.record(
                "sef:control.interaction_blocks.set",
                "interactionBlockCommandRejectsSelfTargetWithoutMutation",
                "failure",
                false,
                true,
                "invalid_input");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void waypointCommandsPersistAndRemoveDurableState(GameTestHelper helper) {
        ServerPlayer actor = helper.makeMockServerPlayerInLevel();
        String name = "auditpoint";

        try {
            int setResult = executeWithPermissions(
                    helper,
                    actor,
                    "waypoint set " + name,
                    "sef:control.waypoints.set",
                    Set.of(
                            "sef.commands.control.waypoints.view",
                            "sef.commands.control.waypoints.create"));
            helper.assertTrue(setResult > 0, "waypoint set did not report success");
            helper.assertTrue(
                    KernelServices.communityState().find("waypoint", actor.getUUID(), name).isPresent(),
                    "waypoint set did not persist state");
            CommandEffectEvidenceWriter.record(
                    "sef:control.waypoints.set",
                    "waypointCommandsPersistAndRemoveDurableState",
                    "success",
                    true,
                    true,
                    "none");

            int removeResult = executeWithPermissions(
                    helper,
                    actor,
                    "waypoint remove " + name,
                    "sef:control.waypoints.remove",
                    Set.of(
                            "sef.commands.control.waypoints.view",
                            "sef.commands.control.waypoints.create"));
            helper.assertTrue(removeResult > 0, "waypoint remove did not report success");
            helper.assertTrue(
                    KernelServices.communityState().find("waypoint", actor.getUUID(), name).isEmpty(),
                    "waypoint remove did not clear state");
            CommandEffectEvidenceWriter.record(
                    "sef:control.waypoints.remove",
                    "waypointCommandsPersistAndRemoveDurableState",
                    "success",
                    true,
                    true,
                    "none");

            int missingResult = executeWithPermissions(
                    helper,
                    actor,
                    "waypoint remove " + name,
                    "sef:control.waypoints.remove",
                    Set.of(
                            "sef.commands.control.waypoints.view",
                            "sef.commands.control.waypoints.create"));
            helper.assertTrue(missingResult <= 0, "missing waypoint removal was accepted");
            CommandEffectEvidenceWriter.record(
                    "sef:control.waypoints.remove",
                    "waypointCommandsPersistAndRemoveDurableStateMissingFailure",
                    "failure",
                    false,
                    true,
                    "not_found");
            helper.succeed();
        } finally {
            KernelServices.communityState().remove("waypoint", actor.getUUID(), name);
        }
    }

    private static int executeWithPermissions(
            GameTestHelper helper,
            ServerPlayer actor,
            String command,
            String action,
            Set<String> permissions
    ) {
        try {
            return DelegatedPermissionScope.preview(
                    actor.getUUID(),
                    command.split(" ")[0],
                    action,
                    permissions,
                    () -> {
                        try {
                            return helper.getLevel().getServer().getCommands().getDispatcher().execute(
                                    command,
                                    actor.createCommandSourceStack());
                        } catch (CommandSyntaxException exception) {
                            throw new IllegalStateException("community command syntax was rejected", exception);
                        }
                    });
        } catch (IllegalStateException exception) {
            helper.fail("community command execution failed, " + exception.getMessage());
            return 0;
        }
    }
}
