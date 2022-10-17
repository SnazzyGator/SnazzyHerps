package net.snazzygator.snazzyherps.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BugFoodItem extends BoneMealItem {
    public static final int GRASS_SPREAD_WIDTH = 1;
    public static final int GRASS_SPREAD_HEIGHT = 1;
    public static final int GRASS_COUNT_MULTIPLIER = 1;

    public BugFoodItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(new TranslatableComponent("tooltip.snazzyherps.bugfood"));
        } else {
            components.add(new TranslatableComponent("tooltip.snazzyherps.bugfood.shift"));
        }
    }
}
