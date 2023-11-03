package dev.teamcitrus.antics.entity.signs;

import dev.teamcitrus.antics.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RAHangingSignBlockEntity extends HangingSignBlockEntity {
    public RAHangingSignBlockEntity(BlockPos pPos, BlockState pState) {
        super(pPos, pState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockEntityRegistry.RA_HANGING_SIGN_BLOCK.get();
    }
}
