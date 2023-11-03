package dev.teamcitrus.antics.client.model;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.entity.Ant;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AntModel extends GeoModel<Ant> {
    @Override
    public ResourceLocation getModelResource(Ant animatable) {
        return Antics.id("geo/ant.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(Ant animatable) {
        return Antics.id("animations/ant.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(Ant animatable) {
        return Antics.id("textures/entity/ant.png");
    }
}
