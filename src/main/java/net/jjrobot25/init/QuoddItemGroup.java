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

                entries.add(QuoddItems.BAGUETTE);
                entries.add(QuoddItems.HALF_BAGUETTE);
            }).build());

    public static void init() {
        Quodd.LOGGER.info("Registering item groups for " + Quodd.MOD_ID);
    }
}
