package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.registry.RABlockRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class RABlockLootProvider extends BlockLootSubProvider {
    public RABlockLootProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_LOG.get());
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_WOOD.get());
        dropSelf(RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get());
        dropSelf(RABlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get());
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_PLANKS.get());
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_BOARDS.get());
        add(RABlockRegistry.GREAT_HEMLOCK_DOOR.get(), createDoorTable(RABlockRegistry.GREAT_HEMLOCK_DOOR.get()));
        this.add(RABlockRegistry.GREAT_HEMLOCK_LEAVES.get(), (block) -> createLeavesDrops(block, RABlockRegistry.GREAT_HEMLOCK_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(RABlockRegistry.PINECONE_FRAME.get());
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_SAPLING.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RABlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
