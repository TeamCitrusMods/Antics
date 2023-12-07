package dev.teamcitrus.antics.block.sign;

import dev.teamcitrus.antics.blockentity.signs.RAHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class RAHangingSign {
    public static class CustomCeilingHangingSignBlock extends CeilingHangingSignBlock {
        public CustomCeilingHangingSignBlock(Properties properties, WoodType woodType) {
            super(properties, woodType);
        }

        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new RAHangingSignBlockEntity(pPos, pState);
        }
    }

    public static class CustomWallHangingSignBlock extends WallHangingSignBlock {
        public CustomWallHangingSignBlock(Properties properties, WoodType woodType) {
            super(properties, woodType);
        }

        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new RAHangingSignBlockEntity(pPos, pState);
        }
    }
}
