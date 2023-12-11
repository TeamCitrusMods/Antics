package dev.teamcitrus.antics.client.render;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.client.model.FarmerAntModel;
import dev.teamcitrus.antics.entity.ant.AbstractAnt;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FarmerAntRenderer extends GeoEntityRenderer<AbstractAnt> {
    public FarmerAntRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FarmerAntModel());
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractAnt animatable) {
        return Antics.id("textures/entity/farmer_ant.png");
    }
}
