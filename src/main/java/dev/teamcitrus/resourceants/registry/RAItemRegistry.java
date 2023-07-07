package dev.teamcitrus.resourceants.registry;

import dev.teamcitrus.resourceants.ResourceAnts;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceAnts.MODID);
}
