package net.jjrobot25.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThomasTotemItem extends Item {
    public ThomasTotemItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()) {
            user.clearStatusEffects();
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 4, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 6000, 0, false, false));

            user.getStackInHand(hand).decrement(1);


        }
        return super.use(world, user, hand);
    }
}
