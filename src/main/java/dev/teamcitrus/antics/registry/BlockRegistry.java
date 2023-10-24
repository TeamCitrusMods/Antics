package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.block.*;
import dev.teamcitrus.antics.block.sign.RAHangingSign;
import dev.teamcitrus.antics.block.sign.RASign;
import dev.teamcitrus.antics.world.tree.GreatHemlockTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Antics.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Antics.MODID);
    public static final BlockSetType GREAT_HEMLOCK = BlockSetType.register(new BlockSetType("great_hemlock"));
    public static final WoodType GREAT_HEMLOCK_WOOD_TYPE = WoodType.register(new WoodType("great_hemlock", GREAT_HEMLOCK));

    public static final RegistryObject<RAPillarWoodBlock> GREAT_HEMLOCK_LOG = register("great_hemlock_log", () -> new RAPillarWoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> GREAT_HEMLOCK_WOOD = register("great_hemlock_wood", () -> new RAWoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_GREAT_HEMLOCK_LOG = register("stripped_great_hemlock_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_GREAT_HEMLOCK_WOOD = register("stripped_great_hemlock_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> GREAT_HEMLOCK_PLANKS = register("great_hemlock_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GREAT_HEMLOCK_BOARDS = register("great_hemlock_boards", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<StairBlock> GREAT_HEMLOCK_STAIRS = register("great_hemlock_stairs", () -> new StairBlock(() -> GREAT_HEMLOCK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<SlabBlock> GREAT_HEMLOCK_SLAB = register("great_hemlock_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<FenceBlock> GREAT_HEMLOCK_FENCE = register("great_hemlock_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> GREAT_HEMLOCK_FENCE_GATE = register("great_hemlock_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), GREAT_HEMLOCK_WOOD_TYPE));
    public static final RegistryObject<DoorBlock> GREAT_HEMLOCK_DOOR = register("great_hemlock_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), GREAT_HEMLOCK));
    public static final RegistryObject<TrapDoorBlock> GREAT_HEMLOCK_TRAPDOOR = register("great_hemlock_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), GREAT_HEMLOCK));
    public static final RegistryObject<PressurePlateBlock> GREAT_HEMLOCK_PRESSURE_PLATE = register("great_hemlock_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), GREAT_HEMLOCK));
    public static final RegistryObject<ButtonBlock> GREAT_HEMLOCK_BUTTON = register("great_hemlock_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), GREAT_HEMLOCK, 30, true));
    public static final RegistryObject<Block> GREAT_HEMLOCK_LEAVES = register("great_hemlock_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> GREAT_HEMLOCK_SAPLING = register("great_hemlock_sapling", () -> new SaplingBlock(new GreatHemlockTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    // Sign
    public static final RegistryObject<StandingSignBlock> GREAT_HEMLOCK_SIGN = registerStandingSign("great_hemlock_sign", () -> new RASign.RAStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), GREAT_HEMLOCK_WOOD_TYPE));
    public static final RegistryObject<WallSignBlock> GREAT_HEMLOCK_WALL_SIGN = registerWallSign("great_hemlock_wall_sign", () -> new RASign.RAWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), GREAT_HEMLOCK_WOOD_TYPE));
    // Hanging Sign
    //public static final RegistryObject<CeilingHangingSignBlock> GREAT_HEMLOCK_HANGING_SIGN = register("great_hemlock_hanging_sign", () -> new RAHangingSign.CustomCeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), GREAT_HEMLOCK_WOOD_TYPE));
    //public static final RegistryObject<WallHangingSignBlock> GREAT_HEMLOCK_WALL_HANGING_SIGN = register("great_hemlock_wall_hanging_sign", () -> new RAHangingSign.CustomWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), GREAT_HEMLOCK_WOOD_TYPE));
    // Boat
    // Chest Boat

    public static final RegistryObject<Block> PINECONE_BLOCK = register("pinecone_block", () -> new PineconeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> EMPTY_PINECONE_BLOCK = register("empty_pinecone_block", () -> new PineconeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> POLISHED_PINECONE_BLOCK = register("polished_pinecone_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE)));
    public static final RegistryObject<Block> POLISHED_PINECONE_TILE = register("polished_pinecone_tile", () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE)));
    public static final RegistryObject<RotatedPillarBlock> PINECONE_FRAME = register("pinecone_frame", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().noOcclusion().isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never)));

    public static final RegistryObject<Block> BRANCH = register("branch", () -> new BranchBlock(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES)));

    public static final RegistryObject<RotatedPillarBlock> ANT_CHITIN_BLOCK = register("ant_chitin_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BASALT)));
    public static final RegistryObject<Block> ORNATE_ANT_CHITIN = register("ornate_ant_chitin", () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BASALT)));
    public static final RegistryObject<Block> ANT_CHITIN_TILES = register("ant_chitin_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BASALT)));

    public static final RegistryObject<RotatedPillarBlock> ANTSILK_COCOON = register("antsilk_cocoon", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<RotatedPillarBlock> SPUN_ANTSILK = register("spun_antsilk", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> QUILTED_ANTSILK = register("quilted_antsilk", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> blockRegistryObject = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }

    private static <T extends StandingSignBlock> RegistryObject<T> registerStandingSign(String name, Supplier<T> block) {
        RegistryObject<T> blockRegistryObject = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new SignItem(new Item.Properties(), GREAT_HEMLOCK_SIGN.get(), GREAT_HEMLOCK_WALL_SIGN.get()));
        return blockRegistryObject;
    }

    private static <T extends WallSignBlock> RegistryObject<T> registerWallSign(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return false;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }
}
