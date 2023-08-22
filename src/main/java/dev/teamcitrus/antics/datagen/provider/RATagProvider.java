package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.RABlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RATagProvider extends BlockTagsProvider {
    public RATagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Antics.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.LOGS).add(RABlockRegistry.GREAT_HEMLOCK_LOG.get(), RABlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), RABlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
    }
}
