package net.jjrobot25.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jjrobot25.Quodd;
import net.jjrobot25.item.BaguetteItem;
import net.jjrobot25.item.QuoddToolMaterials;
import net.jjrobot25.item.ThomasTotemItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class QuoddItems {
    public static final Item COAL_BRIQUETTE = basicItem("coal_briquette");
    public static final Item CHARCOAL_BRIQUETTE = basicItem("charcoal_briquette");

    public static final Item THOMAS_TOTEM = register("thomas_totem", new ThomasTotemItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item BLADE_OF_GRASS = register("blade_of_grass", new SwordItem(QuoddToolMaterials.GRASS, 3, -2.4F, new FabricItemSettings()));

    public static final Item BAGUETTE = register("baguette", new BaguetteItem(QuoddToolMaterials.BREAD, 3, -2.4F, new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(7)
            .saturationModifier(0.6f)
            .build())));
    public static final Item HALF_BAGUETTE = register("half_baguette", new Item(new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.6f)
            .build())));


    public static Item basicItem(String name) {
        return register(name, new Item(new FabricItemSettings()));
    }

    public static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Quodd.MOD_ID, name), item);
    }

    public static void init() {
        Quodd.LOGGER.info("Registering items for " + Quodd.MOD_ID);
    }
}
