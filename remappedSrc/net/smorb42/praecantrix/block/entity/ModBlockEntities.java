package net.smorb42.praecantrix.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.smorb42.praecantrix.Praecantrix;
import net.smorb42.praecantrix.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<VatBlockEntity> VAT;
    public static BlockEntityType<IlluminatedAirBlockEntity> ILLUMINATED_AIR;
    public static BlockEntityType<WildChamomileBlockEntity> WILD_CHAMOMILE;
    public static void registerAllBlockEntities() {

        VAT = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Praecantrix.MOD_ID, "vat"),
                FabricBlockEntityTypeBuilder.create(VatBlockEntity::new,
                        ModBlocks.VAT).build(null));

        ILLUMINATED_AIR = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Praecantrix.MOD_ID, "illuminated_air"),
                FabricBlockEntityTypeBuilder.create(IlluminatedAirBlockEntity::new,
                        ModBlocks.ILLUMINATED_AIR).build(null));

        WILD_CHAMOMILE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Praecantrix.MOD_ID, "wild_chamomile"),
                FabricBlockEntityTypeBuilder.create(WildChamomileBlockEntity::new,
                        ModBlocks.WILD_CHAMOMILE).build(null));
    }
}
