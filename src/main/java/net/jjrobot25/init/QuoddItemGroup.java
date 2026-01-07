package net.jjrobot25.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jjrobot25.Quodd;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class QuoddItemGroup {
    public static final ItemGroup QUODD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Quodd.MOD_ID, "quodd"), FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.quodd"))
            .icon(() -> new ItemStack(Items.WARPED_FUNGUS_ON_A_STICK))
            .entries((displayContext, entries) -> {
                entries.add(QuoddItems.COAL_BRIQUETTE);
                entries.add(QuoddItems.CHARCOAL_BRIQUETTE);

                entries.add(QuoddItems.THOMAS_TOTEM);
                entries.add(QuoddItems.BLADE_OF_GRASS);
                entries.add(QuoddItems.BERRY_BOWL);

                entries.add(QuoddItems.BAGUETTE);
                entries.add(QuoddItems.HALF_BAGUETTE);
                entries.add(QuoddItems.BROODJE_GEZOND);

                entries.add(QuoddItems.SAUSAGE);
                entries.add(QuoddItems.HOTDOG);

                entries.add(QuoddBlocks.FRESH_CHEESE_BLOCK);
                entries.add(QuoddBlocks.YOUNG_CHEESE_BLOCK);
                entries.add(QuoddBlocks.MATURE_CHEESE_BLOCK);
                entries.add(QuoddBlocks.OLD_CHEESE_BLOCK);
                entries.add(QuoddItems.YOUNG_CHEESE);
                entries.add(QuoddItems.MATURE_CHEESE);
                entries.add(QuoddItems.OLD_CHEESE);

                entries.add(QuoddItems.GOAT_MILK_BUCKET);
            }).build());

    public static void init() {
        Quodd.LOGGER.info("Registering item groups for " + Quodd.MOD_ID);
    }
}
