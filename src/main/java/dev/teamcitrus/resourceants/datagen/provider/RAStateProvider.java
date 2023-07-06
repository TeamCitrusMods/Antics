package dev.teamcitrus.resourceants.datagen.provider;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RAStateProvider extends BlockStateProvider {
    public RAStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ResourceAnts.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        mushroomStateBuilder(RABlockRegistry.COAL_MUSHROOM.get());
    }

    private void mushroomStateBuilder(Block block) {
        getVariantBuilder(block).partialState();
    }
}
