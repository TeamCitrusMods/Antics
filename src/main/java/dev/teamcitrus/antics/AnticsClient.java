package dev.teamcitrus.antics;

import dev.teamcitrus.antics.registry.BlockEntityRegistry;
import dev.teamcitrus.antics.registry.BlockRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Antics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AnticsClient {
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null
                        ? BiomeColors.getAverageFoliageColor(pLevel, pPos)
                        : FoliageColor.getDefaultColor(),
                BlockRegistry.GREAT_HEMLOCK_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(),
                BlockRegistry.GREAT_HEMLOCK_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityRegistry.RA_SIGN_BLOCK.get(), SignRenderer::new);
    }
}
