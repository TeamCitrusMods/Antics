package dev.teamcitrus.antics.client.render;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.client.model.AntModel;
import dev.teamcitrus.antics.entity.AntEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AntRenderer extends GeoEntityRenderer<AntEntity> {
    public AntRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AntModel());
    }

    @Override
    public ResourceLocation getTextureLocation(AntEntity animatable) {
        return Antics.id("textures/entity/ant.png");
    }
}
