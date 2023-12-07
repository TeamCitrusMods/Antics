package dev.teamcitrus.antics.blockentity;

import dev.teamcitrus.antics.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class AntHillBlockEntity extends BlockEntity {
    public static final String ANTS = "Ants";
    private final List<AntData> stored = new ArrayList<>();

    public AntHillBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.ANTHILL.get(), pPos, pBlockState);
    }

    public boolean isEmpty() {
        return this.stored.isEmpty();
    }

    public boolean isFull() {
        return this.stored.size() == 3;
    }

    static class AntData {
        final CompoundTag entityData;
        int ticksInHill;

        public AntData(CompoundTag entityData, int ticksInHill) {
            this.entityData = entityData;
            this.ticksInHill = ticksInHill;
        }
    }
}
