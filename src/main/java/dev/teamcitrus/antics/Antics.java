package dev.teamcitrus.antics;

import dev.teamcitrus.antics.config.RAConfig;
import dev.teamcitrus.antics.registry.RABlockRegistry;
import dev.teamcitrus.antics.registry.RACreativeModeTabRegistry;
import dev.teamcitrus.antics.registry.RAItemRegistry;
import net.minecraft.world.item.AxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Antics.MODID)
public class Antics {
    public static final String MODID = "antics";

    public Antics() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, RAConfig.CLIENT_SPEC);

        RABlockRegistry.BLOCKS.register(bus);
        RABlockRegistry.ITEMS.register(bus);
        RAItemRegistry.ITEMS.register(bus);
        RACreativeModeTabRegistry.CREATIVE_TABS.register(bus);
    }
}
