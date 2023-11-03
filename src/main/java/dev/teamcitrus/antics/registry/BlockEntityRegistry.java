package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.block.sign.RAHangingSign;
import dev.teamcitrus.antics.block.sign.RASign;
import dev.teamcitrus.antics.entity.signs.RAHangingSignBlockEntity;
import dev.teamcitrus.antics.entity.signs.RASignBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Antics.MODID);
    public static final RegistryObject<BlockEntityType<RASignBlockEntity>> RA_SIGN_BLOCK = BLOCK_ENTITY_TYPES.register("sign", () -> BlockEntityType.Builder.of(RASignBlockEntity::new, getBlocks(RASign.RAStandingSignBlock.class, RASign.RAWallSignBlock.class)).build(null));
    public static final RegistryObject<BlockEntityType<RAHangingSignBlockEntity>> RA_HANGING_SIGN_BLOCK = BLOCK_ENTITY_TYPES.register("hanging_sign", () -> BlockEntityType.Builder.of(RAHangingSignBlockEntity::new, getBlocks(RAHangingSign.CustomCeilingHangingSignBlock.class, RAHangingSign.CustomWallHangingSignBlock.class)).build(null));

    public static Block[] getBlocks(Class<?>... blockClasses) {
        IForgeRegistry<Block> blocks = ForgeRegistries.BLOCKS;
        ArrayList<Block> matchingBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (Arrays.stream(blockClasses).anyMatch(b -> b.isInstance(block))) {
                matchingBlocks.add(block);
            }
        }
        return matchingBlocks.toArray(new Block[0]);
    }
}
