package dev.teamcitrus.antics.registry;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.entity.ant.FarmerAnt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Antics.MODID);
    public static final RegistryObject<EntityType<FarmerAnt>> FARMER_ANT = ENTITY_TYPES.register("farmer_ant", () -> EntityType.Builder.of(FarmerAnt::new, MobCategory.CREATURE).sized(0.4F, 0.3F).build(Antics.id("ant").toString()));
}
