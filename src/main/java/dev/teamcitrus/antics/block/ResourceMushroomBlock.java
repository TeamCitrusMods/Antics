package dev.teamcitrus.antics.block;

import dev.teamcitrus.antics.util.MushroomResourceTiers;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;

public class ResourceMushroomBlock extends BushBlock {
    private final MushroomResourceTiers tier;

    public ResourceMushroomBlock(MushroomResourceTiers tier) {
        super(Properties.copy(Blocks.BROWN_MUSHROOM));

        this.tier = tier;
    }

    public MushroomResourceTiers getTier() {
        return tier;
    }
}
