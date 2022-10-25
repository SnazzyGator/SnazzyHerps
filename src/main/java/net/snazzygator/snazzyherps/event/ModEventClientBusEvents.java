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
        EntityRenderers.register(ModEntityTypes.BEARDEDDRAGON.get(), BeardedDragonRenderer::new);

        MenuScreens.register(ModMenuTypes.BUGBOX_MENU.get(), BugBoxScreen::new);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRITTERKEEPER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANKLIGHT_UVB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANKLIGHT_BASKING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIMLESS_TANKWALL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIMMED_TANKWALL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANKLID.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARKHIDE_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARKHIDE_BIRCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARKHIDE_SPRUCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARKHIDE_JUNGLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARKHIDE_ACACIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARKHIDE_DARKOAK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRANCH_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRANCH_BIRCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRANCH_SPRUCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRANCH_JUNGLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRANCH_ACACIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRANCH_DARKOAK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROUNDLOG_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROUNDLOG_BIRCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROUNDLOG_SPRUCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROUNDLOG_JUNGLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROUNDLOG_ACACIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROUNDLOG_DARKOAK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALLBRANCH_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALLBRANCH_BIRCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALLBRANCH_SPRUCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALLBRANCH_JUNGLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALLBRANCH_ACACIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALLBRANCH_DARKOAK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_STONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_ANDESITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_GRANITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_DIORITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_SANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_REDSANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_COBBLESTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKHIDE_MOSSYCOBBLESTONE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_STONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_ANDESITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_GRANITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_DIORITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_REDSANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_COBBLESTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_MOSSYCOBBLESTONE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_STONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_ANDESITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_GRANITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_DIORITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_SANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_REDSANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_COBBLESTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROCKLEDGE_SMALL_MOSSYCOBBLESTONE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_STONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_ANDESITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_GRANITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_DIORITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_SANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_REDSANDSTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_COBBLESTONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HEATROCK_MOSSYCOBBLESTONE.get(), RenderType.cutout());
    }
}
