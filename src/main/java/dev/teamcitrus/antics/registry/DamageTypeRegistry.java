package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class DamageTypeRegistry {
    public static final ResourceKey<DamageType> FALLING_PINECONE = ResourceKey.create(Registries.DAMAGE_TYPE, Antics.id("falling_pinecone"));

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(FALLING_PINECONE, new DamageType("falling_pinecone", DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.1f));
    }

    public static DamageSource of(Level level, ResourceKey<DamageType> damageType) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType));
    }
}
