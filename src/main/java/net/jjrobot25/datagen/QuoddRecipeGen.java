package net.jjrobot25.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jjrobot25.init.QuoddItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class QuoddRecipeGen extends FabricRecipeProvider {
    public QuoddRecipeGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerReversableBriquetteRecipes(consumer, Items.COAL, QuoddItems.COAL_BRIQUETTE);
        offerReversableBriquetteRecipes(consumer, Items.CHARCOAL, QuoddItems.CHARCOAL_BRIQUETTE);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, QuoddItems.HALF_BAGUETTE, 2)
                .input(QuoddItems.BAGUETTE)
                .criterion(hasItem(QuoddItems.BAGUETTE), conditionsFromItem(QuoddItems.BAGUETTE))
                .offerTo(consumer, new Identifier(getRecipeName(QuoddItems.HALF_BAGUETTE)));
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
