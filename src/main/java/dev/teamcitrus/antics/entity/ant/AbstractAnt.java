package dev.teamcitrus.antics.entity.ant;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.*;
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

import java.util.ArrayList;
import java.util.List;

/**
 * todo:
 *   - fix ants jumping super high in water
 *   - fix ant head rotation
 */
public abstract class AbstractAnt extends PathfinderMob implements GeoEntity, SmartBrainOwner<AbstractAnt> {

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public AbstractAnt(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8d)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .build();
    }

    @Override
    public List<ExtendedSensor<AbstractAnt>> getSensors() {
        List<ExtendedSensor<AbstractAnt>> out = new java.util.ArrayList<>(List.of(
                new NearbyLivingEntitySensor<>(),
                new NearbyPlayersSensor<>(),
                new HurtBySensor<>()
        ));
        List<ExtendedSensor<AbstractAnt>> custom = this.getCustomSensors();
        if(custom != null && custom.size() > 0) {
            out.addAll(custom);
        }
        return out;
    }

    /**
     * Override this to add custom sensors to an ant.
     */
    protected List<ExtendedSensor<AbstractAnt>> getCustomSensors() {
        return null;
    }

    @Override
    public BrainActivityGroup<? extends AbstractAnt> getCoreTasks() {
        List<Behavior<?>> tasks = new ArrayList<>(List.of(
                new LookAtTarget<AbstractAnt>(),
                new MoveToWalkTarget<AbstractAnt>(),
                new Swim(0.4f),
                new AnimalPanic(1.0f)));
        List<Behavior<?>> custom = this.getCustomCoreTasks();
        if(custom != null && custom.size() > 0) {
            tasks.addAll(custom);
        }
        return BrainActivityGroup.coreTasks(
                tasks.toArray(new Behavior[0])
        );
    }

    /**
     * Override this to add custom core tasks to an ant.
     */
    protected List<Behavior<?>> getCustomCoreTasks() {
        return null;
    }

    @Override
    public BrainActivityGroup<? extends AbstractAnt> getIdleTasks() {
        List<Behavior<?>> tasks = new ArrayList<>(List.of(
                new FirstApplicableBehaviour<>(
                        new SetPlayerLookTarget<>(),
                        new SetRandomLookTarget<>()
                ),
                new OneRandomBehaviour<>(
                        new SetRandomWalkTarget<>().speedModifier(0.6f),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(40, 100))
                )
        ));
        List<Behavior<?>> custom = this.getCustomIdleTasks();
        if(custom != null && custom.size() > 0) {
            tasks.addAll(custom);
        }
        return BrainActivityGroup.idleTasks(
                tasks.toArray(new Behavior[0])
        );
    }

    /**
     * Override this to add custom idle tasks to an ant.
     */
    protected List<Behavior<?>> getCustomIdleTasks() {
        return null;
    }

    @Override
    protected Brain.Provider<AbstractAnt> brainProvider() {
        return new SmartBrainProvider<>(this);
    }

    @Override
    protected void customServerAiStep() {
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
