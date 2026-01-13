package net.jjrobot25.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jjrobot25.Quodd;
import net.jjrobot25.block.cheese.*;
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
            new FreshCheesableBlock(
                    Cheesable.CheeseLevel.FRESH, //like slimeblock
                    AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(1.0F, 2.0F).sounds(BlockSoundGroup.SLIME)
            )
    );
    public static final Block YOUNG_CHEESE_BLOCK = registerBlock(
            "young_cheese_block",
            new CheesableBlock(
                    Cheesable.CheeseLevel.YOUNG,
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block MATURE_CHEESE_BLOCK = registerBlock(
            "mature_cheese_block",
            new CheesableBlock(
                    Cheesable.CheeseLevel.MATURE,
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.WOOD)
            )
    );
    public static final Block OLD_CHEESE_BLOCK = registerBlock(
            "old_cheese_block",
            new CheesableBlock(
                    Cheesable.CheeseLevel.OLD,
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(4.0F, 3.0F).sounds(BlockSoundGroup.WOOD)
            )
    );

    public static final Block FRESH_GOAT_CHEESE_SLAB = registerBlock(
            "fresh_goat_cheese_slab",
            new FreshCheesableSlabBlock(
                    Cheesable.CheeseLevel.FRESH,
                    FabricBlockSettings.copyOf(FRESH_CHEESE_BLOCK)
            )
    );
    public static final Block GOAT_CHEESE_SLAB = registerBlock(
            "goat_cheese_slab",
            new CheesableSlabBlock(
                    Cheesable.CheeseLevel.YOUNG,
                    FabricBlockSettings.copyOf(FRESH_CHEESE_BLOCK)
            )
    );
    public static final Block MOLD_GOAT_CHEESE_SLAB = registerBlock(
            "mold_goat_cheese_slab",
            new CheesableSlabBlock(
                    Cheesable.CheeseLevel.MATURE,
                    FabricBlockSettings.copyOf(FRESH_CHEESE_BLOCK)
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
