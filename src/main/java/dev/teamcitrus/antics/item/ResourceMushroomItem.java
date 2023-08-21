package dev.teamcitrus.antics.item;

import dev.teamcitrus.antics.block.ResourceMushroomBlock;
import dev.teamcitrus.antics.util.Localizable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ResourceMushroomItem extends BlockItem {
    public ResourceMushroomItem(Block pBlock) {
        super(pBlock, new Properties());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(new Localizable("tooltip.antics.tier").args(((ResourceMushroomBlock)getBlock()).getTier().getLocalDisplayName()).build());
    }
}
