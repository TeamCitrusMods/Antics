package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BiomeRegistry;
import dev.teamcitrus.antics.registry.ConfiguredFeaturesRegistry;
import dev.teamcitrus.antics.registry.DamageTypeRegistry;
import dev.teamcitrus.antics.registry.PlacedFeatureRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RADatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeaturesRegistry::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacedFeatureRegistry::bootstrap)
            .add(Registries.BIOME, BiomeRegistry::bootstrap)
            .add(Registries.DAMAGE_TYPE, DamageTypeRegistry::bootstrap);

    public RADatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Antics.MODID));
    }
}
