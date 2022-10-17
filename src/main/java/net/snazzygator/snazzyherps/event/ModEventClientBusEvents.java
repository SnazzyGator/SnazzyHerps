package net.snazzygator.snazzyherps.event;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.blocks.ModBlocks;
import net.snazzygator.snazzyherps.entity.ModEntityTypes;
import net.snazzygator.snazzyherps.entity.client.*;
import net.snazzygator.snazzyherps.screen.BugBoxScreen;
import net.snazzygator.snazzyherps.screen.ModMenuTypes;

@Mod.EventBusSubscriber(modid = SnazzyHerps.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.BROWNANOLE.get(), BrownAnoleRenderer::new);
        EntityRenderers.register(ModEntityTypes.HOUSEGECKO.get(), HouseGeckoRenderer::new);
        EntityRenderers.register(ModEntityTypes.DAYGECKOSMALL.get(), DayGeckoSmallRenderer::new);
        EntityRenderers.register(ModEntityTypes.GOLDENGECKO.get(), GoldenGeckoRenderer::new);
        EntityRenderers.register(ModEntityTypes.SKINK.get(), BaseSkinkRenderer::new);
        EntityRenderers.register(ModEntityTypes.LEOPARDGECKO.get(), LeopardGeckoRenderer::new);
        EntityRenderers.register(ModEntityTypes.TESTLEO.get(), TestLeoRenderer::new);

        MenuScreens.register(ModMenuTypes.BUGBOX_MENU.get(), BugBoxScreen::new);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRITTERKEEPER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANKLIGHT_UVB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANKLIGHT_BASKING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIMLESS_TANKWALL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIMMED_TANKWALL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANKLID.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARKHIDE.get(), RenderType.cutout());
    }
}
