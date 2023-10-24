package dev.teamcitrus.antics.datagen.provider.lang;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.registry.BlockRegistry;
import dev.teamcitrus.antics.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Predicate;

public class EnUsProvider extends LanguageProvider {
    public EnUsProvider(PackOutput output) {
        super(output, Antics.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        Set<RegistryObject<Block>> blocks = new HashSet<>(BlockRegistry.BLOCKS.getEntries());
        Set<RegistryObject<Item>> items = new HashSet<>(ItemRegistry.ITEMS.getEntries());

        takeAll(blocks, i -> i.get() instanceof WallSignBlock);

        add("itemGroup.antics", "Antics");
        add("death.attack.falling_pinecone", "%s was killed by a falling pinecone");

        blocks.forEach(b -> {
            String name = b.get().getDescriptionId().replaceFirst("block\\.antics\\.", "");
            name = makeProper(toTitleCase(name, "_"));
            add(b.get().getDescriptionId(), name);
        });

        items.forEach(i -> {
            String name = i.get().getDescriptionId().replaceFirst("item\\.antics\\.", "");
            name = makeProper(toTitleCase(name, "_"));
            add(i.get().getDescriptionId(), name);
        });
    }

    /**
     * A method grabbed from Lodestone Lib by Egshels and SammySemiColon to capitalise names and replace [regex] with a space
     * <a href="https://github.com/LodestarMC/Lodestone/blob/65c087683cc1ac2698c4365d1026b00979234443/src/main/java/team/lodestar/lodestone/helpers/DataHelper.java#L36C30-L36C30">...</a>
     */
    private String toTitleCase(String givenString, String regex) {
        String[] stringArray = givenString.split(regex);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).append(regex);
        }
        return stringBuilder.toString().trim().replaceAll(regex, " ").substring(0, stringBuilder.length() - 1);
    }

    /**
     * A method grabbed from Malum by SammySemiColon to correct localisations from replacement
     * <a href="https://github.com/SammySemicolon/Malum-Mod/blob/28db31716acec731365d68cd07d9ea8c6de8a08f/src/main/java/com/sammy/malum/data/MalumLang.java#L585">...</a>
     */
    private String makeProper(String s) {
        s = s
                .replaceAll("Pinecone Block", "Pinecone")
        ;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    /**
     * removes all entry from a collection based off of a predicate and returns all items removed in a new collection
     */
    public static <T> Collection<T> takeAll(Collection<T> src, Predicate<T> pred) {
        List<T> ret = new ArrayList<>();

        Iterator<T> iter = src.iterator();
        while (iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item)) {
                iter.remove();
                ret.add(item);
            }
        }

        if (ret.isEmpty()) {
            return Collections.emptyList();
        }
        return ret;
    }
}
