package dev.teamcitrus.resourceants.item;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.block.ResourceMushroomBlock;
import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import dev.teamcitrus.resourceants.util.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ResourceMushroomItem extends BlockItem {
    public ResourceMushroomItem(ResourceMushroomBlock pBlock) {
        super(pBlock, new Properties().tab(ResourceAnts.TAB));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(new Tooltip("tooltip.resourceants.tier").args(((ResourceMushroomBlock)getBlock()).getTier().getDisplayName()).build());
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return itemStack.getItem() == RABlockRegistry.COAL_MUSHROOM.get().asItem() ? 200 : 0;
    }

    @Override
    public boolean isPiglinCurrency(ItemStack stack) {
        return stack.getItem() == RABlockRegistry.GOLD_MUSHROOM.get().asItem();
    }

    @Override
    public boolean isFireResistant() {
        return this == RABlockRegistry.NETHERITE_MUSHROOM.get().asItem();
    }
}
