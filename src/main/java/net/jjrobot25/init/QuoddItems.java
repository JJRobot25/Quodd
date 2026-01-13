package net.jjrobot25.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jjrobot25.Quodd;
import net.jjrobot25.item.BaguetteItem;
import net.jjrobot25.item.QuoddToolMaterials;
import net.jjrobot25.item.ThomasTotemItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class QuoddItems {
    public static final Item COAL_BRIQUETTE = basicItem("coal_briquette");
    public static final Item CHARCOAL_BRIQUETTE = basicItem("charcoal_briquette");

    public static final Item THOMAS_TOTEM = register("thomas_totem", new ThomasTotemItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item BLADE_OF_GRASS = register("blade_of_grass", new SwordItem(QuoddToolMaterials.GRASS, 3, -2.4F, new FabricItemSettings()));
    public static final Item BERRY_BOWL = bowlFood("berry_bowl", 6, 0.5f);
    //TODO: bone club

    public static final Item BAGUETTE = register("baguette", new BaguetteItem(QuoddToolMaterials.BREAD, 3, -2.4F, new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(7).saturationModifier(0.6f).build())));
    public static final Item HALF_BAGUETTE = basicFood("half_baguette", 7, 0.6f);
    public static final Item BROODJE_GEZOND = basicFood("broodje_gezond", 10, 0.8f);

    // Base: casing (intestines/synthetic eg collagen/cellulose), inject meat, combine spices
    public static final Item SAUSAGE = basicFood("suspicious_sausage", 4, 0.3f);
    public static final Item HOTDOG = basicFood("hotdog", 6, 0.5f);

    public static final Item YOUNG_CHEESE = basicFood("young_cheese", 2, 0.5f);
    public static final Item MATURE_CHEESE = basicFood("mature_cheese", 2, 0.5f);
    public static final Item OLD_CHEESE = basicFood("old_cheese", 2, 0.5f);
    public static final Item GOAT_CHEESE = basicFood("goat_cheese", 2, 0.5f);
    public static final Item MOLD_GOAT_CHEESE = basicFood("mold_goat_cheese", 2, 0.5f);


    // TODO: virtual fluid?
    public static final Item GOAT_MILK_BUCKET = register("goat_milk_bucket", new MilkBucketItem(new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));


    public static Item basicItem(String name) {
        return register(name, new Item(new FabricItemSettings()));
    }

    public static Item basicFood(String name, int hunger, float saturation) {
        return register(name, new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
    }

    public static Item bowlFood(String name, int hunger, float saturation) {
        return register(name, new StewItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
    }

    public static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Quodd.MOD_ID, name), item);
    }

    public static void init() {
        Quodd.LOGGER.info("Registering items for " + Quodd.MOD_ID);
    }
}
