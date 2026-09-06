package com.enviouse.sef.inventory;

import com.enviouse.sef.audit.CommandEffectEvidenceWriter;
import com.enviouse.sef.permissions.DelegatedPermissionScope;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

import java.util.Set;

@GameTestHolder("sef")
@PrefixGameTestTemplate(false)
public final class InventoryGameTests {
    private InventoryGameTests() {
    }

    @GameTest(template = "empty")
    public static void condensationPreservesExactItemTotals(GameTestHelper helper) {
        Player player = helper.makeMockPlayer(GameType.SURVIVAL);
        Inventory inventory = player.getInventory();
        inventory.setItem(0, new ItemStack(Items.IRON_INGOT, 18));
        inventory.setItem(1, new ItemStack(Items.DIAMOND, 3));

        int crafted = InventoryUtilityCommands.condenseInventory(inventory);

        helper.assertValueEqual(crafted, 2, "unexpected condensation output count");
        helper.assertValueEqual(count(inventory, Items.IRON_INGOT), 0, "iron ingots were not consumed");
        helper.assertValueEqual(count(inventory, Items.IRON_BLOCK), 2, "iron blocks were not created");
        helper.assertValueEqual(count(inventory, Items.DIAMOND), 3, "unrelated items changed");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void incompleteCondensationRecipeDoesNotMutateInventory(GameTestHelper helper) {
        Player player = helper.makeMockPlayer(GameType.SURVIVAL);
        Inventory inventory = player.getInventory();
        inventory.setItem(0, new ItemStack(Items.GOLD_INGOT, 8));
        ItemStack before = inventory.getItem(0).copy();

        int crafted = InventoryUtilityCommands.condenseInventory(inventory);

        helper.assertValueEqual(crafted, 0, "an incomplete recipe produced output");
        helper.assertTrue(
                ItemStack.matches(before, inventory.getItem(0)),
                "an incomplete recipe changed the inventory");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void condensationCommandEmitsSuccessEffectEvidence(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        Inventory inventory = player.getInventory();
        inventory.setItem(0, new ItemStack(Items.IRON_INGOT, 18));
        inventory.setItem(1, new ItemStack(Items.DIAMOND, 3));

        try {
            int result = helper.getLevel().getServer().getCommands().getDispatcher().execute(
                    "condense", player.createCommandSourceStack());

            helper.assertTrue(result > 0, "condense command did not report success");
            helper.assertValueEqual(count(inventory, Items.IRON_INGOT), 0,
                    "condense command did not consume the input");
            helper.assertValueEqual(count(inventory, Items.IRON_BLOCK), 2,
                    "condense command did not create the output");
            helper.assertValueEqual(count(inventory, Items.DIAMOND), 3,
                    "condense command changed unrelated items");
            CommandEffectEvidenceWriter.record(
                    "sef:inventory.condense",
                    "condensationCommandEmitsSuccessEffectEvidence",
                    "success",
                    count(inventory, Items.IRON_BLOCK) == 2,
                    true,
                    "none");
            helper.succeed();
        } catch (CommandSyntaxException exception) {
            helper.fail("condense command failed through the live dispatcher");
        }
    }

    @GameTest(template = "empty")
    public static void condensationCommandRejectsIncompleteRecipeWithoutMutation(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        Inventory inventory = player.getInventory();
        inventory.setItem(0, new ItemStack(Items.GOLD_INGOT, 8));
        ItemStack before = inventory.getItem(0).copy();
        int result = Integer.MIN_VALUE;
        boolean syntaxRejected = false;

        try {
            result = helper.getLevel().getServer().getCommands().getDispatcher().execute(
                    "condense", player.createCommandSourceStack());
        } catch (CommandSyntaxException exception) {
            syntaxRejected = true;
        }

        helper.assertTrue(syntaxRejected || result <= 0,
                "condense command accepted an incomplete recipe");
        helper.assertTrue(ItemStack.matches(before, inventory.getItem(0)),
                "incomplete condense command changed the inventory");
        CommandEffectEvidenceWriter.record(
                "sef:inventory.condense",
                "condensationCommandRejectsIncompleteRecipeWithoutMutation",
                "failure",
                false,
                true,
                "invalid_input");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void moreCommandFillsHeldStackEffectEvidence(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        player.getInventory().setItem(0, new ItemStack(Items.DIAMOND, 5));

        int result;
        try {
            result = executeMore(helper, player);
        } catch (IllegalStateException exception) {
            helper.fail("more command failed through the live dispatcher");
            return;
        }
        helper.assertTrue(result > 0, "more command did not report success");
        helper.assertValueEqual(player.getMainHandItem().getCount(), 64,
                "more command did not fill the held stack");
        CommandEffectEvidenceWriter.record(
                "sef:inventory.more",
                "moreCommandFillsHeldStackEffectEvidence",
                "success",
                player.getMainHandItem().getCount() == 64,
                true,
                "none");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void moreCommandRejectsFullHeldStackWithoutMutation(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        player.getInventory().setItem(0, new ItemStack(Items.DIAMOND, 64));
        ItemStack before = player.getMainHandItem().copy();
        int result;

        try {
            result = executeMore(helper, player);
        } catch (IllegalStateException exception) {
            helper.fail("more command failure route could not be dispatched");
            return;
        }

        helper.assertTrue(result <= 0,
                "more command accepted an already full stack");
        helper.assertTrue(ItemStack.matches(before, player.getMainHandItem()),
                "full more command changed the held stack");
        CommandEffectEvidenceWriter.record(
                "sef:inventory.more",
                "moreCommandRejectsFullHeldStackWithoutMutation",
                "failure",
                false,
                true,
                "invalid_input");
        helper.succeed();
    }

    private static int executeMore(GameTestHelper helper, ServerPlayer player) {
        return DelegatedPermissionScope.preview(
                player.getUUID(),
                "more",
                "sef:inventory.more",
                Set.of("sef.commands.more"),
                () -> {
                    try {
                        return helper.getLevel().getServer().getCommands().getDispatcher().execute(
                                "more", player.createCommandSourceStack());
                    } catch (CommandSyntaxException exception) {
                        throw new IllegalStateException("more command syntax was rejected", exception);
                    }
                });
    }

    private static int count(Inventory inventory, Item item) {
        int count = 0;
        for (int slot = 0; slot < inventory.getContainerSize(); slot++) {
            ItemStack stack = inventory.getItem(slot);
            if (stack.is(item)) {
                count += stack.getCount();
            }
        }
        return count;
    }
}
