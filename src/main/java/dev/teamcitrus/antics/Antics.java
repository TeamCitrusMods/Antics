package dev.teamcitrus.antics;

import dev.teamcitrus.antics.registry.BlockRegistry;
import dev.teamcitrus.antics.registry.CreativeModeTabRegistry;
import dev.teamcitrus.antics.registry.ItemRegistry;
import dev.teamcitrus.antics.world.AnticsTreeDecoratorType;
import dev.teamcitrus.antics.world.regions.AnticsRegion;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;

@Mod(Antics.MODID)
public class Antics {
    public static final String MODID = "antics";

    public Antics() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);

        BlockRegistry.BLOCKS.register(bus);
        BlockRegistry.ITEMS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        CreativeModeTabRegistry.CREATIVE_TABS.register(bus);
        AnticsTreeDecoratorType.TREE_DECORATOR_TYPE.register(bus);
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(Antics.MODID, name);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new AnticsRegion(id("overworld"), 2));
        });
    }
}
