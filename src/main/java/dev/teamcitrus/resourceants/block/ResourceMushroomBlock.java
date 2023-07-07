package dev.teamcitrus.resourceants.block;

import dev.teamcitrus.resourceants.util.MushroomResourceTiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class ResourceMushroomBlock extends Block {
    private static final List<ResourceMushroomBlock> LIST = new ArrayList<>();
    private final int mushroomColor;
    private final int stemColor;
    private final MushroomResourceTiers tier;

    public ResourceMushroomBlock(int mushroomColor, int stemColor, MushroomResourceTiers tier) {
        super(Properties.copy(Blocks.BROWN_MUSHROOM));

        this.mushroomColor = mushroomColor;
        this.stemColor = stemColor;
        this.tier = tier;

        LIST.add(this);
    }

    public int getColor(int pTintIndex) {
        return pTintIndex == 0 ? this.mushroomColor : this.stemColor;
    }

    public MushroomResourceTiers getTier() {
        return this.tier;
    }

    public static List<ResourceMushroomBlock> getAllMushrooms() {
        return LIST;
    }
}
