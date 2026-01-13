package net.jjrobot25.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jjrobot25.init.QuoddBlocks;
import net.jjrobot25.init.QuoddItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SingleItemRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class QuoddRecipeGen extends FabricRecipeProvider {
    public QuoddRecipeGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerReversableBriquetteRecipes(consumer, Items.COAL, QuoddItems.COAL_BRIQUETTE);
        offerReversableBriquetteRecipes(consumer, Items.CHARCOAL, QuoddItems.CHARCOAL_BRIQUETTE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, QuoddItems.BERRY_BOWL)
                .pattern("bbb")
                .pattern("bbb")
                .pattern(" B ")
                .input('b', Items.SWEET_BERRIES)
                .input('B', Items.BOWL)
                .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                .offerTo(consumer, new Identifier(getRecipeName(QuoddItems.BERRY_BOWL)));

//        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, QuoddItems.BONE_CLUB)
//                .pattern(" B ")
//                .pattern(" b ")
//                .pattern(" b ")
//                .input('b', Items.BONE)
//                .input('B', Items.BONE_BLOCK)
//                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
//                .offerTo(consumer, new Identifier(getRecipeName(QuoddItems.BONE_CLUB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, QuoddItems.BAGUETTE)
                .pattern("  B")
                .pattern(" B ")
                .pattern("B  ")
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(consumer, new Identifier(getRecipeName(QuoddItems.BAGUETTE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, QuoddItems.HALF_BAGUETTE, 2)
                .input(QuoddItems.BAGUETTE)
                .criterion(hasItem(QuoddItems.BAGUETTE), conditionsFromItem(QuoddItems.BAGUETTE))
                .offerTo(consumer, new Identifier(getRecipeName(QuoddItems.HALF_BAGUETTE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, QuoddItems.BROODJE_GEZOND)
                .input(TagKey.of(RegistryKeys.ITEM, new Identifier("c", "cheese")))
                .input(QuoddItems.HALF_BAGUETTE)
                .input(Items.EGG)
                .criterion(hasItem(QuoddItems.HALF_BAGUETTE), conditionsFromItem(QuoddItems.HALF_BAGUETTE))
                .offerTo(consumer, new Identifier(getRecipeName(QuoddItems.BROODJE_GEZOND)));

        offerSmelting(consumer, List.of(Items.MILK_BUCKET), RecipeCategory.FOOD, QuoddBlocks.FRESH_CHEESE_BLOCK, 0.1f, 200, "cheese");
        offerReversibleCompactingRecipes(consumer, RecipeCategory.FOOD, QuoddItems.YOUNG_CHEESE, RecipeCategory.BUILDING_BLOCKS, QuoddBlocks.YOUNG_CHEESE_BLOCK);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.FOOD, QuoddItems.MATURE_CHEESE, RecipeCategory.BUILDING_BLOCKS, QuoddBlocks.MATURE_CHEESE_BLOCK);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.FOOD, QuoddItems.OLD_CHEESE, RecipeCategory.BUILDING_BLOCKS, QuoddBlocks.OLD_CHEESE_BLOCK);

        offerSmelting(consumer, List.of(QuoddItems.GOAT_MILK_BUCKET), RecipeCategory.FOOD, QuoddBlocks.FRESH_GOAT_CHEESE_SLAB, 0.1f, 200, "goat_cheese");
        offerReversibleCompactingRecipes(consumer, RecipeCategory.FOOD, QuoddItems.GOAT_CHEESE, RecipeCategory.BUILDING_BLOCKS, QuoddBlocks.GOAT_CHEESE_SLAB);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.FOOD, QuoddItems.MOLD_GOAT_CHEESE, RecipeCategory.BUILDING_BLOCKS, QuoddBlocks.MOLD_GOAT_CHEESE_SLAB);
    }



    public void offerReversableBriquetteRecipes(Consumer<RecipeJsonProvider> consumer, Item base, Item briquette) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, briquette, 8)
                .input(base)
                .criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(consumer, new Identifier(getRecipeName(briquette)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, base, 1)
                .input(briquette, 8)
                .criterion(hasItem(briquette), conditionsFromItem(briquette))
                .offerTo(consumer, new Identifier(getRecipeName(base)));
    }
}
