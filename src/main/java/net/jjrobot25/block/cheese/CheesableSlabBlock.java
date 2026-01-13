package net.jjrobot25.block.cheese;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

// Copy of `OxidizableBlock`
public class CheesableSlabBlock extends SlabBlock implements Cheesable {
    private final CheeseLevel cheeseLevel;

    public CheesableSlabBlock(CheeseLevel cheeseLevel, Settings settings) {
        super(settings);
        this.cheeseLevel = cheeseLevel;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Cheesable.getIncreasedCheeseBlock(state.getBlock()).isPresent();
    }

    public CheeseLevel getDegradationLevel() {
        return this.cheeseLevel;
    }
}
