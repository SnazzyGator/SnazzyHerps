package net.snazzygator.snazzyherps.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.entity.custom.BaseSkinkEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BaseSkinkRenderer extends GeoEntityRenderer<BaseSkinkEntity> {
    private static final ResourceLocation THREELINE_BROWN = new ResourceLocation("snazzyherps:textures/entity/baseskink/threelined_skink1.png");
    private static final ResourceLocation FIVELINE_BLUE = new ResourceLocation("snazzyherps:textures/entity/baseskink/fivelined_skink1.png");
    private static final ResourceLocation FIVELINE_RED = new ResourceLocation("snazzyherps:textures/entity/baseskink/fivelined_skink2.png");
    private static final ResourceLocation FIVELINE_BLACK = new ResourceLocation("snazzyherps:textures/entity/baseskink/fivelined_skink3.png");
    private static final ResourceLocation GILBERT_RED = new ResourceLocation("snazzyherps:textures/entity/baseskink/gilbert_skink1.png");
    private static final ResourceLocation GREATPLAIN_GOLD = new ResourceLocation("snazzyherps:textures/entity/baseskink/greatplains_skink1.png");
    private static final ResourceLocation FIRE_SWEETTART = new ResourceLocation("snazzyherps:textures/entity/baseskink/sweettart_skink.png");


    public BaseSkinkRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BaseSkinkModel());
        this.shadowRadius = 0.2f;
    }

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

    @Override
    public RenderType getRenderType(BaseSkinkEntity animatable, float partialTicks, PoseStack stack,
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
