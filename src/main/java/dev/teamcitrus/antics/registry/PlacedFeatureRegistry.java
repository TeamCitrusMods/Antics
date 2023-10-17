package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.world.AnticsConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

public class PlacedFeatureRegistry {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE = DeferredRegister.create(Registries.PLACED_FEATURE, Antics.MODID);

    public static final ResourceKey<PlacedFeature> GREAT_HEMLOCK_TREE_CHECKED = createKey("great_hemlock_tree");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> GREAT_HEMLOCK_TREE = getter.getOrThrow(AnticsConfiguredFeatures.GREAT_HEMLOCK_KEY);

        register(context, GREAT_HEMLOCK_TREE_CHECKED,
                GREAT_HEMLOCK_TREE,
                List.of(PlacementUtils.HEIGHTMAP,
                        PlacementUtils.filteredByBlockSurvival(BlockRegistry.GREAT_HEMLOCK_SAPLING.get()),
                        RarityFilter.onAverageOnceEvery(20))
        );
    }

    public static ResourceKey<PlacedFeature> createKey(String pName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Antics.MODID, pName));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(feature, modifiers));
    }
}
