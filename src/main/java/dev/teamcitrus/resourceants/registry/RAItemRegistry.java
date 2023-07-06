package dev.teamcitrus.resourceants.registry;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.item.ResourceMushroomItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceAnts.MODID);

    public static final RegistryObject<Item> COAL_MUSHROOM_ITEM = ITEMS.register("coal_mushroom", () -> new ResourceMushroomItem(RABlockRegistry.COAL_MUSHROOM.get()));
}
