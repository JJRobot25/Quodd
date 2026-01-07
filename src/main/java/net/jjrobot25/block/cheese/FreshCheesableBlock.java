package net.jjrobot25.block.cheese;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FreshCheesableBlock extends CheesableBlock{
    public FreshCheesableBlock(CheeseLevel cheeseLevel, Settings settings) {
        super(cheeseLevel, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.quodd.fresh_cheese").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
