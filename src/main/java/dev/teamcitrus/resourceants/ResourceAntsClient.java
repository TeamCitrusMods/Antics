package dev.teamcitrus.resourceants;

import dev.teamcitrus.resourceants.block.ResourceMushroomBlock;
import dev.teamcitrus.resourceants.item.ResourceMushroomItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ResourceAnts.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ResourceAntsClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {}

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        for (ResourceMushroomBlock block : ResourceMushroomBlock.getAllMushrooms()) {
            event.register((pState, pLevel, pPos, pTintIndex) -> block.getColor(pTintIndex), block);
        }
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        for (ResourceMushroomItem item : ResourceMushroomItem.getAllMushrooms()) {
            event.register((pStack, pTintIndex) -> ((ResourceMushroomBlock)item.getBlock()).getColor(pTintIndex), item);
        }
    }
}
