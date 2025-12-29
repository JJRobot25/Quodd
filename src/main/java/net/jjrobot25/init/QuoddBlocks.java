package net.jjrobot25.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jjrobot25.Quodd;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class QuoddBlocks {
    public static final Block TEST_BLOCK = registerBlock("test_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block FRESH_CHEESE_BLOCK = registerBlock(
            "fresh_cheese_block",
            new OxidizableBlock(
                    Oxidizable.OxidationLevel.OXIDIZED,
                    AbstractBlock.Settings.create().mapColor(MapColor.TEAL).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.COPPER)
            )
    );


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Quodd.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Quodd.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void init() {
        Quodd.LOGGER.info("Registering blocks for " + Quodd.MOD_ID);
    }
}
