package net.snazzygator.snazzyherps.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snazzygator.snazzyherps.SnazzyHerps;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SnazzyHerps.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BugBoxRecipe>> BUGBOX_BREEDING_CRAFTHELPER =
            SERIALIZERS.register("bugbox_breeding", () -> BugBoxRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
