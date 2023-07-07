package dev.teamcitrus.resourceants.datagen.provider;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class RAItemTagsProvider extends ItemTagsProvider {
    public RAItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, ResourceAnts.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ItemTags.PIGLIN_LOVED).add(RABlockRegistry.GOLD_MUSHROOM.get().asItem());
    }

    @Override
    public String getName() {
        return "Resource Ants Item Tags Provider";
    }
}
