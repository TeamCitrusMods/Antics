package dev.teamcitrus.antics.registry;

import com.google.common.collect.Sets;
import dev.teamcitrus.antics.Antics;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class RAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Antics.MODID);
    public static LinkedHashSet<RegistryObject<Item>> ITEM_MAP = Sets.newLinkedHashSet();

    public static RegistryObject<Item> register(String name, Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        ITEM_MAP.add(block);
        return block;
    }
}
