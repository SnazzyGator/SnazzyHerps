package net.snazzygator.snazzyherps.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab HERPS_TAB = new CreativeModeTab("herps_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FOODHORNWORM.get());
        }
    };
}
