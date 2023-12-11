package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Antics.MODID);

    public static final RegistryObject<Item> ANT_CHITIN = register("ant_chitin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FARMER_ANT_SPAWN_EGG = register("farmer_ant_spawn_egg", () -> new ForgeSpawnEggItem(EntityRegistry.FARMER_ANT, 0x7B3F00, 0x6F4E37, new Item.Properties()));

    public static RegistryObject<Item> register(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }
}
