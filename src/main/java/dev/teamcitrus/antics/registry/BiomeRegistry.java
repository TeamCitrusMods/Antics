package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeRegistry {
    public static final ResourceKey<Biome> GREAT_HEMLOCK_FOREST = register("great_hemlock_forest");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, Antics.id(name));
    }
}
