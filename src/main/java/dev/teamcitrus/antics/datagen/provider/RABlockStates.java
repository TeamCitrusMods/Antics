package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class RABlockStates extends BlockStateProvider {
    public RABlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Antics.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(BlockRegistry.GREAT_HEMLOCK_LOG.get());
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_LOG.get(), models().withExistingParent("block/great_hemlock_log", "block/cube_column"));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_WOOD.get(), models().cubeAll("great_hemlock_wood", Antics.id("block/great_hemlock_log")));

        logBlock(BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get());
        simpleBlockItem(BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), models().withExistingParent("block/stripped_great_hemlock_log", "block/cube_column"));

        simpleBlockWithItem(BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get(), models().cubeAll("stripped_great_hemlock_wood", Antics.id("block/stripped_great_hemlock_log")));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_PLANKS.get(), cubeAll(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_BOARDS.get(), cubeAll(BlockRegistry.GREAT_HEMLOCK_BOARDS.get()));

        stairsBlock(BlockRegistry.GREAT_HEMLOCK_STAIRS.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_STAIRS.get(), models().withExistingParent("block/great_hemlock_stairs", "block/stairs"));

        slabBlock(BlockRegistry.GREAT_HEMLOCK_SLAB.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_SLAB.get(), models().withExistingParent("block/great_hemlock_slab", "block/slab"));

        fenceBlock(BlockRegistry.GREAT_HEMLOCK_FENCE.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        fenceGateBlock(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), models().withExistingParent("block/great_hemlock_fence_gate", "block/template_fence_gate"));

        doorBlockWithRenderType(BlockRegistry.GREAT_HEMLOCK_DOOR.get(), Antics.id("block/great_hemlock_door_bottom"), Antics.id("block/great_hemlock_door_top"), "cutout");

        pressurePlateBlock(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get(), models().withExistingParent("block/great_hemlock_pressure_plate", "block/pressure_plate_up"));

        buttonBlock(BlockRegistry.GREAT_HEMLOCK_BUTTON.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_LEAVES.get(), models().cubeAll("great_hemlock_leaves", Antics.id("block/great_hemlock_leaves")).renderType("cutout"));

        simpleBlockWithItem(BlockRegistry.PINECONE_FRAME.get(), models().cubeAll("pinecone_frame", Antics.id("block/pinecone_frame")).renderType("cutout"));

        simpleBlock(BlockRegistry.GREAT_HEMLOCK_SAPLING.get(), models().cross(ForgeRegistries.BLOCKS.getKey(BlockRegistry.GREAT_HEMLOCK_SAPLING.get()).getPath(), blockTexture(BlockRegistry.GREAT_HEMLOCK_SAPLING.get())).renderType("cutout"));

        logBlock(BlockRegistry.PINECONE_BLOCK.get());
        simpleBlockItem(BlockRegistry.PINECONE_BLOCK.get(), models().withExistingParent("block/pinecone_block", "block/cube_column"));

        logBlock(BlockRegistry.EMPTY_PINECONE_BLOCK.get());
        simpleBlockItem(BlockRegistry.EMPTY_PINECONE_BLOCK.get(), models().withExistingParent("block/empty_pinecone_block", "block/cube_column"));

        simpleBlockWithItem(BlockRegistry.POLISHED_PINECONE_BLOCK.get(), models().cubeAll("polished_pinecone_block", Antics.id("block/polished_pinecone_block")));
    }
}
