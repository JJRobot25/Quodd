package net.jjrobot25.block.cheese;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.block.*;

import java.util.Optional;
import java.util.function.Supplier;

public interface Cheesable extends Degradable<Cheesable.CheeseLevel> {
    Supplier<BiMap<Block, Block>> CHEESE_LEVEL_INCREASES = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER)
                    .put(Blocks.EXPOSED_COPPER, Blocks.WEATHERED_COPPER)
                    .put(Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER)
                    .put(Blocks.CUT_COPPER, Blocks.EXPOSED_CUT_COPPER)
                    .put(Blocks.EXPOSED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER)
                    .put(Blocks.WEATHERED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER)
                    .put(Blocks.CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB)
                    .put(Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_SLAB)
                    .put(Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_SLAB)
                    .put(Blocks.CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS)
                    .put(Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER_STAIRS)
                    .put(Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.OXIDIZED_CUT_COPPER_STAIRS)
                    .build()
    );
    Supplier<BiMap<Block, Block>> CHEESE_LEVEL_DECREASES = Suppliers.memoize(() -> ((BiMap) CHEESE_LEVEL_INCREASES.get()).inverse());

    static Optional<Block> getDecreasedCheeseBlock(Block block) {
        return Optional.ofNullable((Block)((BiMap) CHEESE_LEVEL_DECREASES.get()).get(block));
    }

    static Block getUnaffectedCheeseBlock(Block block) {
        Block block2 = block;

        for (Block block3 = (Block)((BiMap) CHEESE_LEVEL_DECREASES.get()).get(block);
             block3 != null;
             block3 = (Block)((BiMap) CHEESE_LEVEL_DECREASES.get()).get(block3)
        ) {
            block2 = block3;
        }

        return block2;
    }

    static Optional<BlockState> getDecreasedCheeseState(BlockState state) {
        return getDecreasedCheeseBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    static Optional<Block> getIncreasedCheeseBlock(Block block) {
        return Optional.ofNullable((Block)((BiMap) CHEESE_LEVEL_INCREASES.get()).get(block));
    }

    static BlockState getUnaffectedCheeseState(BlockState state) {
        return getUnaffectedCheeseBlock(state.getBlock()).getStateWithProperties(state);
    }

    @Override
    default Optional<BlockState> getDegradationResult(BlockState state) {
        return getIncreasedCheeseBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    @Override
    default float getDegradationChanceMultiplier() {
        return this.getDegradationLevel() == CheeseLevel.FRESH ? 0.75F : 1.0F;
    }



    public static enum CheeseLevel {
        FRESH,
        YOUNG,
        MATURE,
        OLD;
    }
}
