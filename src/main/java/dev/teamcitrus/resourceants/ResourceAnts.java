package dev.teamcitrus.resourceants;

import dev.teamcitrus.resourceants.config.RAConfig;
import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import dev.teamcitrus.resourceants.registry.RAItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ResourceAnts.MODID)
public class ResourceAnts {
    public static final String MODID = "resourceants";

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RABlockRegistry.COAL_MUSHROOM.get().asItem());
        }
    };

    public ResourceAnts() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, RAConfig.CLIENT_SPEC);

        RABlockRegistry.BLOCKS.register(bus);
        RABlockRegistry.MUSHROOMS.register(bus);
        RAItemRegistry.ITEMS.register(bus);
    }
}
