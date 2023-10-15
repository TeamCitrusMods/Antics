package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RATagProvider {
    public static class Blocks extends BlockTagsProvider {
        private final TagKey<Block> HEMLOCK_LOGS = modTag("hemlock_logs");

        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Antics.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
            tag(HEMLOCK_LOGS).add(BlockRegistry.GREAT_HEMLOCK_LOG.get(), BlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            tag(BlockTags.LOGS).add(BlockRegistry.GREAT_HEMLOCK_LOG.get(), BlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            tag(BlockTags.LOGS_THAT_BURN).add(BlockRegistry.GREAT_HEMLOCK_LOG.get(), BlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(BlockRegistry.GREAT_HEMLOCK_LOG.get());
            tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(BlockRegistry.GREAT_HEMLOCK_LOG.get());
            tag(BlockTags.PLANKS).add(BlockRegistry.GREAT_HEMLOCK_PLANKS.get(), BlockRegistry.GREAT_HEMLOCK_BOARDS.get());
            tag(BlockTags.STAIRS).add(BlockRegistry.GREAT_HEMLOCK_STAIRS.get());
            tag(BlockTags.WOODEN_STAIRS).add(BlockRegistry.GREAT_HEMLOCK_STAIRS.get());
            tag(BlockTags.SLABS).add(BlockRegistry.GREAT_HEMLOCK_SLAB.get());
            tag(BlockTags.WOODEN_SLABS).add(BlockRegistry.GREAT_HEMLOCK_SLAB.get());
            tag(BlockTags.FENCES).add(BlockRegistry.GREAT_HEMLOCK_FENCE.get());
            tag(BlockTags.WOODEN_FENCES).add(BlockRegistry.GREAT_HEMLOCK_FENCE.get());
            tag(BlockTags.FENCE_GATES).add(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get());
            tag(Tags.Blocks.FENCE_GATES_WOODEN).add(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get());
            tag(BlockTags.DOORS).add(BlockRegistry.GREAT_HEMLOCK_DOOR.get());
            tag(BlockTags.WOODEN_DOORS).add(BlockRegistry.GREAT_HEMLOCK_DOOR.get());
            tag(BlockTags.TRAPDOORS).add(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get());
            tag(BlockTags.WOODEN_TRAPDOORS).add(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get());
            tag(BlockTags.PRESSURE_PLATES).add(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            tag(BlockTags.BUTTONS).add(BlockRegistry.GREAT_HEMLOCK_BUTTON.get());
            tag(BlockTags.WOODEN_BUTTONS).add(BlockRegistry.GREAT_HEMLOCK_BUTTON.get());
            tag(BlockTags.LEAVES).add(BlockRegistry.GREAT_HEMLOCK_LEAVES.get());
            tag(BlockTags.SAPLINGS).add(BlockRegistry.GREAT_HEMLOCK_SAPLING.get());
            tag(BlockTags.MINEABLE_WITH_AXE).add(BlockRegistry.GREAT_HEMLOCK_LOG.get(), BlockRegistry.GREAT_HEMLOCK_WOOD.get(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get(), BlockRegistry.GREAT_HEMLOCK_PLANKS.get(),
                    BlockRegistry.GREAT_HEMLOCK_BOARDS.get(), BlockRegistry.GREAT_HEMLOCK_STAIRS.get(), BlockRegistry.GREAT_HEMLOCK_SLAB.get(), BlockRegistry.GREAT_HEMLOCK_FENCE.get(),
                    BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), BlockRegistry.GREAT_HEMLOCK_DOOR.get(), BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get(),
                    BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get(), BlockRegistry.GREAT_HEMLOCK_BUTTON.get()
            );
            tag(BlockTags.MINEABLE_WITH_HOE).add(BlockRegistry.GREAT_HEMLOCK_LEAVES.get());
        }

        private TagKey<Block> modTag(String id) {
            return TagKey.create(Registries.BLOCK, Antics.id(id));
        }
    }

    public static class Items extends ItemTagsProvider {
        private final TagKey<Item> HEMLOCK_LOGS = modTag("hemlock_logs");

        public Items(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
            super(pOutput, pLookupProvider, pBlockTags, Antics.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
            tag(HEMLOCK_LOGS).add(BlockRegistry.GREAT_HEMLOCK_LOG.get().asItem(), BlockRegistry.GREAT_HEMLOCK_WOOD.get().asItem(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get().asItem(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get().asItem());
            tag(ItemTags.LOGS).add(BlockRegistry.GREAT_HEMLOCK_LOG.get().asItem(), BlockRegistry.GREAT_HEMLOCK_WOOD.get().asItem(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get().asItem(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get().asItem());
            tag(ItemTags.LOGS_THAT_BURN).add(BlockRegistry.GREAT_HEMLOCK_LOG.get().asItem(), BlockRegistry.GREAT_HEMLOCK_WOOD.get().asItem(),
                    BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get().asItem(), BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get().asItem());
            tag(ItemTags.COMPLETES_FIND_TREE_TUTORIAL).add(BlockRegistry.GREAT_HEMLOCK_LOG.get().asItem());
            tag(ItemTags.PLANKS).add(BlockRegistry.GREAT_HEMLOCK_PLANKS.get().asItem(), BlockRegistry.GREAT_HEMLOCK_BOARDS.get().asItem());
            tag(ItemTags.STAIRS).add(BlockRegistry.GREAT_HEMLOCK_STAIRS.get().asItem());
            tag(ItemTags.WOODEN_STAIRS).add(BlockRegistry.GREAT_HEMLOCK_STAIRS.get().asItem());
            tag(ItemTags.SLABS).add(BlockRegistry.GREAT_HEMLOCK_SLAB.get().asItem());
            tag(ItemTags.FENCES).add(BlockRegistry.GREAT_HEMLOCK_FENCE.get().asItem());
            tag(ItemTags.WOODEN_FENCES).add(BlockRegistry.GREAT_HEMLOCK_FENCE.get().asItem());
            tag(ItemTags.FENCE_GATES).add(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get().asItem());
            tag(Tags.Items.FENCE_GATES_WOODEN).add(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get().asItem());
            tag(ItemTags.DOORS).add(BlockRegistry.GREAT_HEMLOCK_DOOR.get().asItem());
            tag(ItemTags.WOODEN_DOORS).add(BlockRegistry.GREAT_HEMLOCK_DOOR.get().asItem());
            tag(ItemTags.TRAPDOORS).add(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get().asItem());
            tag(ItemTags.WOODEN_TRAPDOORS).add(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get().asItem());
            tag(ItemTags.WOODEN_PRESSURE_PLATES).add(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get().asItem());
            tag(ItemTags.BUTTONS).add(BlockRegistry.GREAT_HEMLOCK_BUTTON.get().asItem());
            tag(ItemTags.WOODEN_BUTTONS).add(BlockRegistry.GREAT_HEMLOCK_BUTTON.get().asItem());
            tag(ItemTags.WOODEN_SLABS).add(BlockRegistry.GREAT_HEMLOCK_SLAB.get().asItem());
            tag(ItemTags.LEAVES).add(BlockRegistry.GREAT_HEMLOCK_LEAVES.get().asItem());
            tag(ItemTags.SAPLINGS).add(BlockRegistry.GREAT_HEMLOCK_SAPLING.get().asItem());
        }

        private TagKey<Item> modTag(String id) {
            return TagKey.create(Registries.ITEM, Antics.id(id));
        }
    }
}
