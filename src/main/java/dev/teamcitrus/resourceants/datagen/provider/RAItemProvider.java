package dev.teamcitrus.resourceants.datagen.provider;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.block.ResourceMushroomBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class RAItemProvider extends ItemModelProvider {
    public RAItemProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ResourceAnts.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Resource Ants Item Models";
    }

    @Override
    protected void registerModels() {
        for (ResourceMushroomBlock block : ResourceMushroomBlock.getAllMushrooms()) {
            mushroomItemBuilder(block.asItem());
        }
    }

    private void mushroomItemBuilder(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        getBuilder(location.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(location.getNamespace(), "item/mushroom_top"))
                .texture("layer1", new ResourceLocation(location.getNamespace(), "item/mushroom_stem"));
    }
}
