package dev.teamcitrus.antics.block;

import dev.teamcitrus.antics.blockentity.AntHillBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class AntHillBlock extends BaseEntityBlock {
    public AntHillBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new AntHillBlockEntity(pPos, pState);
    }
}
