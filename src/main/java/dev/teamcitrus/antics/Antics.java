package dev.teamcitrus.antics;

import dev.teamcitrus.antics.entity.AntEntity;
import dev.teamcitrus.antics.registry.*;
import dev.teamcitrus.antics.world.regions.AnticsRegion;
import dev.teamcitrus.antics.world.surfacerule.AnticsSurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(Antics.MODID)
public class Antics {
    public static final String MODID = "antics";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Antics() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegistry.BLOCKS.register(bus);
        BlockRegistry.ITEMS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        EntityRegistry.ENTITY_TYPES.register(bus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(bus);
        CreativeModeTabRegistry.CREATIVE_TABS.register(bus);
        TreeDecoratorTypeRegistry.TREE_DECORATOR_TYPE.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::entityAttributesEvent);
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(Antics.MODID, name);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new AnticsRegion(id("overworld"), 10));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, AnticsSurfaceRuleData.makeRules());
        });
    }

    private void entityAttributesEvent(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.ANT.get(), AntEntity.createAttributes());
    }
}
