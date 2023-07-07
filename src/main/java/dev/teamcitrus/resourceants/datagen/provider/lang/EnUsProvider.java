package dev.teamcitrus.resourceants.datagen.provider.lang;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.util.MushroomResourceTiers;
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
        add("tooltip.resourceants.tier", "Tier: %s");

        RABlockRegistry.BLOCKS.getEntries().forEach(b -> {
            String name = b.get().getDescriptionId().replaceFirst("block\\.resourceants\\.", "");
            add(b.get().getDescriptionId(), toTitleCase(name, "_"));
        });

        for (MushroomResourceTiers tier : MushroomResourceTiers.values()) {
            add(tier.getLangKey(), tier.getNameStr());
        }
    }

    @Override
    public String getName() {
        return "Resource Ants Language En_Us Entries";
    }

    /**
     * A method grabbed from Lodestone Lib by Egshels and SammySemiColon to capitalise names and replace [regex] with a space
     * <a href="https://github.com/LodestarMC/Lodestone/blob/65c087683cc1ac2698c4365d1026b00979234443/src/main/java/team/lodestar/lodestone/helpers/DataHelper.java#L36C30-L36C30">...</a>
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
