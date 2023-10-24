package dev.teamcitrus.antics.block.sign;

import dev.teamcitrus.antics.entity.RASignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class RAStandingSignBlock extends StandingSignBlock {
    public RAStandingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new RASignBlockEntity(pPos, pState);
    }
}
