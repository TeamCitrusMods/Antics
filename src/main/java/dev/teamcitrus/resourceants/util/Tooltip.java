package dev.teamcitrus.resourceants.util;

import net.minecraft.ChatFormatting;

/**
 * A Snapshot of a Utility class from BlakeBr0's Cucumber Library for building complex tooltips
 * <a href="https://github.com/BlakeBr0/Cucumber/blob/1.19/src/main/java/com/blakebr0/cucumber/util/Tooltip.java">...</a>
 */
public class Tooltip extends Localizable {
    public Tooltip(String key) {
        super(key, ChatFormatting.GRAY);
    }
}
