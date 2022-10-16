package net.snazzygator.snazzyherps.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.GoldenGeckoEntity;
import net.snazzygator.snazzyherps.entity.custom.GoldenGeckoEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GoldenGeckoModel extends AnimatedGeoModel<GoldenGeckoEntity> {

    @Override
    public ResourceLocation getModelLocation(GoldenGeckoEntity object) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "geo/smallgecko.geo.json");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GoldenGeckoEntity animatable) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "animations/smallgecko.animation.json");
    }

    @Override
    public void setLivingAnimations(GoldenGeckoEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    private static final ResourceLocation LEMON = new ResourceLocation("snazzyherps:textures/entity/smallgecko/goldengecko1.png");
    private static final ResourceLocation LEMONALT = new ResourceLocation("snazzyherps:textures/entity/smallgecko/goldengecko1.png");

    public ResourceLocation getTextureLocation(GoldenGeckoEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> LEMON;
            default -> LEMONALT;
        };
    }
}
