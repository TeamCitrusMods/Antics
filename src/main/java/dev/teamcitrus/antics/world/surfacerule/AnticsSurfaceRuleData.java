package dev.teamcitrus.antics.world.surfacerule;

import dev.teamcitrus.antics.registry.BiomeRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class AnticsSurfaceRuleData {
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);

    public static SurfaceRules.RuleSource makeRules() {
        //SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource8 = SurfaceRules.waterBlockCheck(0, 0);
        //SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(BiomeRegistry.GREAT_HEMLOCK_FOREST),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL)
                        )
                ),
                SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, GRASS_BLOCK), DIRT)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double pValue) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, pValue / 8.25D, Double.MAX_VALUE);
    }
}
