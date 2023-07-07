package dev.teamcitrus.resourceants.datagen.provider;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.util.RABlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class RABlockTagsProvider extends BlockTagsProvider {
    public RABlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, ResourceAnts.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(RABlockTags.ALL_MUSHROOM_PLANTABLE).addTag(BlockTags.DIRT).add(Blocks.FARMLAND);
    }
}
