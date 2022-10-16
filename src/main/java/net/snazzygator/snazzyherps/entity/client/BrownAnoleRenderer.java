package net.snazzygator.snazzyherps.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.snazzygator.snazzyherps.entity.custom.BrownAnoleEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BrownAnoleRenderer extends GeoEntityRenderer<BrownAnoleEntity> {

    private static final ResourceLocation MALE_BUTTER = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole1.png");
    private static final ResourceLocation MALE_COFFEE = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole2.png");
    private static final ResourceLocation MALE_RED = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole3.png");
    private static final ResourceLocation FEMALE_BUTTER = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole4.png");
    private static final ResourceLocation FEMALE_COFFEE = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole5.png");
    private static final ResourceLocation FEMALE_RED = new ResourceLocation("snazzyherps:textures/entity/brownanole/brownanole6.png");


    public BrownAnoleRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BrownAnoleModel());
        this.shadowRadius = 0.2f;
    }

    public ResourceLocation getTextureLocation(BrownAnoleEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> MALE_BUTTER;
            case 2 -> FEMALE_COFFEE;
            case 3 -> MALE_COFFEE;
            case 4 -> FEMALE_RED;
            case 5 -> MALE_RED;
            default -> FEMALE_BUTTER;
        };
    }

    @Override
    public RenderType getRenderType(BrownAnoleEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.3f, 0.3f, 0.3f);
        } else {
            stack.scale(0.6F, 0.6F, 0.6F);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
    
}
