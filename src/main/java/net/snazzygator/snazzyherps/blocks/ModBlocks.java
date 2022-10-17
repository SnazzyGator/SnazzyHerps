package net.snazzygator.snazzyherps.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.blocks.custom.*;
import net.snazzygator.snazzyherps.item.ModCreativeModeTab;
import net.snazzygator.snazzyherps.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SnazzyHerps.MOD_ID);

    public static final RegistryObject<Block> CRITTERKEEPER = registerBlock("critterkeeper",
            () -> new CritterKeeperBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> TANKLIGHT_UVB = registerBlock("tanklight_uvb",
            () -> new TanklightUvbBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .lightLevel((state) -> state.getValue(TanklightUvbBlock.CLICKED) ? 5 : 0)
                    .sound(SoundType.LANTERN).noOcclusion()), ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> TANKLIGHT_BASKING = registerBlock("tanklight_basking",
            () -> new TanklightBaskingBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .lightLevel((state) -> state.getValue(TanklightBaskingBlock.CLICKED) ? 15 : 0)
                    .sound(SoundType.LANTERN).noOcclusion()), ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> RIMLESS_TANKWALL = registerBlock("rimless_tankwall",
            () -> new RimlessTankwallBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> RIMMED_TANKWALL = registerBlock("rimmed_tankwall",
            () -> new RimlessTankwallBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> TANKLID = registerBlock("tanklid",
            () -> new TankLidBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BARKHIDE = registerBlock("barkhide",
            () -> new BarkHideBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BRANCH_OAK = registerBlock("branch_oak",
            () -> new OakBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_STONE = registerBlock("rockledge_stone",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_STONE = registerBlock("rockledge_small_stone",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> GROUNDLOG_OAK = registerBlock("groundlog_oak",
            () -> new GroundLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    /**BLOCKS ABOVE**/
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
