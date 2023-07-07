package dev.teamcitrus.resourceants.util;

import dev.teamcitrus.resourceants.config.RAConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public enum MushroomResourceTiers {
    ONE("tier.one", "One", "1", ChatFormatting.YELLOW),
    TWO("tier.two", "Two", "2", ChatFormatting.GREEN),
    THREE("tier.three", "Three", "3", ChatFormatting.GOLD),
    FOUR("tier.four", "Four", "4", ChatFormatting.AQUA),
    FIVE("tier.five", "Five", "5", ChatFormatting.RED);

    private final String lang;
    private final String displayStr;
    private final String displayNum;
    private final ChatFormatting formatting;

    MushroomResourceTiers(String key, String name, String num, ChatFormatting formatting) {
        this.lang = key;
        this.displayStr = name;
        this.displayNum = num;
        this.formatting = formatting;
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

    public MutableComponent getDisplayName() {
        return Component.literal(RAConfig.tierDisplay.get().equals(TierDisplayOptions.TEXT)
                ? getNameStr()
                : getNameInt()
        ).withStyle(this.formatting);
    }
}
