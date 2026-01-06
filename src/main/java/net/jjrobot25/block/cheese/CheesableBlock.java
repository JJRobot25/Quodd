package net.jjrobot25.block.cheese;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

// Copy of `OxidizableBlock`
public class CheesableBlock extends Block implements Cheesable {
    private final Cheesable.CheeseLevel cheeseLevel;

    public CheesableBlock(Cheesable.CheeseLevel cheeseLevel, AbstractBlock.Settings settings) {
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

    public Cheesable.CheeseLevel getDegradationLevel() {
        return this.cheeseLevel;
    }
}
