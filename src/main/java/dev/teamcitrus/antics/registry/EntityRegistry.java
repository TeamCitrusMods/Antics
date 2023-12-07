package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.entity.AntEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Antics.MODID);
    public static final RegistryObject<EntityType<AntEntity>> ANT = ENTITY_TYPES.register("ant", () -> EntityType.Builder.of(AntEntity::new, MobCategory.AMBIENT).sized(0.4F, 0.3F).build(Antics.id("ant").toString()));
}
