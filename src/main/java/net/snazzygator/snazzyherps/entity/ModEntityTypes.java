package net.snazzygator.snazzyherps.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snazzygator.snazzyherps.SnazzyHerps;
import net.snazzygator.snazzyherps.entity.custom.*;

public class ModEntityTypes extends Mob{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, SnazzyHerps.MOD_ID);

    public static final RegistryObject<EntityType<BrownAnoleEntity>> BROWNANOLE =
            ENTITY_TYPES.register("brownanole",
                    () -> EntityType.Builder.of(BrownAnoleEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "brownanole").toString()));

    public static final RegistryObject<EntityType<HouseGeckoEntity>> HOUSEGECKO =
            ENTITY_TYPES.register("housegecko",
                    () -> EntityType.Builder.of(HouseGeckoEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "smallgecko").toString()));

    public static final RegistryObject<EntityType<DayGeckoSmallEntity>> DAYGECKOSMALL =
            ENTITY_TYPES.register("daygeckosmall",
                    () -> EntityType.Builder.of(DayGeckoSmallEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "smallgecko").toString()));

    public static final RegistryObject<EntityType<GoldenGeckoEntity>> GOLDENGECKO =
            ENTITY_TYPES.register("goldengecko",
                    () -> EntityType.Builder.of(GoldenGeckoEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "smallgecko").toString()));

    public static final RegistryObject<EntityType<BaseSkinkEntity>> SKINK =
            ENTITY_TYPES.register("skink",
                    () -> EntityType.Builder.of(BaseSkinkEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "baseskink").toString()));

    public static final RegistryObject<EntityType<LeopardGeckoEntity>> LEOPARDGECKO =
            ENTITY_TYPES.register("leopardgecko",
                    () -> EntityType.Builder.of(LeopardGeckoEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "leopardgecko").toString()));

    public static final RegistryObject<EntityType<TestLeoEntity>> TESTLEO =
            ENTITY_TYPES.register("testleo",
                    () -> EntityType.Builder.of(TestLeoEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "leopardgecko").toString()));

    public static final RegistryObject<EntityType<BeardedDragonEntity>> BEARDEDDRAGON =
            ENTITY_TYPES.register("beardeddragon",
                    () -> EntityType.Builder.of(BeardedDragonEntity::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(SnazzyHerps.MOD_ID, "beardeddragon").toString()));

    protected ModEntityTypes(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
