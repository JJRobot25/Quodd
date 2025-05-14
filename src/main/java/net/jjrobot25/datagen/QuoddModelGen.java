package net.jjrobot25.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(QuoddItems.COAL_BRIQUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.CHARCOAL_BRIQUETTE, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.THOMAS_TOTEM, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.BLADE_OF_GRASS, Models.GENERATED);

        itemModelGenerator.register(QuoddItems.BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(QuoddItems.HALF_BAGUETTE, Models.GENERATED);
    }
}
