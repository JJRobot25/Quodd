package net.jjrobot25.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jjrobot25.init.QuoddBlocks;
import net.jjrobot25.init.QuoddItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class QuoddModelGen extends FabricModelProvider {
    public QuoddModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(QuoddBlocks.TEST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(QuoddBlocks.FRESH_CHEESE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(QuoddBlocks.YOUNG_CHEESE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(QuoddBlocks.MATURE_CHEESE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(QuoddBlocks.OLD_CHEESE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(QuoddItems.COAL_BRIQUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.CHARCOAL_BRIQUETTE, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.THOMAS_TOTEM, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BLADE_OF_GRASS, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BERRY_BOWL, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.HALF_BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BROODJE_GEZOND, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.SAUSAGE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.HOTDOG, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.GOAT_MILK_BUCKET, Models.GENERATED);
    }
}
