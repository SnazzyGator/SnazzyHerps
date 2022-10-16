package net.snazzygator.snazzyherps;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.snazzygator.snazzyherps.blocks.ModBlocks;
import net.snazzygator.snazzyherps.blocks.entity.ModBlockEntities;
import net.snazzygator.snazzyherps.entity.ModEntityTypes;
import net.snazzygator.snazzyherps.item.ModItems;
import net.snazzygator.snazzyherps.recipe.ModRecipes;
import net.snazzygator.snazzyherps.screen.ModMenuTypes;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SnazzyHerps.MOD_ID)
public class SnazzyHerps {
    public static final String MOD_ID = "snazzyherps";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public SnazzyHerps() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);

        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("Hissssss!");
    }
}
