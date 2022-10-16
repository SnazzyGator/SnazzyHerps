package net.snazzygator.snazzyherps.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.BrownAnoleEntity;
import net.snazzygator.snazzyherps.entity.custom.TestLeoEntity;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BrownAnoleModel extends AnimatedGeoModel<BrownAnoleEntity> {

    @Override
    public ResourceLocation getModelLocation(BrownAnoleEntity object) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "geo/brownanole.geo.json");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BrownAnoleEntity animatable) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "animations/brownanole.animation.json");
    }

    @Override
    public void setLivingAnimations(BrownAnoleEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    private static final ResourceLocation MALE_BUTTER = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole1.png");
    private static final ResourceLocation MALE_COFFEE = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole2.png");
    private static final ResourceLocation MALE_RED = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole3.png");
    private static final ResourceLocation FEMALE_BUTTER = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole4.png");
    private static final ResourceLocation FEMALE_COFFEE = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole5.png");
    private static final ResourceLocation FEMALE_RED = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole6.png");

    public ResourceLocation getTextureLocation(BrownAnoleEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> MALE_BUTTER;
            case 2 -> FEMALE_COFFEE;
            case 3 -> MALE_COFFEE;
            case 4 -> FEMALE_RED;
            case 5 -> MALE_RED;
            default -> FEMALE_BUTTER;
        };
    }

}
