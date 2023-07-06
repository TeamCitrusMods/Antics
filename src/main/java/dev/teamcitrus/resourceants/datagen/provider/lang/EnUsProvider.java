package dev.teamcitrus.resourceants.datagen.provider.lang;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import dev.teamcitrus.resourceants.registry.RAItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import team.lodestar.lodestone.helpers.DataHelper;

import java.util.HashSet;
import java.util.Set;

public class EnUsProvider extends LanguageProvider {
    public EnUsProvider(DataGenerator gen) {
        super(gen, ResourceAnts.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        Set<RegistryObject<Block>> blocks = new HashSet<>(RABlockRegistry.BLOCKS.getEntries());
        Set<RegistryObject<Item>> items = new HashSet<>(RAItemRegistry.ITEMS.getEntries());

        DataHelper.takeAll(items, i -> i.get() instanceof BlockItem);

        add("itemGroup.resourceants", "Resource Ants");

        blocks.forEach(b -> {
            String name = b.get().getDescriptionId().replaceFirst("block\\.resourceants\\.", "");
            name = DataHelper.toTitleCase(name, "_");
            add(b.get().getDescriptionId(), name);
        });

        items.forEach(i -> {
            String name = i.get().getDescriptionId().replaceFirst("item\\.resourceants\\.", "");
            name = DataHelper.toTitleCase(name, "_");
            add(i.get().getDescriptionId(), name);
        });
    }

    @Override
    public String getName() {
        return "Resource Ants Language En_Us Entries";
    }
}
