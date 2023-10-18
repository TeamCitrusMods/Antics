package dev.teamcitrus.antics.world.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.teamcitrus.antics.registry.BlockRegistry;
import dev.teamcitrus.antics.world.AnticsTreeDecoratorType;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PineconeAttachedToLeavesDecorator extends AttachedToLeavesDecorator {
    public static final Codec<PineconeAttachedToLeavesDecorator> CODEC = RecordCodecBuilder.create((p_225996_) -> {
        return p_225996_.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((p_226014_) -> {
            return p_226014_.probability;
        }), Codec.intRange(0, 16).fieldOf("exclusion_radius_xz").forGetter((p_226012_) -> {
            return p_226012_.exclusionRadiusXZ;
        }), Codec.intRange(0, 16).fieldOf("exclusion_radius_y").forGetter((p_226010_) -> {
            return p_226010_.exclusionRadiusY;
        }), BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((p_226008_) -> {
            return p_226008_.blockProvider;
        }), Codec.intRange(1, 16).fieldOf("required_empty_blocks").forGetter((p_226006_) -> {
            return p_226006_.requiredEmptyBlocks;
        }), ExtraCodecs.nonEmptyList(Direction.CODEC.listOf()).fieldOf("directions").forGetter((p_225998_) -> {
            return p_225998_.directions;
        })).apply(p_225996_, PineconeAttachedToLeavesDecorator::new);
    });

    public PineconeAttachedToLeavesDecorator(float p_225988_, int p_225989_, int p_225990_, BlockStateProvider p_225991_, int p_225992_, List<Direction> p_225993_) {
        super(p_225988_, p_225989_, p_225990_, p_225991_, p_225992_, p_225993_);
    }

    @Override
    public void place(Context pContext) {
        Set<BlockPos> set = new HashSet<>();
        RandomSource randomsource = pContext.random();

        for(BlockPos blockpos : Util.shuffledCopy(pContext.leaves(), randomsource)) {
            Direction direction = Util.getRandom(this.directions, randomsource);
            BlockPos blockpos1 = blockpos.relative(direction);
            if (!set.contains(blockpos1) && randomsource.nextFloat() < this.probability && this.hasRequiredEmptyBlocks(pContext, blockpos, direction)) {
                BlockPos blockpos2 = blockpos1.offset(-this.exclusionRadiusXZ, -this.exclusionRadiusY, -this.exclusionRadiusXZ);
                BlockPos blockpos3 = blockpos1.offset(this.exclusionRadiusXZ, this.exclusionRadiusY, this.exclusionRadiusXZ);

                for(BlockPos blockpos4 : BlockPos.betweenClosed(blockpos2, blockpos3)) {
                    set.add(blockpos4.immutable());
                }

                pContext.setBlock(blockpos1, this.blockProvider.getState(randomsource, blockpos1));

                boolean b = false;

                if (randomsource.nextInt(4) == 0) {
                    pContext.setBlock(blockpos1.below(), this.blockProvider.getState(randomsource, blockpos1));
                    b = true;
                }

                pContext.setBlock(b ? blockpos1.below(2) : blockpos1.below(), BlockRegistry.PINECONE_BLOCK.get().defaultBlockState());
            }
        }
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return AnticsTreeDecoratorType.PINECONE_ATTACHED_TO_LEAVES.get();
    }
}
