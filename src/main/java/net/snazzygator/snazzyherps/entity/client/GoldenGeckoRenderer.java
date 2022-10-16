package net.snazzygator.snazzyherps.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.entity.custom.GoldenGeckoEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class GoldenGeckoRenderer extends GeoEntityRenderer<GoldenGeckoEntity> {

    private static final ResourceLocation LEMON = new ResourceLocation("snazzyherps:textures/entity/smallgecko/goldengecko1.png");
    private static final ResourceLocation LEMONALT = new ResourceLocation("snazzyherps:textures/entity/smallgecko/goldengecko1.png");

    public GoldenGeckoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoldenGeckoModel());
        this.shadowRadius = 0.2f;
    }

    public ResourceLocation getTextureLocation(GoldenGeckoEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> LEMON;
            default -> LEMONALT;
        };
    }

    @Override
    public RenderType getRenderType(GoldenGeckoEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.4f, 0.4f, 0.4f);
        } else {
            stack.scale(0.8F, 0.8F, 0.8F);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
