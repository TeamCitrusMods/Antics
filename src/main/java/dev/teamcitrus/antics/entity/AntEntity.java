package dev.teamcitrus.antics.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetPlayerLookTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.HurtBySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyPlayersSensor;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

/**
 * todo:
 *   - fix ants jumping super high in water
 *   - create AbstractAnt parent class
 */
@SuppressWarnings("deprecation")
public class AntEntity extends PathfinderMob implements GeoEntity, SmartBrainOwner<AntEntity> {


//    protected static final List<SensorType<? extends Sensor<? super AntEntity>>> SENSOR_TYPES = ImmutableList.of(
//            SensorType.NEAREST_LIVING_ENTITIES, SensorType.HURT_BY);
    protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
            MemoryModuleType.LOOK_TARGET, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES,
            MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
            MemoryModuleType.PATH, MemoryModuleType.IS_PANICKING);


    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public AntEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8d)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .build();
    }

    @Override
    public List<ExtendedSensor<AntEntity>> getSensors() {
        return List.of(
                new NearbyLivingEntitySensor<>(),
                new NearbyPlayersSensor<>(),
                new HurtBySensor<>()
        );
    }

//    @Override
//    protected Brain<?> makeBrain(Dynamic<?> pDynamic) {
//        Brain<AntEntity> brain = this.brainProvider().makeBrain(pDynamic);
//        registerBrainActivities(brain);
//        return brain;
//    }


    @Override
    public BrainActivityGroup<? extends AntEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),
                new MoveToWalkTarget<>(),
                new Swim(0.4f),
                new AnimalPanic(1.0f)
        );
    }

    @Override
    public BrainActivityGroup<? extends AntEntity> getIdleTasks() {
        return BrainActivityGroup.idleTasks(
                new FirstApplicableBehaviour<AntEntity>(
                        new SetPlayerLookTarget<>(),
                        new SetRandomLookTarget<>()
                ),
                new OneRandomBehaviour<>(
                        new SetRandomWalkTarget<>().speedModifier(0.6f),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(40, 100))
                )
        );
    }

    private void registerBrainActivities(Brain<AntEntity> brain) {
        brain.addActivity(Activity.CORE, 0, ImmutableList.of(
                new Swim(0.4f),
                new AnimalPanic(0.9f),
                new LookAtTargetSink(45, 90),
                new MoveToTargetSink()
        ));
        brain.addActivity(Activity.IDLE, ImmutableList.of(
                Pair.of(0, SetEntityLookTargetSometimes.create(EntityType.PLAYER, 8.0f, UniformInt.of(30, 80))),
                Pair.of(1, new RunOne<>(ImmutableList.of(
                        Pair.of(RandomStroll.stroll(0.6F), 6),
                        Pair.of(new DoNothing(50, 100), 1),
                        Pair.of(new RandomLookAround(UniformInt.of(150, 250), 30.0F, 0.0F, 0.0F), 2)
                        ))
                )
        ));
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.useDefaultActivity();
    }

    @Override
    protected Brain.Provider<AntEntity> brainProvider() {
//        return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
        return new SmartBrainProvider<>(this);
    }

    public void updateActivity() {
        this.getBrain().setActiveActivityToFirstValid(ImmutableList.of(Activity.IDLE));
    }


//    @Override
//    public Brain<AntEntity> getBrain() {
//        return (Brain<AntEntity>) super.getBrain();
//    }

    @Override
    protected void customServerAiStep() {
//        this.level().getProfiler().push("antBrain");
//        this.getBrain().tick((ServerLevel)this.level(), this);
//        this.level().getProfiler().pop();
//        this.level().getProfiler().push("antActivityUpdate");
//        updateActivity();
//        this.level().getProfiler().pop();
        tickBrain(this);

        super.customServerAiStep();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> event) {
        if(event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("animation.ant.walking", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
