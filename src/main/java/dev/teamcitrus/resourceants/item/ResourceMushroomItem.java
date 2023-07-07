package dev.teamcitrus.resourceants.item;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ResourceMushroomItem extends BlockItem {
    private static final List<ResourceMushroomItem> LIST = new ArrayList<>();

    public ResourceMushroomItem(Block pBlock) {
        super(pBlock, new Properties().tab(ResourceAnts.TAB));

        LIST.add(this);
    }

    public static List<ResourceMushroomItem> getAllMushrooms() {
        return LIST;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return itemStack.getItem() == RABlockRegistry.COAL_MUSHROOM.get().asItem() ? 200 : 0;
    }
}
