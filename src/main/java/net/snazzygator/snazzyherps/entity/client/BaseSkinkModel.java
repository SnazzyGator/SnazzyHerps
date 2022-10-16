package net.snazzygator.snazzyherps.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.BaseSkinkEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BaseSkinkModel extends AnimatedGeoModel<BaseSkinkEntity> {

    @Override
    public ResourceLocation getModelLocation(BaseSkinkEntity object) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "geo/skink.geo.json");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BaseSkinkEntity animatable) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "animations/baseskink.animation.json");
    }

    @Override
    public void setLivingAnimations(BaseSkinkEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    private static final ResourceLocation THREELINE_BROWN = new ResourceLocation("snazzyherps:textures/entity/baseskink/threelined_skink1.png");
    private static final ResourceLocation FIVELINE_BLUE = new ResourceLocation("snazzyherps:textures/entity/baseskink/fivelined_skink1.png");
    private static final ResourceLocation FIVELINE_RED = new ResourceLocation("snazzyherps:textures/entity/baseskink/fivelined_skink2.png");
    private static final ResourceLocation FIVELINE_BLACK = new ResourceLocation("snazzyherps:textures/entity/baseskink/fivelined_skink3.png");
    private static final ResourceLocation GILBERT_RED = new ResourceLocation("snazzyherps:textures/entity/baseskink/gilbert_skink1.png");
    private static final ResourceLocation GREATPLAIN_GOLD = new ResourceLocation("snazzyherps:textures/entity/baseskink/greatplains_skink1.png");
    private static final ResourceLocation FIRE_SWEETTART = new ResourceLocation("snazzyherps:textures/entity/baseskink/sweettart_skink.png");

    public ResourceLocation getTextureLocation(BaseSkinkEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> FIVELINE_BLACK;
            case 2 -> FIVELINE_BLUE;
            case 3 -> THREELINE_BROWN;
            case 4 -> GILBERT_RED;
            case 5 -> GREATPLAIN_GOLD;
            case 6 -> FIRE_SWEETTART;
            default -> FIVELINE_RED;
        };
    }
}
