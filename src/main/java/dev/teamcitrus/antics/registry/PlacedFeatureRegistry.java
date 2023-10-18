package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PlacedFeatureRegistry {
    public static final ResourceKey<PlacedFeature> GREAT_HEMLOCK_TREE_CHECKED = createKey("great_hemlock_tree");
    public static final ResourceKey<PlacedFeature> HEMLOCK_FLOWER_CHECKED = createKey("hemlock_flower");
    public static final ResourceKey<PlacedFeature> HEMLOCK_ROCK_CHECKED = createKey("hemlock_rock");
    public static final ResourceKey<PlacedFeature> WATER_BASIN_CHECKED = createKey("water_basin");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> GREAT_HEMLOCK_TREE = getter.getOrThrow(ConfiguredFeaturesRegistry.GREAT_HEMLOCK_KEY);
        Holder<ConfiguredFeature<?, ?>> HEMLOCK_FLOWER = getter.getOrThrow(ConfiguredFeaturesRegistry.HEMLOCK_FLOWER);
        Holder<ConfiguredFeature<?, ?>> HEMLOCK_ROCK = getter.getOrThrow(ConfiguredFeaturesRegistry.HEMLOCK_ROCK);
        Holder<ConfiguredFeature<?, ?>> WATER_BASIN = getter.getOrThrow(ConfiguredFeaturesRegistry.WATER_BASIN);

        register(context, GREAT_HEMLOCK_TREE_CHECKED,
                GREAT_HEMLOCK_TREE,
                List.of(
                        CountPlacement.of(7),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        PlacementUtils.filteredByBlockSurvival(BlockRegistry.GREAT_HEMLOCK_SAPLING.get()),
                        BiomeFilter.biome()
                        )
        );

        register(context, HEMLOCK_FLOWER_CHECKED,
                HEMLOCK_FLOWER,
                List.of(
                        RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                )
        );

        register(context, HEMLOCK_ROCK_CHECKED,
                HEMLOCK_ROCK,
                List.of(
                        RarityFilter.onAverageOnceEvery(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                )
        );

        register(context, WATER_BASIN_CHECKED,
                WATER_BASIN,
                List.of(
                        RarityFilter.onAverageOnceEvery(200),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );
    }

    public static ResourceKey<PlacedFeature> createKey(String pName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Antics.MODID, pName));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(feature, modifiers));
    }
}
