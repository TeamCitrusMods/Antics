package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BiomeRegistry {
    public static final ResourceKey<Biome> GREAT_HEMLOCK_FOREST = registerKey("great_hemlock_forest");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> holdergetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> holdergetter1 = context.lookup(Registries.CONFIGURED_CARVER);
        context.register(GREAT_HEMLOCK_FOREST, hemlockForest(holdergetter, holdergetter1));
    }

    public static Biome hemlockForest(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeSpecialEffects.Builder biomespecialeffects$builder = (new BiomeSpecialEffects.Builder())
                .grassColorOverride(4478511).foliageColorOverride(4478511)
                .waterColor(7304265).waterFogColor(2628614)
                .fogColor(11261106).skyColor(12446207)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST));

        BiomeDefaultFeatures.commonSpawns(mobspawnsettings$builder);
        BiomeDefaultFeatures.farmAnimals(mobspawnsettings$builder);
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 5, 3, 5));

        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatureRegistry.GREAT_HEMLOCK_TREE_CHECKED);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.DARK_FOREST_VEGETATION);
        BiomeDefaultFeatures.addFerns(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);
        BiomeDefaultFeatures.addDefaultSprings(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addForestGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addGiantTaigaVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.LAKES, PlacedFeatureRegistry.WATER_BASIN_CHECKED);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatureRegistry.HEMLOCK_FLOWER_CHECKED);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatureRegistry.HEMLOCK_ROCK_CHECKED);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.9f)
                .specialEffects(biomespecialeffects$builder.build())
                .mobSpawnSettings(mobspawnsettings$builder.build())
                .generationSettings(biomegenerationsettings$builder.build())
                .build();
    }

    private static ResourceKey<Biome> registerKey(String name) {
        return ResourceKey.create(Registries.BIOME, Antics.id(name));
    }
}
