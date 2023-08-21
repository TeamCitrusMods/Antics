package dev.teamcitrus.antics.util;

import dev.teamcitrus.antics.config.RAConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public enum MushroomResourceTiers {
    ONE("tier.one.str", "One", "1", "tier.one.num", ChatFormatting.YELLOW),
    TWO("tier.two.str", "Two", "2", "tier.two.num", ChatFormatting.GREEN),
    THREE("tier.three.str", "Three", "3", "tier.three.num", ChatFormatting.GOLD),
    FOUR("tier.four.str", "Four", "4", "tier.four.num", ChatFormatting.AQUA),
    FIVE("tier.five.str", "Five", "5", "tier.five.num", ChatFormatting.RED);

    private final String langString;
    private final String displayStr;
    private final String displayNum;
    private final String langNum;
    private final ChatFormatting formatting;

    MushroomResourceTiers(String nameKey, String name, String num, String numKey, ChatFormatting formatting) {
        this.langString = nameKey;
        this.displayStr = name;
        this.displayNum = num;
        this.langNum = numKey;
        this.formatting = formatting;
    }

    public String getLangKey() {
        return this.langString;
    }

    public String getNameStr() {
        return this.displayStr;
    }

    public String getNameInt() {
        return this.displayNum;
    }

    public String getNumKey() {
        return this.langNum;
    }

    public MutableComponent getLocalDisplayName() {
        if(RAConfig.tierDisplay.get().equals(TierDisplayOptions.TEXT)) {
            return Component.translatable(getLangKey()).withStyle(this.formatting);
        }
        return Component.translatable(getNumKey()).withStyle(this.formatting);
    }
}
