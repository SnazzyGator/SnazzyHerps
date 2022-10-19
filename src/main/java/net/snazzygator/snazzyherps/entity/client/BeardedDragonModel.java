package net.snazzygator.snazzyherps.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.BeardedDragonEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BeardedDragonModel extends AnimatedGeoModel<BeardedDragonEntity> {

    @Override
    public ResourceLocation getModelLocation(BeardedDragonEntity object) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "geo/bdragon.geo.json");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BeardedDragonEntity animatable) {
        return new ResourceLocation(SnazzyHerps.MOD_ID, "animations/bdragon.animation.json");
    }

    @Override
    public void setLivingAnimations(BeardedDragonEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    private static final ResourceLocation NORMAL_LEMON = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal1.png");
    private static final ResourceLocation NORMAL_LILAC = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal2.png");
    private static final ResourceLocation NORMAL_PRETZEL = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal3.png");
    private static final ResourceLocation NORMAL_COFFEE = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal4.png");
    private static final ResourceLocation NORMAL_BUTTER = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal5.png");
    private static final ResourceLocation HYPO_PUMPKIN = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_hypo1.png");

    public ResourceLocation getTextureLocation(BeardedDragonEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> NORMAL_LILAC;
            case 2 -> NORMAL_PRETZEL;
            case 3 -> NORMAL_COFFEE;
            case 4 -> NORMAL_BUTTER;
            case 5 -> HYPO_PUMPKIN;
            default -> NORMAL_LEMON;
        };
    }
}
