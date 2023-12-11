package dev.teamcitrus.antics.client.model;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.entity.ant.AbstractAnt;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FarmerAntModel extends GeoModel<AbstractAnt> {
    @Override
    public ResourceLocation getModelResource(AbstractAnt animatable) {
        return Antics.id("geo/farmer_ant.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(AbstractAnt animatable) {
        return Antics.id("animations/farmer_ant.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(AbstractAnt animatable) {
        return Antics.id("textures/entity/farmer_ant.png");
    }
}
