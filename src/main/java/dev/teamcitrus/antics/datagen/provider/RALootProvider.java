package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class RALootProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(RABlockLootProvider::new, LootContextParamSets.BLOCK)));
    }

    public static class RABlockLootProvider extends BlockLootSubProvider {
        public RABlockLootProvider() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            dropSelf(BlockRegistry.GREAT_HEMLOCK_LOG.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_WOOD.get());
            dropSelf(BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get());
            dropSelf(BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_PLANKS.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_BOARDS.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_STAIRS.get());
            add(BlockRegistry.GREAT_HEMLOCK_SLAB.get(), createSlabItemTable(BlockRegistry.GREAT_HEMLOCK_SLAB.get()));
            dropSelf(BlockRegistry.GREAT_HEMLOCK_FENCE.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get());
            add(BlockRegistry.GREAT_HEMLOCK_DOOR.get(), createDoorTable(BlockRegistry.GREAT_HEMLOCK_DOOR.get()));
            dropSelf(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_BUTTON.get());
            add(BlockRegistry.GREAT_HEMLOCK_LEAVES.get(), createLeavesDrops(BlockRegistry.GREAT_HEMLOCK_LEAVES.get(), BlockRegistry.GREAT_HEMLOCK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
            dropSelf(BlockRegistry.GREAT_HEMLOCK_SAPLING.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_SIGN.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_WALL_SIGN.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_HANGING_SIGN.get());
            dropSelf(BlockRegistry.GREAT_HEMLOCK_WALL_HANGING_SIGN.get());
            dropSelf(BlockRegistry.PINECONE_BLOCK.get());
            dropSelf(BlockRegistry.EMPTY_PINECONE_BLOCK.get());
            dropSelf(BlockRegistry.POLISHED_PINECONE_BLOCK.get());
            dropSelf(BlockRegistry.POLISHED_PINECONE_TILE.get());
            dropSelf(BlockRegistry.PINECONE_FRAME.get());
            dropSelf(BlockRegistry.BRANCH.get());
            dropSelf(BlockRegistry.ANT_CHITIN_BLOCK.get());
            dropSelf(BlockRegistry.ORNATE_ANT_CHITIN.get());
            dropSelf(BlockRegistry.ANT_CHITIN_TILES.get());
            dropSelf(BlockRegistry.ANTSILK_COCOON.get());
            dropSelf(BlockRegistry.QUILTED_ANTSILK.get());
            dropSelf(BlockRegistry.SPUN_ANTSILK.get());
            dropWhenSilkTouch(BlockRegistry.ANTHILL.get());
        }

        @Override
        @NotNull
        protected Iterable<Block> getKnownBlocks() {
            return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }
    }
}
