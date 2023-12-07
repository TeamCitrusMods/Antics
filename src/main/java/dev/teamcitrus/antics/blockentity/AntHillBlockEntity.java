package dev.teamcitrus.antics.blockentity;

import dev.teamcitrus.antics.entity.AntEntity;
import dev.teamcitrus.antics.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AntHillBlockEntity extends BlockEntity {
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

    public void addOccupant(Entity pOccupant, boolean pHasMushroom) {
        this.addOccupantWithPresetTicks(pOccupant, pHasMushroom, 0);
    }

    public int getOccupantCount() {
        return this.stored.size();
    }

    public void addOccupantWithPresetTicks(Entity pOccupant, boolean pHasMushroom, int pTicksInHill) {
        if (this.stored.size() < 3) {
            pOccupant.stopRiding();
            pOccupant.ejectPassengers();
            CompoundTag compoundtag = new CompoundTag();
            pOccupant.save(compoundtag);
            this.storeAnt(compoundtag, pTicksInHill, pHasMushroom);
            if (this.level != null) {
                BlockPos blockpos = this.getBlockPos();
                this.level.playSound(null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), SoundEvents.BEEHIVE_ENTER, SoundSource.BLOCKS, 1.0F, 1.0F);
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(pOccupant, this.getBlockState()));
            }

            pOccupant.discard();
            super.setChanged();
        }
    }

    public void storeAnt(CompoundTag pEntityData, int pTicksInHill, boolean pHasMushroom) {
        this.stored.add(new AntData(pEntityData, pTicksInHill, pHasMushroom ? 2400 : 600));
    }

    private static boolean releaseOccupant(Level pLevel, BlockPos pPos, BlockState pState, AntData pData, @Nullable List<Entity> pStoredInHives) {
        if ((pLevel.isNight() || pLevel.isRaining())) {
            return false;
        } else {
            CompoundTag compoundtag = pData.entityData.copy();
            compoundtag.put("HivePos", NbtUtils.writeBlockPos(pPos));
            compoundtag.putBoolean("NoGravity", true);
            BlockPos blockpos = pPos.above();
            boolean flag = !pLevel.getBlockState(blockpos).getCollisionShape(pLevel, blockpos).isEmpty();
            if (flag) {
                return false;
            } else {
                Entity entity = EntityType.loadEntityRecursive(compoundtag, pLevel, (entity1) -> entity1);
                if (entity != null) {
                    if (entity instanceof AntEntity ant) {
                        if (pStoredInHives != null) {
                            pStoredInHives.add(ant);
                        }

                        float f = entity.getBbWidth();
                        double d3 = 0.55D + (f / 2.0F);
                        double d0 = pPos.getX() + 0.5D + d3;
                        double d1 = pPos.getY() + 0.5D - (entity.getBbHeight() / 2.0F);
                        double d2 = pPos.getZ() + 0.5D + d3;
                        entity.moveTo(d0, d1, d2, entity.getYRot(), entity.getXRot());
                    }

                    pLevel.playSound(null, pPos, SoundEvents.BEEHIVE_EXIT, SoundSource.BLOCKS, 1.0F, 1.0F);
                    pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(entity, pLevel.getBlockState(pPos)));
                    return pLevel.addFreshEntity(entity);
                } else {
                    return false;
                }
            }
        }
    }

    private static void tickOccupants(Level pLevel, BlockPos pPos, BlockState pState, List<AntData> pData) {
        boolean flag = false;

        AntData antData;
        for(Iterator<AntData> iterator = pData.iterator(); iterator.hasNext(); ++antData.ticksInHill) {
            antData = iterator.next();
            if (antData.ticksInHill > antData.minOccupationTicks) {
                if (releaseOccupant(pLevel, pPos, pState, antData, null)) {
                    flag = true;
                    iterator.remove();
                }
            }
        }

        if (flag) {
            setChanged(pLevel, pPos, pState);
        }
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, AntHillBlockEntity pBeehive) {
        tickOccupants(pLevel, pPos, pState, pBeehive.stored);
        if (!pBeehive.stored.isEmpty() && pLevel.getRandom().nextDouble() < 0.005D) {
            double d0 = pPos.getX() + 0.5D;
            double d1 = pPos.getY();
            double d2 = pPos.getZ() + 0.5D;
            pLevel.playSound(null, d0, d1, d2, SoundEvents.BEEHIVE_WORK, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.stored.clear();
        ListTag listtag = pTag.getList("Ants", 10);

        for(int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            AntData antData = new AntData(compoundtag.getCompound("EntityData"), compoundtag.getInt("TicksInHill"), compoundtag.getInt("MinOccupationTicks"));
            this.stored.add(antData);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("Ants", this.writeAnts());
    }

    public ListTag writeAnts() {
        ListTag listtag = new ListTag();

        for(AntData antData : this.stored) {
            CompoundTag compoundtag = antData.entityData.copy();
            compoundtag.remove("UUID");
            CompoundTag compoundtag1 = new CompoundTag();
            compoundtag1.put("EntityData", compoundtag);
            compoundtag1.putInt("TicksInHill", antData.ticksInHill);
            compoundtag1.putInt("MinOccupationTicks", antData.minOccupationTicks);
            listtag.add(compoundtag1);
        }

        return listtag;
    }

    static class AntData {
        final CompoundTag entityData;
        int ticksInHill;
        final int minOccupationTicks;

        public AntData(CompoundTag pEntityData, int pTicksInHill, int pMinOccupationTicks) {
            this.entityData = pEntityData;
            this.ticksInHill = pTicksInHill;
            this.minOccupationTicks = pMinOccupationTicks;
        }
    }
}
