package net.snazzygator.snazzyherps.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.DayGeckoSmallEntity;
import net.snazzygator.snazzyherps.entity.custom.DayGeckoSmallEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class DayGeckoSmallModel extends AnimatedGeoModel<DayGeckoSmallEntity> {

    @Override
    public ResourceLocation getModelLocation(DayGeckoSmallEntity object) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "geo/smallgecko.geo.json");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DayGeckoSmallEntity animatable) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "animations/smallgecko.animation.json");
    }

    @Override
    public void setLivingAnimations(DayGeckoSmallEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    private static final ResourceLocation GOLDDUST_GREEN = new ResourceLocation("snazzyherps:textures/entity/smallgecko/golddust_daygecko2.png");
    private static final ResourceLocation GOLDDUST_BLUE = new ResourceLocation("snazzyherps:textures/entity/smallgecko/golddust_daygecko1.png");
    private static final ResourceLocation YELLOW_HEADED = new ResourceLocation("snazzyherps:textures/entity/smallgecko/yellowheaded_daygecko1.png");

    public ResourceLocation getTextureLocation(DayGeckoSmallEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> GOLDDUST_BLUE;
            case 2 -> YELLOW_HEADED;
            default -> GOLDDUST_GREEN;
        };
    }
}
