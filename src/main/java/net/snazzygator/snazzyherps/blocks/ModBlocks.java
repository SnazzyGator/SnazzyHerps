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
    public static final RegistryObject<Block> BARKHIDE_OAK = registerBlock("barkhide_oak",
            () -> new BarkHideBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BARKHIDE_BIRCH = registerBlock("barkhide_birch",
            () -> new BarkHideBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BARKHIDE_SPRUCE = registerBlock("barkhide_spruce",
            () -> new BarkHideBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BARKHIDE_JUNGLE = registerBlock("barkhide_jungle",
            () -> new BarkHideBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BARKHIDE_ACACIA = registerBlock("barkhide_acacia",
            () -> new BarkHideBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BARKHIDE_DARKOAK = registerBlock("barkhide_darkoak",
            () -> new BarkHideBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> BRANCH_OAK = registerBlock("branch_oak",
            () -> new OakBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BRANCH_BIRCH = registerBlock("branch_birch",
            () -> new OakBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BRANCH_SPRUCE = registerBlock("branch_spruce",
            () -> new OakBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BRANCH_JUNGLE = registerBlock("branch_jungle",
            () -> new OakBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BRANCH_ACACIA = registerBlock("branch_acacia",
            () -> new OakBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> BRANCH_DARKOAK = registerBlock("branch_darkoak",
            () -> new OakBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> ROCKLEDGE_STONE = registerBlock("rockledge_stone",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_ANDESITE = registerBlock("rockledge_andesite",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_GRANITE = registerBlock("rockledge_granite",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_DIORITE = registerBlock("rockledge_diorite",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SANDSTONE = registerBlock("rockledge_sandstone",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_REDSANDSTONE = registerBlock("rockledge_redsandstone",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_COBBLESTONE = registerBlock("rockledge_cobblestone",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_MOSSYCOBBLESTONE = registerBlock("rockledge_mossycobblestone",
            () -> new RockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> ROCKLEDGE_SMALL_STONE = registerBlock("rockledge_small_stone",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_ANDESITE = registerBlock("rockledge_small_andesite",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_GRANITE = registerBlock("rockledge_small_granite",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_DIORITE = registerBlock("rockledge_small_diorite",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_SANDSTONE = registerBlock("rockledge_small_sandstone",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_REDSANDSTONE = registerBlock("rockledge_small_redsandstone",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_COBBLESTONE = registerBlock("rockledge_small_cobblestone",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKLEDGE_SMALL_MOSSYCOBBLESTONE = registerBlock("rockledge_small_mossycobblestone",
            () -> new SmallRockledgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> GROUNDLOG_OAK = registerBlock("groundlog_oak",
            () -> new GroundLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> GROUNDLOG_BIRCH = registerBlock("groundlog_birch",
            () -> new GroundLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> GROUNDLOG_SPRUCE = registerBlock("groundlog_spruce",
            () -> new GroundLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> GROUNDLOG_JUNGLE = registerBlock("groundlog_jungle",
            () -> new GroundLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> GROUNDLOG_ACACIA = registerBlock("groundlog_acacia",
            () -> new GroundLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> GROUNDLOG_DARKOAK = registerBlock("groundlog_darkoak",
            () -> new GroundLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> WALLBRANCH_OAK = registerBlock("wallbranch_oak",
            () -> new WallBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> WALLBRANCH_BIRCH = registerBlock("wallbranch_birch",
            () -> new WallBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> WALLBRANCH_SPRUCE = registerBlock("wallbranch_spruce",
            () -> new WallBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> WALLBRANCH_JUNGLE = registerBlock("wallbranch_jungle",
            () -> new WallBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> WALLBRANCH_ACACIA = registerBlock("wallbranch_acacia",
            () -> new WallBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> WALLBRANCH_DARKOAK = registerBlock("wallbranch_darkoak",
            () -> new WallBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> ROCKHIDE_STONE = registerBlock("rockhide_stone",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKHIDE_ANDESITE = registerBlock("rockhide_andesite",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKHIDE_GRANITE = registerBlock("rockhide_granite",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKHIDE_DIORITE = registerBlock("rockhide_diorite",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKHIDE_SANDSTONE = registerBlock("rockhide_sandstone",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKHIDE_REDSANDSTONE = registerBlock("rockhide_redsandstone",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKHIDE_COBBLESTONE = registerBlock("rockhide_cobblestone",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> ROCKHIDE_MOSSYCOBBLESTONE = registerBlock("rockhide_mossycobblestone",
            () -> new RockHideBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);

    public static final RegistryObject<Block> HEATROCK_STONE = registerBlock("heatrock_stone",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> HEATROCK_ANDESITE = registerBlock("heatrock_andesite",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> HEATROCK_GRANITE = registerBlock("heatrock_granite",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> HEATROCK_DIORITE = registerBlock("heatrock_diorite",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> HEATROCK_SANDSTONE = registerBlock("heatrock_sandstone",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> HEATROCK_REDSANDSTONE = registerBlock("heatrock_redsandstone",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> HEATROCK_COBBLESTONE = registerBlock("heatrock_cobblestone",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
            ModCreativeModeTab.HERPS_TAB);
    public static final RegistryObject<Block> HEATROCK_MOSSYCOBBLESTONE = registerBlock("heatrock_mossycobblestone",
            () -> new HeatRockBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()),
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
