package net.snazzygator.snazzyherps.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.entity.custom.DayGeckoSmallEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DayGeckoSmallRenderer extends GeoEntityRenderer<DayGeckoSmallEntity> {

    private static final ResourceLocation GOLDDUST_GREEN = new ResourceLocation("snazzyherps:textures/entity/smallgecko/golddust_daygecko2.png");
    private static final ResourceLocation GOLDDUST_BLUE = new ResourceLocation("snazzyherps:textures/entity/smallgecko/golddust_daygecko1.png");
    private static final ResourceLocation YELLOW_HEADED = new ResourceLocation("snazzyherps:textures/entity/smallgecko/yellowheaded_daygecko1.png");

    public DayGeckoSmallRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DayGeckoSmallModel());
        this.shadowRadius = 0.2f;
    }

    public ResourceLocation getTextureLocation(DayGeckoSmallEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> GOLDDUST_BLUE;
            case 2 -> YELLOW_HEADED;
            default -> GOLDDUST_GREEN;
        };
    }

    @Override
    public RenderType getRenderType(DayGeckoSmallEntity animatable, float partialTicks, PoseStack stack,
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
