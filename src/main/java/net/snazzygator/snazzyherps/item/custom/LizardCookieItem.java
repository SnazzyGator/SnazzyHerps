package net.snazzygator.snazzyherps.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LizardCookieItem extends Item {
    public LizardCookieItem(Properties properties) {super(properties);}

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(new TranslatableComponent("tooltip.snazzyherps.lizardcookie.shift"));
        } else {
            components.add(new TranslatableComponent("tooltip.snazzyherps.lizardcookie"));
        }
    }
}
