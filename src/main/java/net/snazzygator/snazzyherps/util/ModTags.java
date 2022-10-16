package net.snazzygator.snazzyherps.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.snazzygator.snazzyherps.SnazzyHerps;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> LIZARDFOODS = forgeTag("snazzyherps/lizardfoods");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SnazzyHerps.MOD_ID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
