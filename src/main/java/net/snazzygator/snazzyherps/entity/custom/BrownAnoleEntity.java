package net.snazzygator.snazzyherps.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.scores.Team;
import net.minecraftforge.event.ForgeEventFactory;
import net.snazzygator.snazzyherps.entity.ModEntityTypes;
import net.snazzygator.snazzyherps.item.ModItems;
import net.snazzygator.snazzyherps.util.ModTags;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class BrownAnoleEntity extends TamableAnimal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    static final Predicate<ItemEntity> ALLOWED_ITEMS = (itemEntity) -> {
        return !itemEntity.hasPickUpDelay() && itemEntity.isAlive();};
    private static final int MIN_TICKS_BEFORE_EAT = 100;
    private int ticksSinceEaten;

    public BrownAnoleEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.maxUpStep = 1.0F;
        this.setCanPickUpLoot(true);
    }

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(BrownAnoleEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DEWLAP =
            SynchedEntityData.defineId(BrownAnoleEntity.class, EntityDataSerializers.BOOLEAN);

    public float dewlapProgress;
    public int maxDewlapTime = 75;
    private int dewlapTime = 0;

    /**ATTRIBUTES**/
    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.1f)
                .add(Attributes.ATTACK_SPEED, 2.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f).build();
    }

    /**GOALS**/
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
        if (this.isTame()) {
            this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(ModItems.LIZARD_COOKIE.get()), false));}
        if (!this.isTame()) {
            this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Player.class, 6.0F, 1.25D, 1.25D));}
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new BrownAnoleEntity.HerpSearchForItemsGoal());
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 4.0F));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    /**DISPLAY**/
    public void tick() {
        super.tick();
        if (this.isDewlap() && dewlapProgress < 10) {
            dewlapProgress += 1;
        }
        if (!this.isDewlap() && dewlapProgress > 0) {
            dewlapProgress -= 1;
        }
        if (isDewlap() && ++dewlapTime > maxDewlapTime) {
            this.setDewlap(false);
            dewlapTime = 0;
            maxDewlapTime = 75 + random.nextInt(50);
        }
        if (this.isDewlap()) {
            this.getNavigation().stop();
        }
        if (this.isInLove()) {
            this.setDewlap(true);
        }
    }

    public boolean isDewlap() {
        return this.entityData.get(DEWLAP);
    }

    public void setDewlap(boolean dewlap) {
        this.entityData.set(DEWLAP, dewlap);
    }


    /**VARIANTS & SAVE DATA**/
    public static String getVariantName(int variant) {
        return switch (variant) {
            case 1 -> "male_butter";
            case 2 -> "female_coffee";
            case 3 -> "male_coffee";
            case 4 -> "female_red";
            case 5 -> "male_red";
            default -> "female_butter";
        };
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getVariant());
        tag.putBoolean("Dewlap", this.isDewlap());
    }
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(tag.getInt("Variant"));
        this.setDewlap(tag.getBoolean("Dewlap"));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(DEWLAP, Boolean.FALSE);
    }

    public boolean causeFallDamage(float v, float v1, DamageSource damageSource) {
        return false;
    }


    /**VARIANT SPAWNER**/
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        float variantChange = this.getRandom().nextFloat();
        if(variantChange <= 0.10){
            this.setVariant(5);
        }else if(variantChange <= 0.20){
            this.setVariant(4);
        }else if(variantChange <= 0.40F){
            this.setVariant(3);
        }else if(variantChange <= 0.60F){
            this.setVariant(2);
        }else if(variantChange <= 0.80F){
            this.setVariant(1);
        }else{
            this.setVariant(0);
        }
        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }


    /**BREEDING**/
    @Override
    public boolean canMate(Animal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (otherAnimal.getClass() != this.getClass()) {
            return false;
        } else if ((((BrownAnoleEntity) otherAnimal).getVariant() == 0
                || ((BrownAnoleEntity) otherAnimal).getVariant() == 2
                || ((BrownAnoleEntity) otherAnimal).getVariant() == 4)
                && (this.getVariant() == 1
                || this.getVariant() == 3
                || this.getVariant() == 5)) {
            return this.isInLove() && otherAnimal.isInLove();
        } else {
            return false;
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob mob) {
        BrownAnoleEntity baby = ModEntityTypes.BROWNANOLE.get().create(serverLevel);
        return baby;
    }

    @Override
    public boolean isFood(ItemStack pStack) {return pStack.is(ModTags.Items.LIZARDFOODS);}
    public boolean canBeLeashed(Player player) {return true;}


    /**CUSTOM DETECTORS (SPRINTING)**/
    @Override
    public void customServerAiStep() {
        if (this.getMoveControl().hasWanted()) {
            this.setSprinting(this.getMoveControl().getSpeedModifier() >= 1.25D);
        } else {
            this.setSprinting(false);
        }
        super.customServerAiStep();
    }

    @Override
    public boolean canSpawnSprintParticle() {
        return false;
    }


    /**ANIMATIONS**/
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.08F)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("brownanole.walk", true));
        } else if (isDewlap() && (BrownAnoleEntity.this.getVariant() == 1 || BrownAnoleEntity.this.getVariant() == 3 || BrownAnoleEntity.this.getVariant() == 5)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("brownanole.dewlap", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("brownanole.idle", true));
        }
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() { return this.factory;}


    /**SOUNDS**/
    @Override
    public float getVoicePitch() {return this.isBaby() ? super.getVoicePitch() * 0.65F : super.getVoicePitch();}

    protected SoundEvent getHurtSound(DamageSource pDamageSource) { return SoundEvents.GENERIC_HURT;}
    protected SoundEvent getDeathSound() { return SoundEvents.GENERIC_DEATH;}
    protected void playStepSound(BlockPos pos, BlockState blockIn) {this.playSound(SoundEvents.GRASS_STEP, 0.1F, 2.0F);}

    protected float getSoundVolume() { return 0.1F; }


    /**TAMING**/
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();

        Item itemForTaming = ModItems.LIZARD_COOKIE.get();

        if(isFood(itemstack)) {
            return super.mobInteract(player, hand);
        }

        if (item == itemForTaming && !isTame()) {
            if (this.level.isClientSide) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (!ForgeEventFactory.onAnimalTame(this, player)) {
                    if (!this.level.isClientSide) {
                        super.tame(player);
                        this.navigation.recomputePath();
                        this.setTarget(null);
                        this.level.broadcastEntityEvent(this, (byte)7);
                    }
                }

                return InteractionResult.SUCCESS;
            }
        }

        if (itemstack.getItem() == itemForTaming) {
            return InteractionResult.PASS;
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public Team getTeam() {
        return super.getTeam();
    }

    @Override
    public void setTame(boolean tamed) {
        super.setTame(tamed);
        if (tamed) {
            getAttribute(Attributes.MAX_HEALTH).setBaseValue(4.0D);
            getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0.1D);
            getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.2f);
        } else {
            getAttribute(Attributes.MAX_HEALTH).setBaseValue(4.0D);
            getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0.1D);
            getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.2f);
        }
    }


    /**ITEM PICKUP GOALS**/
    public SoundEvent getEatingSound(ItemStack itemStack) {
        return SoundEvents.GENERIC_EAT;
    }

    public void aiStep() {
        if (!this.level.isClientSide && this.isAlive() && this.isEffectiveAi()) {
            ++this.ticksSinceEaten;
            ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (this.canEat(itemstack)) {
                if (this.ticksSinceEaten > 100) {
                    ItemStack itemStack = itemstack.finishUsingItem(this.level, this);
                    if (!itemStack.isEmpty()) {
                        this.setItemSlot(EquipmentSlot.MAINHAND, itemStack);
                    }

                    this.ticksSinceEaten = 0;
                } else if (this.ticksSinceEaten > 60 && this.random.nextFloat() < 0.1F) {
                    this.playSound(this.getEatingSound(itemstack), 0.5F, 2.0F);
                    this.level.broadcastEntityEvent(this, (byte)45);
                }
            }
        }
        super.aiStep();
    }

    private boolean canEat(ItemStack itemStack) {
        return itemStack.getItem().isEdible() && this.getTarget() == null && this.onGround && !this.isSleeping();
    }

    protected void usePlayerItem(Player player, InteractionHand interactionHand, ItemStack itemStack) {
        if (this.isFood(itemStack)) {
            this.playSound(this.getEatingSound(itemStack), 0.5F, 2.0F);
        }

        super.usePlayerItem(player, interactionHand, itemStack);
    }

    public boolean canTakeItem(ItemStack itemStack) {
        EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(itemStack);
        if (!this.getItemBySlot(equipmentslot).isEmpty()) {
            return false;
        } else {
            return equipmentslot == EquipmentSlot.MAINHAND && super.canTakeItem(itemStack);
        }
    }

    public boolean canHoldItem(ItemStack itemStack) {
        Item item = itemStack.getItem();
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        return itemstack.isEmpty() || this.ticksSinceEaten > 0 && item.isEdible() && !itemstack.getItem().isEdible();
    }

    private void spitOutItem(ItemStack itemStack) {
        if (!itemStack.isEmpty() && !this.level.isClientSide) {
            ItemEntity itementity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, itemStack);
            itementity.setPickUpDelay(40);
            itementity.setThrower(this.getUUID());
            this.playSound(SoundEvents.FOX_SPIT, 0.5F, 2.0F);
            this.level.addFreshEntity(itementity);
        }
    }

    private void dropItemStack(ItemStack itemStack) {
        ItemEntity itementity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), itemStack);
        this.level.addFreshEntity(itementity);
    }

    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack itemstack = itemEntity.getItem();
        if (this.canHoldItem(itemstack)) {
            int i = itemstack.getCount();
            if (i > 1) {
                this.dropItemStack(itemstack.split(i - 1));
            }

            this.spitOutItem(this.getItemBySlot(EquipmentSlot.MAINHAND));
            this.onItemPickup(itemEntity);
            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
            this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
            this.take(itemEntity, itemstack.getCount());
            itemEntity.discard();
            this.ticksSinceEaten = 0;
        }
    }

    /*boolean canMove() {
        return !this.isInLove();}*/

    class HerpSearchForItemsGoal extends Goal {
        public HerpSearchForItemsGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (!BrownAnoleEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
                return false;
            } else if (BrownAnoleEntity.this.getTarget() == null && BrownAnoleEntity.this.getLastHurtByMob() == null) {
                if (BrownAnoleEntity.this.getRandom().nextInt(reducedTickDelay(10)) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = BrownAnoleEntity.this.level.getEntitiesOfClass(ItemEntity.class, BrownAnoleEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), BrownAnoleEntity.ALLOWED_ITEMS);
                    return !list.isEmpty() && BrownAnoleEntity.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        public void tick() {
            List<ItemEntity> list = BrownAnoleEntity.this.level.getEntitiesOfClass(ItemEntity.class, BrownAnoleEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), BrownAnoleEntity.ALLOWED_ITEMS);
            ItemStack itemstack = BrownAnoleEntity.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                BrownAnoleEntity.this.getNavigation().moveTo(list.get(0), (double)1.2F);
            }

        }

        public void start() {
            List<ItemEntity> list = BrownAnoleEntity.this.level.getEntitiesOfClass(ItemEntity.class, BrownAnoleEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), BrownAnoleEntity.ALLOWED_ITEMS);
            if (!list.isEmpty()) {
                BrownAnoleEntity.this.getNavigation().moveTo(list.get(0), (double)1.2F);
            }
        }
    }
    
}
