package dev.teamcitrus.antics.client.model;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.entity.AntEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AntModel extends GeoModel<AntEntity> {
    @Override
    public ResourceLocation getModelResource(AntEntity animatable) {
        return Antics.id("geo/ant.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(AntEntity animatable) {
        return Antics.id("animations/ant.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(AntEntity animatable) {
        return Antics.id("textures/entity/ant.png");
    }
}
