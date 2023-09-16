package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.registry.RABlockRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

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
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_STAIRS.get());
        add(RABlockRegistry.GREAT_HEMLOCK_SLAB.get(), createSlabItemTable(RABlockRegistry.GREAT_HEMLOCK_SLAB.get()));
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_FENCE.get());
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get());
        add(RABlockRegistry.GREAT_HEMLOCK_DOOR.get(), createDoorTable(RABlockRegistry.GREAT_HEMLOCK_DOOR.get()));
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get());
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_BUTTON.get());
        add(RABlockRegistry.GREAT_HEMLOCK_LEAVES.get(), createLeavesDrops(RABlockRegistry.GREAT_HEMLOCK_LEAVES.get(), RABlockRegistry.GREAT_HEMLOCK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(RABlockRegistry.PINECONE_FRAME.get());
        dropSelf(RABlockRegistry.GREAT_HEMLOCK_SAPLING.get());
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return RABlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
