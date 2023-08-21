package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.block.RAPillarWoodBlock;
import dev.teamcitrus.antics.block.RAWoodBlock;
import dev.teamcitrus.antics.block.ResourceMushroomBlock;
import dev.teamcitrus.antics.item.ResourceMushroomItem;
import dev.teamcitrus.antics.util.MushroomResourceTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RABlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Antics.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Antics.MODID);
    public static final BlockSetType GREAT_HEMLOCK = BlockSetType.register(new BlockSetType("great_hemlock"));

    public static final RegistryObject<RAPillarWoodBlock> GREAT_HEMLOCK_LOG = registerPillarRAWood("great_hemlock_log", BlockBehaviour.Properties.copy(Blocks.OAK_LOG));
    public static final RegistryObject<RAWoodBlock> GREAT_HEMLOCK_WOOD = registerRAWood("great_hemlock_wood", BlockBehaviour.Properties.copy(Blocks.OAK_WOOD));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_GREAT_HEMLOCK_LOG = registerPillarWood("stripped_great_hemlock_log", BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG));
    public static final RegistryObject<Block> STRIPPED_GREAT_HEMLOCK_WOOD = registerBlockWithItem("stripped_great_hemlock_wood", BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD));
    public static final RegistryObject<Block> GREAT_HEMLOCK_PLANKS = registerBlockWithItem("great_hemlock_planks", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> GREAT_HEMLOCK_BOARDS = registerBlockWithItem("great_hemlock_boards", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    public static final RegistryObject<DoorBlock> GREAT_HEMLOCK_DOOR = registerDoorBlock("great_hemlock_door", BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), GREAT_HEMLOCK);
    public static final RegistryObject<LeavesBlock> GREAT_HEMLOCK_LEAVES = registerLeafBlock("great_hemlock_leaves", BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    public static final RegistryObject<Block> PINECONE_FRAME = registerBlockWithItem("pinecone_frame", BlockBehaviour.Properties.of().noOcclusion().isValidSpawn(RABlockRegistry::never).isRedstoneConductor(RABlockRegistry::never).isSuffocating(RABlockRegistry::never));

    public static final RegistryObject<Block> TIER_ONE_MUSHROOM = registerMushroom("resource_mushroom_tier_one", MushroomResourceTiers.ONE);
    public static final RegistryObject<Block> TIER_TWO_MUSHROOM = registerMushroom("resource_mushroom_tier_two", MushroomResourceTiers.TWO);
    public static final RegistryObject<Block> TIER_THREE_MUSHROOM = registerMushroom("resource_mushroom_tier_three", MushroomResourceTiers.THREE);
    public static final RegistryObject<Block> TIER_FOUR_MUSHROOM = registerMushroom("resource_mushroom_tier_four", MushroomResourceTiers.FOUR);
    public static final RegistryObject<Block> TIER_FIVE_MUSHROOM = registerMushroom("resource_mushroom_tier_five", MushroomResourceTiers.FIVE);

    private static RegistryObject<Block> registerBlockWithItem(String name, BlockBehaviour.Properties properties) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(properties));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<RotatedPillarBlock> registerPillarWood(String name, BlockBehaviour.Properties properties) {
        RegistryObject<RotatedPillarBlock> block = BLOCKS.register(name, () -> new RotatedPillarBlock(properties));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<RAPillarWoodBlock> registerPillarRAWood(String name, BlockBehaviour.Properties properties) {
        RegistryObject<RAPillarWoodBlock> block = BLOCKS.register(name, () -> new RAPillarWoodBlock(properties));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<RAWoodBlock> registerRAWood(String name, BlockBehaviour.Properties properties) {
        RegistryObject<RAWoodBlock> block = BLOCKS.register(name, () -> new RAWoodBlock(properties));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<Block> registerMushroom(String name, MushroomResourceTiers tiers) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new ResourceMushroomBlock(tiers));
        ITEMS.register(name, () -> new ResourceMushroomItem(block.get()));
        return block;
    }

    private static RegistryObject<DoorBlock> registerDoorBlock(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        RegistryObject<DoorBlock> block = BLOCKS.register(name, () -> new DoorBlock(properties, setType));
        ITEMS.register(name, () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<LeavesBlock> registerLeafBlock(String name, BlockBehaviour.Properties properties) {
        RegistryObject<LeavesBlock> block = BLOCKS.register(name, () -> new LeavesBlock(properties));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return false;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }
}
