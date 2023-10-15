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
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_LOG.get(), models().withExistingParent("great_hemlock_log", "cube_column"));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_WOOD.get(), models().cubeAll("great_hemlock_wood", modLoc("block/great_hemlock_log")));

        logBlock(BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get());
        simpleBlockItem(BlockRegistry.STRIPPED_GREAT_HEMLOCK_LOG.get(), models().withExistingParent("stripped_great_hemlock_log", "cube_column"));

        simpleBlockWithItem(BlockRegistry.STRIPPED_GREAT_HEMLOCK_WOOD.get(), models().cubeAll("stripped_great_hemlock_wood", modLoc("block/stripped_great_hemlock_log")));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_PLANKS.get(), cubeAll(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_BOARDS.get(), cubeAll(BlockRegistry.GREAT_HEMLOCK_BOARDS.get()));

        stairsBlock(BlockRegistry.GREAT_HEMLOCK_STAIRS.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_STAIRS.get(), models().withExistingParent("great_hemlock_stairs", "stairs"));

        slabBlock(BlockRegistry.GREAT_HEMLOCK_SLAB.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_SLAB.get(), models().withExistingParent("great_hemlock_slab", "slab"));

        fenceBlock(BlockRegistry.GREAT_HEMLOCK_FENCE.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        fenceGateBlock(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_FENCE_GATE.get(), models().withExistingParent("great_hemlock_fence_gate", "template_fence_gate"));

        doorBlockWithRenderType(BlockRegistry.GREAT_HEMLOCK_DOOR.get(), modLoc("block/great_hemlock_door_bottom"), modLoc("block/great_hemlock_door_top"), "cutout");

        trapdoorBlockWithRenderType(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get(), modLoc("block/great_hemlock_trapdoor"), true, "cutout");
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get(), models().withExistingParent("great_hemlock_trapdoor_bottom", "template_orientable_trapdoor_bottom"));

        pressurePlateBlock(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get(), models().withExistingParent("great_hemlock_pressure_plate", "pressure_plate_up"));

        buttonBlock(BlockRegistry.GREAT_HEMLOCK_BUTTON.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_LEAVES.get(), models().withExistingParent("great_hemlock_leaves", "leaves").texture("all", modLoc("block/great_hemlock_leaves")).renderType("cutout"));

        simpleBlock(BlockRegistry.GREAT_HEMLOCK_SAPLING.get(), models().cross(ForgeRegistries.BLOCKS.getKey(BlockRegistry.GREAT_HEMLOCK_SAPLING.get()).getPath(), blockTexture(BlockRegistry.GREAT_HEMLOCK_SAPLING.get())).renderType("cutout"));

        simpleBlockWithItem(BlockRegistry.POLISHED_PINECONE_BLOCK.get(), models().cubeAll("polished_pinecone_block", modLoc("block/polished_pinecone_block")));

        simpleBlockWithItem(BlockRegistry.POLISHED_PINECONE_TILE.get(), models().cubeAll("polished_pinecone_tile", modLoc("block/polished_pinecone_tile")));

        axisBlockWithRenderType(BlockRegistry.PINECONE_FRAME.get(), modLoc("block/pinecone_frame"), modLoc("block/pinecone_frame_top"), "cutout");
        simpleBlockItem(BlockRegistry.PINECONE_FRAME.get(), models().withExistingParent("pinecone_frame", "cube_column"));

        simpleBlock(BlockRegistry.BRANCH.get(), models().cross(ForgeRegistries.BLOCKS.getKey(BlockRegistry.BRANCH.get()).getPath(), blockTexture(BlockRegistry.BRANCH.get())).renderType("cutout"));
    }
}
