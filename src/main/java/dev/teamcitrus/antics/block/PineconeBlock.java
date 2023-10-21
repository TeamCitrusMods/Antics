package dev.teamcitrus.antics.block;

import dev.teamcitrus.antics.registry.BlockRegistry;
import dev.teamcitrus.antics.registry.DamageTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class PineconeBlock extends Block implements Fallable {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");

    private static final VoxelShape UP_HITBOX = Stream.of(
            Block.box(0, 0, 0, 16, 16, 16),
            Block.box(2, 16, 2, 14, 21, 14),
            Block.box(4, 21, 4, 12, 26, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape DOWN_HITBOX = Stream.of(
            Block.box(0, 0, 0, 16, 16, 16),
            Block.box(2, -5, 2, 14, 0, 14),
            Block.box(4, -10, 4, 12, -5, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape NORTH_HITBOX = Stream.of(
            Block.box(0, 0, 0, 16, 16, 16),
            Block.box(2, 2, -5, 14, 14, 0),
            Block.box(4, 4, -10, 12, 12, -5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape EAST_HITBOX = Stream.of(
            Block.box(0, 0, 0, 16, 16, 16),
            Block.box(16, 2, 2, 21, 14, 14),
            Block.box(21, 4, 4, 26, 12, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SOUTH_HITBOX = Stream.of(
            Block.box(0, 0, 0, 16, 16, 16),
            Block.box(2, 2, 16, 14, 14, 21),
            Block.box(4, 4, 21, 12, 12, 26)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape WEST_HITBOX = Stream.of(
            Block.box(0, 0, 0, 16, 16, 16),
            Block.box(-5, 2, 2, 0, 14, 14),
            Block.box(-10, 4, 4, -5, 12, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public PineconeBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.DOWN).setValue(PLAYER_PLACED, false));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case NORTH -> {
                return NORTH_HITBOX;
            }
            case EAST -> {
                return EAST_HITBOX;
            }
            case SOUTH -> {
                return SOUTH_HITBOX;
            }
            case WEST -> {
                return WEST_HITBOX;
            }
            case UP -> {
                return UP_HITBOX;
            }
            default -> {
                return DOWN_HITBOX;
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getClickedFace());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, PLAYER_PLACED);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(PLAYER_PLACED, true));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (!pState.getValue(PLAYER_PLACED)) {
            pLevel.scheduleTick(pPos, this, 2);
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.isClientSide() && !pState.getValue(PLAYER_PLACED)) {
            if (isFree(pLevel.getBlockState(pPos.above())) && pPos.getY() >= pLevel.getMinBuildHeight()) {
                FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(pLevel, pPos, pState);
                fallingblockentity.setHurtsEntities(0.5F, 15);
            }
        }
    }

    @Override
    public DamageSource getFallDamageSource(Entity pEntity) {
        return DamageTypeRegistry.of(pEntity.level(), DamageTypeRegistry.FALLING_PINECONE);
    }

    @Override
    public void onLand(Level pLevel, BlockPos pPos, BlockState pState, BlockState pReplaceableState, FallingBlockEntity pFallingBlock) {
        pLevel.setBlockAndUpdate(pPos, BlockRegistry.EMPTY_PINECONE_BLOCK.get().defaultBlockState().setValue(FACING, pState.getValue(FACING)));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(BlockRegistry.PINECONE_BLOCK.get())) {
                return BlockRegistry.EMPTY_PINECONE_BLOCK.get().defaultBlockState().setValue(FACING, state.getValue(FACING));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

    private boolean isFree(BlockState pState) {
        return !(pState.getBlock() instanceof BranchBlock);
    }
}