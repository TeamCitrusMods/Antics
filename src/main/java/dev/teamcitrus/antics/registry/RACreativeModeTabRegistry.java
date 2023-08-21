package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RACreativeModeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Antics.MODID);

    public static final RegistryObject<CreativeModeTab> TAB_RESOURCE_ANTS = CREATIVE_TABS.register("antics", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.antics"))
            .icon(() -> new ItemStack(Blocks.DIRT))
            .displayItems((pParameters, pOutput) -> {
                for (RegistryObject<Item> item : RABlockRegistry.ITEMS.getEntries()) {
                    pOutput.accept(item.get());
                }
                for (RegistryObject<Item> item : RAItemRegistry.ITEM_MAP) {
                    pOutput.accept(item.get());
                }
            })
            .build()
    );
}
