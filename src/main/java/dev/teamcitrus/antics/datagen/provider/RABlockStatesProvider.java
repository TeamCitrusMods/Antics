package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class RABlockStatesProvider extends BlockStateProvider {
    public RABlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
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

        pressurePlateBlock(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));
        simpleBlockItem(BlockRegistry.GREAT_HEMLOCK_PRESSURE_PLATE.get(), models().withExistingParent("great_hemlock_pressure_plate", "pressure_plate_up"));

        buttonBlock(BlockRegistry.GREAT_HEMLOCK_BUTTON.get(), blockTexture(BlockRegistry.GREAT_HEMLOCK_PLANKS.get()));

        simpleBlockWithItem(BlockRegistry.GREAT_HEMLOCK_LEAVES.get(), models().withExistingParent("great_hemlock_leaves", "leaves").texture("all", modLoc("block/great_hemlock_leaves")).renderType("cutout"));

        simpleBlock(BlockRegistry.GREAT_HEMLOCK_SAPLING.get(), models().cross(ForgeRegistries.BLOCKS.getKey(BlockRegistry.GREAT_HEMLOCK_SAPLING.get()).getPath(), blockTexture(BlockRegistry.GREAT_HEMLOCK_SAPLING.get())).renderType("cutout"));

        signBlock(BlockRegistry.GREAT_HEMLOCK_SIGN.get(), BlockRegistry.GREAT_HEMLOCK_WALL_SIGN.get(), modLoc("block/great_hemlock_planks"));

        simpleBlockWithItem(BlockRegistry.POLISHED_PINECONE_BLOCK.get(), models().cubeAll("polished_pinecone_block", modLoc("block/polished_pinecone_block")));

        simpleBlockWithItem(BlockRegistry.POLISHED_PINECONE_TILE.get(), models().cubeAll("polished_pinecone_tile", modLoc("block/polished_pinecone_tile")));

        axisBlockWithRenderType(BlockRegistry.PINECONE_FRAME.get(), modLoc("block/pinecone_frame"), modLoc("block/pinecone_frame_top"), "cutout");
        simpleBlockItem(BlockRegistry.PINECONE_FRAME.get(), models().withExistingParent("pinecone_frame", "cube_column"));

        simpleBlock(BlockRegistry.BRANCH.get(), models().cross(ForgeRegistries.BLOCKS.getKey(BlockRegistry.BRANCH.get()).getPath(), blockTexture(BlockRegistry.BRANCH.get())).renderType("cutout"));

        logBlock(BlockRegistry.ANT_CHITIN_BLOCK.get());
        simpleBlockItem(BlockRegistry.ANT_CHITIN_BLOCK.get(), models().withExistingParent("ant_chitin_block", "cube_column"));

        simpleBlockWithItem(BlockRegistry.ORNATE_ANT_CHITIN.get(), models().cubeAll("ornate_ant_chitin", modLoc("block/ornate_ant_chitin")));

        simpleBlockWithItem(BlockRegistry.ANT_CHITIN_TILES.get(), models().cubeAll("ant_chitin_tiles", modLoc("block/ant_chitin_tiles")));

        logBlock(BlockRegistry.ANTSILK_COCOON.get());
        simpleBlockItem(BlockRegistry.ANTSILK_COCOON.get(), models().withExistingParent("antsilk_cocoon", "cube_column"));

        logBlock(BlockRegistry.SPUN_ANTSILK.get());
        simpleBlockItem(BlockRegistry.SPUN_ANTSILK.get(), models().withExistingParent("spun_antsilk", "cube_column"));

        simpleBlockWithItem(BlockRegistry.QUILTED_ANTSILK.get(), models().cubeAll("quilted_antsilk", modLoc("block/quilted_antsilk")));

        simpleBlockWithItem(BlockRegistry.ANTHILL.get(), models().cubeColumn("", modLoc("block/loose_soil"), modLoc("block/formicary_mound")));
    }
}
