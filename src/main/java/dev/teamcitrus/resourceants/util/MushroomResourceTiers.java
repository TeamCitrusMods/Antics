package dev.teamcitrus.resourceants.util;

import dev.teamcitrus.resourceants.config.RAConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Rarity;

public enum MushroomResourceTiers {
    ONE("tier.one", "One", "1", RARarities.TIER_ONE),
    TWO("tier.two", "Two", "2", RARarities.TIER_TWO),
    THREE("tier.three", "Three", "3", RARarities.TIER_THREE),
    FOUR("tier.four", "Four", "4", RARarities.TIER_FOUR),
    FIVE("tier.five", "Five", "5", RARarities.TIER_FIVE);

    private final String lang;
    private final String displayStr;
    private final String displayNum;
    private final Rarity rarity;

    MushroomResourceTiers(String key, String name, String num, Rarity rarity) {
        this.lang = key;
        this.displayStr = name;
        this.displayNum = num;
        this.rarity = rarity;
    }

    public String getLangKey() {
        return this.lang;
    }

    public String getNameStr() {
        return this.displayStr;
    }

    public String getNameInt() {
        return this.displayNum;
    }

    public Rarity getRarity() {
        return this.rarity;
    }

    public MutableComponent getDisplayName() {
        return Component.literal(RAConfig.tierDisplay.get().equals(TierDisplayOptions.TEXT)
                ? getNameStr()
                : getNameInt()
        ).withStyle(this.rarity.getStyleModifier());
    }
}
