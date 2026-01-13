package net.jjrobot25.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jjrobot25.init.QuoddBlocks;
import net.jjrobot25.init.QuoddItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

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

        registerSlab(QuoddBlocks.FRESH_GOAT_CHEESE_SLAB, blockStateModelGenerator);
        registerSlab(QuoddBlocks.GOAT_CHEESE_SLAB, blockStateModelGenerator);
        registerSlab(QuoddBlocks.MOLD_GOAT_CHEESE_SLAB, blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(QuoddItems.COAL_BRIQUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.CHARCOAL_BRIQUETTE, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.THOMAS_TOTEM, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BLADE_OF_GRASS, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BERRY_BOWL, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.HALF_BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BROODJE_GEZOND, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.SAUSAGE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.HOTDOG, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.YOUNG_CHEESE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.MATURE_CHEESE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.OLD_CHEESE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.GOAT_CHEESE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.MOLD_GOAT_CHEESE, Models.GENERATED);


        itemModelGenerator.register(QuoddItems.GOAT_MILK_BUCKET, Models.GENERATED);
    }

    public void registerSlab(Block slab, BlockStateModelGenerator bsmg) {
        TextureMap textureMap = TextureMap.sideEnd(TextureMap.getSubId(slab, "_side"), TextureMap.getId(slab));
        Identifier identifier_bottom = Models.SLAB.upload(slab, textureMap, bsmg.modelCollector);
        Identifier identifier_top = Models.SLAB_TOP.upload(slab, textureMap, bsmg.modelCollector);
        Identifier identifier_double = Models.CUBE_COLUMN.uploadWithoutVariant(slab, "_double", textureMap, bsmg.modelCollector);
        bsmg.blockStateCollector.accept(bsmg.createSlabBlockState(slab, identifier_bottom, identifier_top, identifier_double));
    }
}
