package dev.teamcitrus.resourceants.datagen.provider.lang;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.registry.RABlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EnUsProvider extends LanguageProvider {
    public EnUsProvider(DataGenerator gen) {
        super(gen, ResourceAnts.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.resourceants", "Resource Ants");

        RABlockRegistry.BLOCKS.getEntries().forEach(b -> {
            String name = b.get().getDescriptionId().replaceFirst("block\\.resourceants\\.", "");
            add(b.get().getDescriptionId(), toTitleCase(name, "_"));
        });
    }

    @Override
    public String getName() {
        return "Resource Ants Language En_Us Entries";
    }

    /**
     * A method grabbed from Lodestone Lib to capitalise names
     * Credit to Egshels and SammySemiColon for the Library
     */
    private static String toTitleCase(String givenString, String regex) {
        String[] stringArray = givenString.split(regex);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).append(regex);
        }
        return stringBuilder.toString().trim().replaceAll(regex, " ").substring(0, stringBuilder.length() - 1);
    }
}
