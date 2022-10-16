package net.snazzygator.snazzyherps.blocks.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.blocks.ModBlocks;
import net.snazzygator.snazzyherps.blocks.entity.custom.CritterKeeperBlockEntity;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SnazzyHerps.MOD_ID);

    public static final RegistryObject<BlockEntityType<CritterKeeperBlockEntity>> CRITTERKEEPER_ENTITY =
            BLOCK_ENTITIES.register("critterkeeper_entity", () ->
                    BlockEntityType.Builder.of(CritterKeeperBlockEntity::new,
                            ModBlocks.CRITTERKEEPER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}