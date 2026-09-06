package com.enviouse.sef.control;

import com.enviouse.sef.audit.CommandEffectEvidenceWriter;
import com.enviouse.sef.kernel.KernelServices;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@GameTestHolder("sef")
@PrefixGameTestTemplate(false)
public final class CommunityCommandGameTests {
    private CommunityCommandGameTests() {
    }

    @GameTest(template = "empty", timeoutTicks = 200)
    public static void interactionBlockCommandAddsAndRemovesDurableState(GameTestHelper helper) {
        ServerPlayer actor = helper.makeMockServerPlayerInLevel();
        ServerPlayer target = helper.makeMockServerPlayerInLevel();
        String key = target.getUUID() + ":messages";
        target.teleportTo(actor.getX() + 100.0D, actor.getY(), actor.getZ());

        helper.runAfterDelay(2, () -> {
            try {
                int addResult = executeWithPermissions(
                        helper,
                        actor,
                        "blocks add @p[distance=90..110] messages");
                helper.assertTrue(addResult > 0, "interaction block add did not report success");
                helper.assertTrue(
                        KernelServices.communityState()
                                .find("interaction_block", actor.getUUID(), key)
                                .isPresent(),
                        "interaction block add did not persist state");

                int removeResult = executeWithPermissions(
                        helper,
                        actor,
                        "blocks remove @p[distance=90..110] messages");
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
        });
    }

    @GameTest(template = "empty")
    public static void interactionBlockCommandRejectsSelfTargetWithoutMutation(GameTestHelper helper) {
        ServerPlayer actor = helper.makeMockServerPlayerInLevel();
        String key = actor.getUUID() + ":messages";
        int result = executeWithPermissions(
                helper,
                actor,
                "blocks add @s messages");

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
                    "waypoint set " + name);
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
                    "waypoint remove " + name);
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
                    "waypoint remove " + name);
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

    @GameTest(template = "empty")
    public static void waypointGoTeleportsToPersistedLocation(GameTestHelper helper) {
        ServerPlayer actor = helper.makeMockServerPlayerInLevel();
        String name = "auditgo";
        double savedX = actor.getX();
        double savedY = actor.getY();
        double savedZ = actor.getZ();

        try {
            int setResult = executeWithPermissions(helper, actor, "waypoint set " + name);
            helper.assertTrue(setResult > 0, "waypoint setup did not report success");
            actor.teleportTo(savedX + 8.0D, savedY, savedZ);

            int goResult = executeWithPermissions(helper, actor, "waypoint go " + name);
            helper.assertTrue(goResult > 0, "waypoint go did not report success");
            helper.assertTrue(
                    actor.distanceToSqr(savedX, savedY, savedZ) < 1.0D,
                    "waypoint go did not teleport to the persisted location");
            CommandEffectEvidenceWriter.record(
                    "sef:control.waypoints.go",
                    "waypointGoTeleportsToPersistedLocation",
                    "success",
                    actor.distanceToSqr(savedX, savedY, savedZ) < 1.0D,
                    true,
                    "none");
            helper.succeed();
        } finally {
            KernelServices.communityState().remove("waypoint", actor.getUUID(), name);
        }
    }

    @GameTest(template = "empty", timeoutTicks = 200)
    public static void friendCommandsPersistAcceptAndRemoveRelationship(GameTestHelper helper) {
        ServerPlayer actor = helper.makeMockServerPlayerInLevel();
        ServerPlayer target = helper.makeMockServerPlayerInLevel();
        String targetKey = target.getUUID().toString();
        String actorKey = actor.getUUID().toString();
        target.teleportTo(actor.getX() + 100.0D, actor.getY(), actor.getZ());

        helper.runAfterDelay(2, () -> {
            try {
                int requestResult = executeWithPermissions(
                        helper,
                        actor,
                        "friend add " + selectorFor(target));
                helper.assertTrue(requestResult > 0, "friend request did not report success");
                helper.assertTrue(
                        KernelServices.communityState()
                                .find("friend_request", target.getUUID(), actorKey)
                                .isPresent(),
                        "friend request did not persist state");
                CommandEffectEvidenceWriter.record(
                        "sef:control.friends.request",
                        "friendCommandsPersistAcceptAndRemoveRelationshipRequest",
                        "success",
                        true,
                        true,
                        "none");

                int acceptResult = executeWithPermissions(
                        helper,
                        target,
                        "friend accept " + selectorFor(actor));
                helper.assertTrue(acceptResult > 0, "friend acceptance did not report success");
                helper.assertTrue(
                        KernelServices.communityState()
                                .find("friend", actor.getUUID(), targetKey)
                                .isPresent(),
                        "accepted friendship missing from actor state");
                helper.assertTrue(
                        KernelServices.communityState()
                                .find("friend", target.getUUID(), actorKey)
                                .isPresent(),
                        "accepted friendship missing from target state");
                CommandEffectEvidenceWriter.record(
                        "sef:control.friends.accept",
                        "friendCommandsPersistAcceptAndRemoveRelationshipAccept",
                        "success",
                        true,
                        true,
                        "none");

                int removeResult = executeWithPermissions(
                        helper,
                        actor,
                        "friend remove " + selectorFor(target));
                helper.assertTrue(removeResult > 0, "friend removal did not report success");
                helper.assertTrue(
                        KernelServices.communityState()
                                .find("friend", actor.getUUID(), targetKey)
                                .isEmpty(),
                        "friend removal did not clear actor state");
                helper.assertTrue(
                        KernelServices.communityState()
                                .find("friend", target.getUUID(), actorKey)
                                .isEmpty(),
                        "friend removal did not clear target state");
                CommandEffectEvidenceWriter.record(
                        "sef:control.friends.remove",
                        "friendCommandsPersistAcceptAndRemoveRelationshipRemove",
                        "success",
                        true,
                        true,
                        "none");
                helper.succeed();
            } finally {
                KernelServices.communityState().remove("friend_request", target.getUUID(), actorKey);
                KernelServices.communityState().remove("friend", actor.getUUID(), targetKey);
                KernelServices.communityState().remove("friend", target.getUUID(), actorKey);
            }
        });
    }

    private static int executeWithPermissions(
            GameTestHelper helper,
            ServerPlayer actor,
            String command
    ) {
        try {
            return helper.getLevel().getServer().getCommands().getDispatcher().execute(
                    command,
                    actor.createCommandSourceStack().withPermission(4));
        } catch (IllegalStateException exception) {
            helper.fail("community command execution failed, " + exception.getMessage());
            return 0;
        } catch (CommandSyntaxException exception) {
            helper.fail("community command syntax was rejected, " + exception.getMessage());
            return 0;
        }
    }

    private static String selectorFor(ServerPlayer player) {
        return "@p[x=" + Math.floor(player.getX())
                + ",y=" + Math.floor(player.getY())
                + ",z=" + Math.floor(player.getZ())
                + ",distance=..2]";
    }
}
