package net.snazzygator.snazzyherps.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.entity.custom.BeardedDragonEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BeardedDragonRenderer extends GeoEntityRenderer<BeardedDragonEntity> {
    private static final ResourceLocation NORMAL_LEMON = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal1.png");
    private static final ResourceLocation NORMAL_LILAC = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal2.png");
    private static final ResourceLocation NORMAL_PRETZEL = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal3.png");
    private static final ResourceLocation NORMAL_COFFEE = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal4.png");
    private static final ResourceLocation NORMAL_BUTTER = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_normal5.png");
    private static final ResourceLocation HYPO_PUMPKIN = new ResourceLocation("snazzyherps:textures/entity/bdragon/bdragon_hypo1.png");

    public BeardedDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BeardedDragonModel());
        this.shadowRadius = 0.2f;
    }

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

    @Override
    public RenderType getRenderType(BeardedDragonEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
        } else {
            stack.scale(1.0F, 1.0F, 1.0F);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
