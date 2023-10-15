package dev.teamcitrus.antics.world;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.world.tree.decorators.PineconeAttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AnticsTreeDecoratorType {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPE = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Antics.MODID);
    public static final RegistryObject<TreeDecoratorType<PineconeAttachedToLeavesDecorator>> PINECONE_ATTACHED_TO_LEAVES = TREE_DECORATOR_TYPE.register("pinecone_attached_to_tree", () -> new TreeDecoratorType<>(PineconeAttachedToLeavesDecorator.CODEC));
}
