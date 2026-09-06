package com.enviouse.sef.workstations;

import com.enviouse.sef.audit.CommandEffectEvidenceWriter;
import com.enviouse.sef.permissions.DelegatedPermissionScope;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameType;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

import java.util.Set;

@GameTestHolder("sef")
@PrefixGameTestTemplate(false)
public final class EnchantGameTests {
    private EnchantGameTests() {
    }

    @GameTest(template = "empty")
    public static void arbitraryItemRetainsExtremeEnchantmentComponent(GameTestHelper helper) {
        var sharpness = helper.getLevel()
                .registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(Enchantments.SHARPNESS);
        ItemStack dirt = new ItemStack(Items.DIRT, 64);

        AdministrativeEnchantCommands.setEnchantmentComponent(dirt, sharpness, 1000);

        helper.assertValueEqual(
                dirt.getEnchantments().getLevel(sharpness),
                1000,
                "unsafe level did not survive the item component");
        helper.assertValueEqual(dirt.getCount(), 64, "unsafe enchanting changed the item count");
        AdministrativeEnchantCommands.clearEnchantments(dirt);
        helper.assertValueEqual(
                dirt.getEnchantments().size(),
                0,
                "clear did not remove the arbitrary item enchantment");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void implementationCeilingRejectsOverflowingMutation(GameTestHelper helper) {
        var sharpness = helper.getLevel()
                .registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(Enchantments.SHARPNESS);
        ItemStack item = new ItemStack(Items.DIAMOND_SWORD);
        try {
            AdministrativeEnchantCommands.setEnchantmentComponent(
                    item,
                    sharpness,
                    AdministrativeEnchantCommands.IMPLEMENTATION_MAXIMUM_LEVEL + 1);
            helper.fail("overflowing enchantment level was accepted");
        } catch (IllegalArgumentException expected) {
            helper.succeed();
        }
    }

    @GameTest(template = "empty")
    public static void administrativeCommandTreeReplacesVanillaEnchant(GameTestHelper helper) {
        var dispatcher = helper.getLevel().getServer().getCommands().getDispatcher();
        var enchant = dispatcher.getRoot().getChild("enchant");
        var sef = dispatcher.getRoot().getChild("sef");

        helper.assertTrue(enchant != null, "administrative enchant root is missing");
        helper.assertTrue(enchant.getChild("targets") != null, "target enchant route is missing");
        helper.assertTrue(enchant.getChild("self") != null, "self enchant route is missing");
        helper.assertTrue(enchant.getChild("remove") != null, "enchantment removal route is missing");
        helper.assertTrue(enchant.getChild("clear") != null, "enchantment clear route is missing");
        helper.assertTrue(
                sef != null && sef.getChild("enchant") != null,
                "canonical sef enchant route is missing");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void administrativeEnchantCommandAppliesLiveEffectEvidence(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        player.setGameMode(GameType.SURVIVAL);
        player.getInventory().setItem(0, new ItemStack(Items.DIAMOND_SWORD));
        var sharpness = helper.getLevel()
                .registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(Enchantments.SHARPNESS);

        int result;
        try {
            result = executeEnchant(helper, player, "enchant minecraft:sharpness 3");
        } catch (IllegalStateException exception) {
            helper.fail("administrative enchant command failed through the live dispatcher: "
                    + exception.getMessage());
            return;
        }

        helper.assertTrue(result > 0, "administrative enchant command did not report success");
        helper.assertValueEqual(
                player.getMainHandItem().getEnchantments().getLevel(sharpness),
                3,
                "administrative enchant command did not apply the requested level");
        CommandEffectEvidenceWriter.record(
                "sef:enchant.apply",
                "administrativeEnchantCommandAppliesLiveEffectEvidence",
                "success",
                player.getMainHandItem().getEnchantments().getLevel(sharpness) == 3,
                true,
                "none");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void administrativeEnchantCommandRejectsEmptyHandWithoutMutation(GameTestHelper helper) {
        ServerPlayer player = helper.makeMockServerPlayerInLevel();
        player.setGameMode(GameType.SURVIVAL);
        ItemStack before = player.getMainHandItem().copy();
        int result;

        try {
            result = executeEnchant(helper, player, "enchant minecraft:sharpness 3");
        } catch (IllegalStateException exception) {
            helper.fail("administrative enchant failure route could not be dispatched: "
                    + exception.getMessage());
            return;
        }

        helper.assertTrue(result <= 0, "administrative enchant command accepted an empty hand");
        helper.assertTrue(
                ItemStack.matches(before, player.getMainHandItem()),
                "administrative enchant command changed an empty hand");
        CommandEffectEvidenceWriter.record(
                "sef:enchant.apply",
                "administrativeEnchantCommandRejectsEmptyHandWithoutMutation",
                "failure",
                false,
                true,
                "invalid_input");
        helper.succeed();
    }

    private static int executeEnchant(GameTestHelper helper, ServerPlayer player, String command) {
        return DelegatedPermissionScope.preview(
                player.getUUID(),
                "enchant",
                "sef:enchant.apply",
                Set.of("sef.commands.enchant.self"),
                () -> {
                    try {
                        return helper.getLevel().getServer().getCommands().getDispatcher().execute(
                                command, player.createCommandSourceStack());
                    } catch (CommandSyntaxException exception) {
                        throw new IllegalStateException(
                                "administrative enchant command syntax was rejected: "
                                        + exception.getRawMessage().getString(),
                                exception);
                    }
                });
    }
}
