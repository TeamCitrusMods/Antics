package dev.teamcitrus.resourceants;

import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import dev.teamcitrus.resourceants.registry.RAItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ResourceAnts.MODID)
public class ResourceAnts {
    public static final String MODID = "resourceants";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RABlockRegistry.COAL_MUSHROOM.get().asItem());
        }
    };

    public ResourceAnts() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RABlockRegistry.BLOCKS.register(bus);
        RABlockRegistry.MUSHROOMS.register(bus);
        RAItemRegistry.ITEMS.register(bus);

        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) { }
}
