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

public class RATagProvider {
    public static class Blocks extends BlockTagsProvider {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Antics.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
            tag(BlockTags.LOGS).add(RABlockRegistry.GREAT_HEMLOCK_LOG.get(), RABlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), RABlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            tag(BlockTags.LOGS_THAT_BURN).add(RABlockRegistry.GREAT_HEMLOCK_LOG.get(), RABlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), RABlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            tag(BlockTags.PLANKS).add(RABlockRegistry.GREAT_HEMLOCK_PLANKS.get(), RABlockRegistry.GREAT_HEMLOCK_BOARDS.get());
            tag(BlockTags.FENCES).add(RABlockRegistry.GREAT_HEMLOCK_FENCE.get());
            tag(BlockTags.WOODEN_FENCES).add(RABlockRegistry.GREAT_HEMLOCK_FENCE.get());
            tag(BlockTags.FENCE_GATES).add(RABlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get());
            tag(BlockTags.BUTTONS).add(RABlockRegistry.GREAT_HEMLOCK_BUTTON.get());
            tag(BlockTags.WOODEN_BUTTONS).add(RABlockRegistry.GREAT_HEMLOCK_BUTTON.get());
            tag(BlockTags.DOORS).add(RABlockRegistry.GREAT_HEMLOCK_DOOR.get());
            tag(BlockTags.WOODEN_DOORS).add(RABlockRegistry.GREAT_HEMLOCK_DOOR.get());
            tag(BlockTags.SLABS).add(RABlockRegistry.GREAT_HEMLOCK_SLAB.get());
            tag(BlockTags.WOODEN_SLABS).add(RABlockRegistry.GREAT_HEMLOCK_SLAB.get());
            tag(BlockTags.PRESSURE_PLATES).add(RABlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.WOODEN_PRESSURE_PLATES).add(RABlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.STAIRS).add(RABlockRegistry.GREAT_HEMLOCK_STAIRS.get());
            tag(BlockTags.LEAVES).add(RABlockRegistry.GREAT_HEMLOCK_LEAVES.get());
            tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(RABlockRegistry.GREAT_HEMLOCK_LOG.get());
            tag(BlockTags.MINEABLE_WITH_AXE).add(RABlockRegistry.GREAT_HEMLOCK_LOG.get(), RABlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), RABlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get(), RABlockRegistry.GREAT_HEMLOCK_PLANKS.get(),
                    RABlockRegistry.GREAT_HEMLOCK_BOARDS.get(), RABlockRegistry.GREAT_HEMLOCK_STAIRS.get(), RABlockRegistry.GREAT_HEMLOCK_SLAB.get(), RABlockRegistry.GREAT_HEMLOCK_DOOR.get(),
                    RABlockRegistry.GREAT_HEMLOCK_BUTTON.get(), RABlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), RABlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), RABlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.MINEABLE_WITH_HOE).add(RABlockRegistry.GREAT_HEMLOCK_LEAVES.get());
        }
    }
}
