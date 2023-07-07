package dev.teamcitrus.resourceants.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class ResourceMushroomBlock extends Block {
    private static final List<ResourceMushroomBlock> LIST = new ArrayList<>();
    private final int mushroomColor;
    private final int stemColor;

    public ResourceMushroomBlock(int mushroomColor, int stemColor) {
        super(Properties.copy(Blocks.BROWN_MUSHROOM));

        this.mushroomColor = mushroomColor;
        this.stemColor = stemColor;

        LIST.add(this);
    }

    public int getColor(int pTintIndex) {
        return pTintIndex == 0 ? this.mushroomColor : this.stemColor;
    }

    public static List<ResourceMushroomBlock> getAllMushrooms() {
        return LIST;
    }
}
