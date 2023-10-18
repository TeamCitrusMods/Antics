package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.world.tree.decorators.PineconeAttachedToLeavesDecorator;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class ConfiguredFeaturesRegistry {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREAT_HEMLOCK_KEY = registerKey("great_hemlock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HEMLOCK_FLOWER = registerKey("hemlock_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HEMLOCK_ROCK = registerKey("hemlock_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_BASIN = registerKey("water_basin");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, GREAT_HEMLOCK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegistry.GREAT_HEMLOCK_LOG.get()),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.simple(BlockRegistry.GREAT_HEMLOCK_LEAVES.get()),
                new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)),
                new TwoLayersFeatureSize(1, 1, 2))
                .decorators(List.of(new PineconeAttachedToLeavesDecorator(0.05F, 1, 0, BlockStateProvider.simple(BlockRegistry.BRANCH.get()), 4, List.of(Direction.DOWN))))
                .build());

        register(context,
                HEMLOCK_FLOWER,
                Feature.FLOWER,
                new RandomPatchConfiguration(64, 7, 3,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                                .add(Blocks.POPPY.defaultBlockState(), 2)
                                                .add(Blocks.RED_TULIP.defaultBlockState(), 2)
                                                .add(Blocks.ROSE_BUSH.defaultBlockState(), 1)
                                                .build()
                                        ))
                                )
                        )
        );

        register(context, HEMLOCK_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.TUFF.defaultBlockState()));

        register(context, WATER_BASIN, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.WATER.defaultBlockState()), BlockStateProvider.simple(Blocks.MUD.defaultBlockState())));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Antics.id(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
