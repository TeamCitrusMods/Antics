package dev.teamcitrus.antics.client.model;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.entity.ant.AbstractAnt;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AntModel extends GeoModel<AbstractAnt> {
    @Override
    public ResourceLocation getModelResource(AbstractAnt animatable) {
        return Antics.id("geo/ant.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(AbstractAnt animatable) {
        return Antics.id("animations/ant.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(AbstractAnt animatable) {
        return Antics.id("textures/entity/ant.png");
    }
}
