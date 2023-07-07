package dev.teamcitrus.resourceants.registry;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.block.ResourceMushroomBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RABlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourceAnts.MODID);
    public static final DeferredRegister<Item> MUSHROOMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceAnts.MODID);

    public static final RegistryObject<Block> COAL_MUSHROOM = registerMushroom("coal_mushroom", 0x63666A, 0);

    private static RegistryObject<Block> registerMushroom(String name, int capColor, int stemColor) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new ResourceMushroomBlock(capColor, stemColor));
        MUSHROOMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ResourceAnts.TAB)));
        return block;
    }
}
