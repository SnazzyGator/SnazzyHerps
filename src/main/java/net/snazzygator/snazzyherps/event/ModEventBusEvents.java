package net.snazzygator.snazzyherps.event;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.ModEntityTypes;
import net.snazzygator.snazzyherps.entity.custom.*;
import net.snazzygator.snazzyherps.recipe.BugBoxRecipe;

@Mod.EventBusSubscriber(modid = SnazzyHerps.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.BROWNANOLE.get(), BrownAnoleEntity.setAttributes());
        event.put(ModEntityTypes.HOUSEGECKO.get(), HouseGeckoEntity.setAttributes());
        event.put(ModEntityTypes.DAYGECKOSMALL.get(), DayGeckoSmallEntity.setAttributes());
        event.put(ModEntityTypes.GOLDENGECKO.get(), GoldenGeckoEntity.setAttributes());
        event.put(ModEntityTypes.SKINK.get(), BaseSkinkEntity.setAttributes());
        event.put(ModEntityTypes.LEOPARDGECKO.get(), LeopardGeckoEntity.setAttributes());
        event.put(ModEntityTypes.TESTLEO.get(), TestLeoEntity.setAttributes());
        event.put(ModEntityTypes.BEARDEDDRAGON.get(), TestLeoEntity.setAttributes());
    }
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, BugBoxRecipe.Type.ID, BugBoxRecipe.Type.INSTANCE);
    }
}
