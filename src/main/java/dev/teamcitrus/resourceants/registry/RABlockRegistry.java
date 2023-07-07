package dev.teamcitrus.resourceants.registry;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.block.ResourceMushroomBlock;
import dev.teamcitrus.resourceants.util.MushroomResourceTiers;
import dev.teamcitrus.resourceants.item.ResourceMushroomItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RABlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourceAnts.MODID);
    public static final DeferredRegister<Item> MUSHROOMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceAnts.MODID);

    public static final RegistryObject<Block> COAL_MUSHROOM = registerMushroom("coal_mushroom", 0x63666A, 0, MushroomResourceTiers.ONE);
    public static final RegistryObject<Block> COPPER_MUSHROOM = registerMushroom("copper_mushroom", 0, 0, MushroomResourceTiers.ONE);
    public static final RegistryObject<Block> IRON_MUSHROOM = registerMushroom("iron_mushroom", 0, 0, MushroomResourceTiers.TWO);
    public static final RegistryObject<Block> LAPIS_MUSHROOM = registerMushroom("lapis_mushroom", 0, 0, MushroomResourceTiers.TWO);
    public static final RegistryObject<Block> GOLD_MUSHROOM = registerMushroom("gold_mushroom", 0, 0, MushroomResourceTiers.THREE);
    public static final RegistryObject<Block> REDSTONE_MUSHROOM = registerMushroom("redstone_mushroom", 0, 0, MushroomResourceTiers.THREE);
    public static final RegistryObject<Block> NETHER_QUARTZ_MUSHROOM = registerMushroom("nether_quartz_mushroom", 0, 0, MushroomResourceTiers.THREE);
    public static final RegistryObject<Block> DIAMOND_MUSHROOM = registerMushroom("diamond_mushroom", 0, 0, MushroomResourceTiers.FOUR);
    public static final RegistryObject<Block> EMERALD_MUSHROOM = registerMushroom("emerald_mushroom", 0, 0, MushroomResourceTiers.FOUR);
    public static final RegistryObject<Block> NETHERITE_MUSHROOM = registerMushroom("netherite_mushroom", 0, 0, MushroomResourceTiers.FIVE);

    private static RegistryObject<Block> registerMushroom(String name, int capColor, int stemColor, MushroomResourceTiers tier) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new ResourceMushroomBlock(capColor, stemColor, tier));
        MUSHROOMS.register(name, () -> new ResourceMushroomItem((ResourceMushroomBlock)block.get()));
        return block;
    }
}
