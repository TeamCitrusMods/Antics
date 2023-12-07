package dev.teamcitrus.antics.world.surfacerule;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BiomeRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class AnticsSurfaceRuleData {
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource TUFF = makeStateRule(Blocks.TUFF);

    public static final ResourceKey<NormalNoise.NoiseParameters> SURFACE_VARIATION = ResourceKey.create(Registries.NOISE, Antics.id("surface_variation"));
    public static final ResourceKey<NormalNoise.NoiseParameters> LESS_SURFACE_VARIATION = ResourceKey.create(Registries.NOISE, Antics.id("less_surface_variation"));

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        SurfaceRules.RuleSource tuff = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(61), 0),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(LESS_SURFACE_VARIATION, 0.069D, 0.18D), TUFF)
                        )));

        SurfaceRules.RuleSource coarseDirt = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(61), 0),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(SURFACE_VARIATION, 0.069D, 0.18D), COARSE_DIRT)
                        )));
        SurfaceRules.RuleSource podzol = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(61), 0),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(SURFACE_VARIATION, 0.0420D, 0.18D), PODZOL)
                        )));

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(BiomeRegistry.GREAT_HEMLOCK_FOREST),
                        SurfaceRules.sequence(
                                SurfaceRules.sequence(coarseDirt, podzol),
                                SurfaceRules.sequence(tuff),

                                // Default to a grass and dirt surface
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(
                                        SurfaceRules.yStartCheck(VerticalAnchor.absolute(61), 0),
                                        grassSurface
                                ))
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
