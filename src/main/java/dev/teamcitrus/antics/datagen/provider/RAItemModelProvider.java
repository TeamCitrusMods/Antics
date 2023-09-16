package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RAItemModelProvider extends ItemModelProvider {
    public RAItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Antics.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        buttonInventory("great_hemlock_button", modLoc("block/great_hemlock_planks"));
        fenceInventory("great_hemlock_fence", modLoc("block/great_hemlock_planks"));
    }
}
