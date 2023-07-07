package dev.teamcitrus.resourceants.block;

import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import dev.teamcitrus.resourceants.util.MushroomResourceTiers;
import dev.teamcitrus.resourceants.util.RABlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class ResourceMushroomBlock extends BushBlock {
    private static final List<ResourceMushroomBlock> LIST = new ArrayList<>();
    private final int mushroomColor;
    private final int stemColor;
    private final MushroomResourceTiers tier;

    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 10, 12);

    public ResourceMushroomBlock(int mushroomColor, int stemColor, MushroomResourceTiers tier) {
        super(Properties.copy(Blocks.BROWN_MUSHROOM));

        this.mushroomColor = mushroomColor;
        this.stemColor = stemColor;
        this.tier = tier;

        LIST.add(this);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(RABlockTags.ALL_MUSHROOM_PLANTABLE)
                || this == RABlockRegistry.NETHER_QUARTZ_MUSHROOM.get() ? pState.is(BlockTags.BASE_STONE_NETHER) : super.mayPlaceOn(pState, pLevel, pPos)
                || this == RABlockRegistry.NETHERITE_MUSHROOM.get() ? pState.is(BlockTags.BASE_STONE_NETHER) : super.mayPlaceOn(pState, pLevel, pPos);
    }

    @Override
    public int getSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
        return pState.getBlock() == RABlockRegistry.REDSTONE_MUSHROOM.get() && pDirection != Direction.UP ? 3 : 0;
    }

    @Override
    public int getDirectSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
        return pDirection != Direction.DOWN && pDirection != Direction.UP ? getSignal(pState, pLevel, pPos, pDirection) : 0;
    }

    @Override
    public boolean isSignalSource(BlockState pState) {
        return pState.getBlock() == RABlockRegistry.REDSTONE_MUSHROOM.get();
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getBlock() == RABlockRegistry.REDSTONE_MUSHROOM.get() ? 3 : 0;
    }

    public int getColor(int pTintIndex) {
        return pTintIndex == 0 ? this.mushroomColor : this.stemColor;
    }

    public MushroomResourceTiers getTier() {
        return this.tier;
    }

    public static List<ResourceMushroomBlock> getAllMushrooms() {
        return LIST;
    }
}
