package dev.teamcitrus.resourceants.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class ResourceMushroomBlock extends Block {
    private static final List<ResourceMushroomBlock> LIST = new ArrayList<>();
    private final int mainColor;
    private final int edgingColor;

    public ResourceMushroomBlock(int backgroundColor, int highlightColor) {
        super(Properties.copy(Blocks.BROWN_MUSHROOM));

        this.mainColor = backgroundColor;
        this.edgingColor = highlightColor;

        LIST.add(this);
    }

    public int getColor(int pTintIndex) {
        return pTintIndex == 0 ? this.mainColor : this.edgingColor;
    }

    public static List<ResourceMushroomBlock> getAllMushrooms() {
        return LIST;
    }
}
