package net.snazzygator.snazzyherps.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.entity.custom.HouseGeckoEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HouseGeckoRenderer extends GeoEntityRenderer<HouseGeckoEntity> {

    private static final ResourceLocation MEDGECKO = new ResourceLocation("snazzyherps:textures/entity/smallgecko/housegecko1.png");
    private static final ResourceLocation COMGECKO_COFFEE = new ResourceLocation("snazzyherps:textures/entity/smallgecko/housegecko2.png");
    private static final ResourceLocation COMGECKO_CREAM = new ResourceLocation("snazzyherps:textures/entity/smallgecko/housegecko3.png");

    public HouseGeckoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HouseGeckoModel());
        this.shadowRadius = 0.2f;
    }

    public ResourceLocation getTextureLocation(HouseGeckoEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> COMGECKO_COFFEE;
            case 2 -> COMGECKO_CREAM;
            default -> MEDGECKO;
        };
    }

    @Override
    public RenderType getRenderType(HouseGeckoEntity animatable, float partialTicks, PoseStack stack,
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
