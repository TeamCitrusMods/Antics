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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ResourceMushroomItem extends BlockItem {
    private final ResourceMushroomBlock block;

    private static final Tooltip TIER = new Tooltip("tooltip.resourceants.tier");

    public ResourceMushroomItem(ResourceMushroomBlock pBlock) {
        super(pBlock, new Properties().tab(ResourceAnts.TAB).rarity(pBlock.getTier().getRarity()));
        this.block = pBlock;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        var arg = block.getTier().getDisplayName();

        pTooltip.add(TIER.args(arg).build());
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return itemStack.getItem() == RABlockRegistry.COAL_MUSHROOM.get().asItem() ? 200 : 0;
    }

    @Override
    public boolean isFireResistant() {
        return this == RABlockRegistry.NETHERITE_MUSHROOM.get().asItem();
    }
}
