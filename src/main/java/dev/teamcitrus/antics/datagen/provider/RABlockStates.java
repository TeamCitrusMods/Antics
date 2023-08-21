package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.RABlockRegistry;
import dev.teamcitrus.antics.util.RAUtils;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RABlockStates extends BlockStateProvider {
    public RABlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Antics.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(RABlockRegistry.GREAT_HEMLOCK_LOG.get());
        simpleBlockItem(RABlockRegistry.GREAT_HEMLOCK_LOG.get(), models().withExistingParent("block/great_hemlock_log", "block/cube_column"));
        simpleBlockWithItem(RABlockRegistry.GREAT_HEMLOCK_WOOD.get(), models().cubeAll("great_hemlock_wood", RAUtils.id("block/great_hemlock_log")));

        logBlock(RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get());
        simpleBlockItem(RABlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), models().withExistingParent("block/stripped_great_hemlock_log", "block/cube_column"));
        simpleBlockWithItem(RABlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get(), models().cubeAll("stripped_great_hemlock_wood", RAUtils.id("block/stripped_great_hemlock_log")));

        simpleBlockWithItem(RABlockRegistry.GREAT_HEMLOCK_PLANKS.get(), cubeAll(RABlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        simpleBlockWithItem(RABlockRegistry.GREAT_HEMLOCK_BOARDS.get(), cubeAll(RABlockRegistry.GREAT_HEMLOCK_BOARDS.get()));

        doorBlockWithRenderType(RABlockRegistry.GREAT_HEMLOCK_DOOR.get(), RAUtils.id("block/great_hemlock_door_bottom"), RAUtils.id("block/great_hemlock_door_top"), "cutout");

        simpleBlockWithItem(RABlockRegistry.GREAT_HEMLOCK_LEAVES.get(), models().cubeAll("great_hemlock_leaves", RAUtils.id("block/great_hemlock_leaves")).renderType("cutout"));

        simpleBlockWithItem(RABlockRegistry.PINECONE_FRAME.get(), models().cubeAll("pinecone_frame", RAUtils.id("block/pinecone_frame")).renderType("cutout"));
    }
}
