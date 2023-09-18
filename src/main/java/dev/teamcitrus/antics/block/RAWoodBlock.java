package dev.teamcitrus.antics.block;

import dev.teamcitrus.antics.registry.BlockRegistry;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class RAWoodBlock extends Block {
    public RAWoodBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(BlockRegistry.GREAT_HEMLOCK_WOOD.get())) {
                return BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get().defaultBlockState();
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
