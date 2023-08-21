package dev.teamcitrus.antics.block;

import dev.teamcitrus.antics.registry.RABlockRegistry;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class RAPillarWoodBlock extends RotatedPillarBlock {
    public RAPillarWoodBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(RABlockRegistry.GREAT_HEMLOCK_LOG.get())) {
                return RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(RABlockRegistry.GREAT_HEMLOCK_WOOD.get())) {
                return RABlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
