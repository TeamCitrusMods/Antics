package dev.teamcitrus.resourceants.datagen.provider;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.block.ResourceMushroomBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RAStateProvider extends BlockStateProvider {
    public RAStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ResourceAnts.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (ResourceMushroomBlock block : ResourceMushroomBlock.getAllMushrooms()) {
            simpleBlock(block, models().getExistingFile(new ResourceLocation(ResourceAnts.MODID, "mushroom")));
        }
    }
}