package dev.teamcitrus.antics.util;

import dev.teamcitrus.antics.Antics;
import net.minecraft.resources.ResourceLocation;

public class RAUtils {
    public static ResourceLocation id(String name) {
        return new ResourceLocation(Antics.MODID, name);
    }
}
