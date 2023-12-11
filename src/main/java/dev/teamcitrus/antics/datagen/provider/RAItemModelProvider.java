package dev.teamcitrus.antics.datagen.provider;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BlockRegistry;
import dev.teamcitrus.antics.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class RAItemModelProvider extends ItemModelProvider {
    public RAItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Antics.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        buttonInventory("great_hemlock_button", modLoc("block/great_hemlock_planks"));
        fenceInventory("great_hemlock_fence", modLoc("block/great_hemlock_planks"));
        basicItem(BlockRegistry.GREAT_HEMLOCK_DOOR.get().asItem());
        basicItem(BlockRegistry.GREAT_HEMLOCK_TRAPDOOR.get().asItem());
        controlledTextureBasicItem(BlockRegistry.GREAT_HEMLOCK_SAPLING.get().asItem(), "block");
        basicItem(BlockRegistry.GREAT_HEMLOCK_SIGN.get().asItem());
        basicItem(BlockRegistry.GREAT_HEMLOCK_HANGING_SIGN.get().asItem());
        basicItem(BlockRegistry.PINECONE_BLOCK.get().asItem());
        basicItem(BlockRegistry.EMPTY_PINECONE_BLOCK.get().asItem());
        basicItem(BlockRegistry.PINECONE_GARDEN.get().asItem());
        basicItem(BlockRegistry.BRANCH.get().asItem());
        basicItem(ItemRegistry.ANT_CHITIN.get());
        spawnEggItem(ItemRegistry.FARMER_ANT_SPAWN_EGG.get());
    }

    public void controlledTextureBasicItem(Item item, String folder) {
        getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(ForgeRegistries.ITEMS.getKey(item).getNamespace(), folder + "/" + ForgeRegistries.ITEMS.getKey(item).getPath()));
    }

    public void spawnEggItem(Item item) {
        getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("minecraft:item/template_spawn_egg"));
    }
}
