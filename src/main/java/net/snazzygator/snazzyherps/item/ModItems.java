package net.snazzygator.snazzyherps.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.ModEntityTypes;
import net.snazzygator.snazzyherps.item.custom.BugFoodItem;
import net.snazzygator.snazzyherps.item.custom.LizardCookieItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SnazzyHerps.MOD_ID);

    public static final RegistryObject<Item> BROWNANOLE_SPAWNEGG = ITEMS.register("brownanole_spawnegg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BROWNANOLE, 0x93612F, 0xE9B51B,
                    new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB)));
    public static final RegistryObject<Item> HOUSEGECKO_SPAWNEGG = ITEMS.register("housegecko_spawnegg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.HOUSEGECKO, 0xD7C6A2, 0xA79061,
                    new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB)));
    public static final RegistryObject<Item> DAYGECKOSMALL_SPAWNEGG = ITEMS.register("daygeckosmall_spawnegg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DAYGECKOSMALL, 0x29BC26, 0xE45A36,
                    new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB)));
    public static final RegistryObject<Item> GOLDENGECKO_SPAWNEGG = ITEMS.register("goldengecko_spawnegg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOLDENGECKO, 0xE5D582, 0xF2BB19,
                    new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB)));
    public static final RegistryObject<Item> SKINK = ITEMS.register("skink_spawnegg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SKINK, 0x342F2D, 0x40D4FD,
                    new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB)));
    public static final RegistryObject<Item> LEOPARDGECKO = ITEMS.register("leopardgecko_spawnegg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LEOPARDGECKO, 0xE6C04F, 0x635734,
                    new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB)));

    public static final RegistryObject<Item> FOODFLY = ITEMS.register("foodfly",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB).food(ModFoods.FOODFLY)));
    public static final RegistryObject<Item> FOODCRICKET = ITEMS.register("foodcricket",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB).food(ModFoods.FOODCRICKET)));
    public static final RegistryObject<Item> FOODMEALWORM = ITEMS.register("foodmealworm",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB).food(ModFoods.FOODMEALWORM)));
    public static final RegistryObject<Item> FOODDUBIA = ITEMS.register("fooddubia",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB).food(ModFoods.FOODDUBIA)));
    public static final RegistryObject<Item> FOODWAXWORM = ITEMS.register("foodwaxworm",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB).food(ModFoods.FOODWAXWORM)));
    public static final RegistryObject<Item> FOODHORNWORM = ITEMS.register("foodhornworm",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB).food(ModFoods.FOODHORNWORM)));

    public static final RegistryObject<Item> BUGFOOD = ITEMS.register("bugfood",
            () -> new BugFoodItem(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB)));
    public static final RegistryObject<Item> LIZARD_COOKIE = ITEMS.register("lizard_cookie",
            () -> new LizardCookieItem(new Item.Properties().tab(ModCreativeModeTab.HERPS_TAB).food(ModFoods.LIZARD_COOKIE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
