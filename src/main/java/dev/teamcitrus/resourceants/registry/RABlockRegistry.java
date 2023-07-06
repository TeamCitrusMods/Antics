package dev.teamcitrus.resourceants.registry;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.block.ResourceMushroomBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RABlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ResourceAnts.MODID);

    public static final RegistryObject<Block> COAL_MUSHROOM = BLOCKS.register("coal_mushroom", () -> new ResourceMushroomBlock(56063, 15582019));
}
