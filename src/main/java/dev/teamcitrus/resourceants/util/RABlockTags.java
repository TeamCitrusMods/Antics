package dev.teamcitrus.resourceants.util;

import dev.teamcitrus.resourceants.ResourceAnts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class RABlockTags {
    public static final TagKey<Block> ALL_MUSHROOM_PLANTABLE = BlockTags.create(new ResourceLocation(ResourceAnts.MODID, "all_mushroom_plantable"));
}
