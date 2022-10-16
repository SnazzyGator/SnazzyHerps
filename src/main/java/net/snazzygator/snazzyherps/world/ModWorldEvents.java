package net.snazzygator.snazzyherps.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.world.gen.ModEntityGeneration;

@Mod.EventBusSubscriber(modid = SnazzyHerps.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModEntityGeneration.onEntitySpawn(event);
    }
}
