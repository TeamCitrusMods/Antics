package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BlockRegistry;
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
            tag(BlockTags.LOGS).add(BlockRegistry.GREAT_HEMLOCK_LOG.get(), BlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            tag(BlockTags.LOGS_THAT_BURN).add(BlockRegistry.GREAT_HEMLOCK_LOG.get(), BlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            tag(BlockTags.PLANKS).add(BlockRegistry.GREAT_HEMLOCK_PLANKS.get(), BlockRegistry.GREAT_HEMLOCK_BOARDS.get());
            tag(BlockTags.FENCES).add(BlockRegistry.GREAT_HEMLOCK_FENCE.get());
            tag(BlockTags.WOODEN_FENCES).add(BlockRegistry.GREAT_HEMLOCK_FENCE.get());
            tag(BlockTags.FENCE_GATES).add(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get());
            tag(BlockTags.BUTTONS).add(BlockRegistry.GREAT_HEMLOCK_BUTTON.get());
            tag(BlockTags.WOODEN_BUTTONS).add(BlockRegistry.GREAT_HEMLOCK_BUTTON.get());
            tag(BlockTags.DOORS).add(BlockRegistry.GREAT_HEMLOCK_DOOR.get());
            tag(BlockTags.WOODEN_DOORS).add(BlockRegistry.GREAT_HEMLOCK_DOOR.get());
            tag(BlockTags.SLABS).add(BlockRegistry.GREAT_HEMLOCK_SLAB.get());
            tag(BlockTags.WOODEN_SLABS).add(BlockRegistry.GREAT_HEMLOCK_SLAB.get());
            tag(BlockTags.PRESSURE_PLATES).add(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.STAIRS).add(BlockRegistry.GREAT_HEMLOCK_STAIRS.get());
            tag(BlockTags.LEAVES).add(BlockRegistry.GREAT_HEMLOCK_LEAVES.get());
            tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(BlockRegistry.GREAT_HEMLOCK_LOG.get());
            tag(BlockTags.MINEABLE_WITH_AXE).add(BlockRegistry.GREAT_HEMLOCK_LOG.get(), BlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get(), BlockRegistry.GREAT_HEMLOCK_PLANKS.get(),
                    BlockRegistry.GREAT_HEMLOCK_BOARDS.get(), BlockRegistry.GREAT_HEMLOCK_STAIRS.get(), BlockRegistry.GREAT_HEMLOCK_SLAB.get(), BlockRegistry.GREAT_HEMLOCK_DOOR.get(),
                    BlockRegistry.GREAT_HEMLOCK_BUTTON.get(), BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.MINEABLE_WITH_HOE).add(BlockRegistry.GREAT_HEMLOCK_LEAVES.get());
        }
    }
}
