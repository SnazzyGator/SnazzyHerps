package net.snazzygator.snazzyherps.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.HouseGeckoEntity;
import net.snazzygator.snazzyherps.entity.custom.TestLeoEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class HouseGeckoModel extends AnimatedGeoModel<HouseGeckoEntity> {

    @Override
    public ResourceLocation getModelLocation(HouseGeckoEntity object) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "geo/smallgecko.geo.json");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(HouseGeckoEntity animatable) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "animations/smallgecko.animation.json");
    }

    @Override
    public void setLivingAnimations(HouseGeckoEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    private static final ResourceLocation MEDGECKO = new ResourceLocation("snazzyherps:textures/entity/smallgecko/housegecko1.png");
    private static final ResourceLocation COMGECKO_COFFEE = new ResourceLocation("snazzyherps:textures/entity/smallgecko/housegecko2.png");
    private static final ResourceLocation COMGECKO_CREAM = new ResourceLocation("snazzyherps:textures/entity/smallgecko/housegecko3.png");

    public ResourceLocation getTextureLocation(HouseGeckoEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> COMGECKO_COFFEE;
            case 2 -> COMGECKO_CREAM;
            default -> MEDGECKO;
        };
    }
}
