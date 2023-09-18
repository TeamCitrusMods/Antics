package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Antics.MODID);

    public static final RegistryObject<CreativeModeTab> TAB_RESOURCE_ANTS = CREATIVE_TABS.register("antics", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.antics"))
            .icon(() -> new ItemStack(BlockRegistry.GREAT_HEMLOCK_WOOD.get()))
            .displayItems((pParameters, pOutput) -> {
                for (RegistryObject<Item> item : BlockRegistry.ITEMS.getEntries()) {
                    pOutput.accept(item.get());
                }
                for (RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
                    pOutput.accept(item.get());
                }
            })
            .build()
    );
}
