package net.snazzygator.snazzyherps.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.TestLeoEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class TestLeoModel extends AnimatedGeoModel<TestLeoEntity> {

    @Override
    public ResourceLocation getModelLocation(TestLeoEntity object) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "geo/leopardgecko.geo.json");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TestLeoEntity animatable) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "animations/leopardgecko.animation.json");
    }

    @Override
    public void setLivingAnimations(TestLeoEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    private static final ResourceLocation NORMAL = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_normal1.png");
    private static final ResourceLocation NORMAL_HIORANGE = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_normal2.png");
    private static final ResourceLocation NORMAL_HIYELLOW = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_normal3.png");
    private static final ResourceLocation MACK_SNOW = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_macksnow1.png");
    private static final ResourceLocation MACK_SUPERSNOW = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_macksupersnow1.png");
    private static final ResourceLocation PATTERNLESS = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_patternless1.png");

    public ResourceLocation getTextureLocation(TestLeoEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> NORMAL_HIORANGE;
            case 2 -> NORMAL_HIYELLOW;
            case 3 -> MACK_SNOW;
            case 4 -> MACK_SUPERSNOW;
            case 5 -> PATTERNLESS;
            default -> NORMAL;
        };
    }
}
