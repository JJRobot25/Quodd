package net.jjrobot25.item;

import net.jjrobot25.init.QuoddItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class BaguetteItem extends SwordItem {

    public BaguetteItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        return user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode ? itemStack : new ItemStack(QuoddItems.HALF_BAGUETTE);
    }
}
