package net.snazzygator.snazzyherps.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.entity.custom.TestLeoEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TestLeoRenderer extends GeoEntityRenderer<TestLeoEntity> {
    private static final ResourceLocation NORMAL = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_normal1.png");
    private static final ResourceLocation NORMAL_HIORANGE = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_normal2.png");
    private static final ResourceLocation NORMAL_HIYELLOW = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_normal3.png");
    private static final ResourceLocation MACK_SNOW = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_macksnow1.png");
    private static final ResourceLocation MACK_SUPERSNOW = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_macksupersnow1.png");
    private static final ResourceLocation PATTERNLESS = new ResourceLocation("snazzyherps:textures/entity/leopardgecko/leopardgecko_patternless1.png");


    public TestLeoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TestLeoModel());
        this.shadowRadius = 0.2f;
    }

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

    @Override
    public RenderType getRenderType(TestLeoEntity animatable, float partialTicks, PoseStack stack,
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
