package net.smorb42.praecantrix.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.smorb42.praecantrix.Praecantrix;
import net.smorb42.praecantrix.block.custom.ChamomileCropBlock;
import net.smorb42.praecantrix.block.custom.IlluminatedAir;
import net.smorb42.praecantrix.block.custom.Scarecrow;
import net.smorb42.praecantrix.block.custom.WildChamomile;
import net.smorb42.praecantrix.item.ModItemGroup;

public class ModBlocks {

    //--------------------------------------[blocks]------------------------------------------
    public static final Block CHAMOMILE_CROP = registerBlockWithoutItem("chamomile_crop",
            new ChamomileCropBlock(FabricBlockSettings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));
    public static final Block WILD_CHAMOMILE = registerBlock("wild_chamomile",
            new WildChamomile(FabricBlockSettings.of(Material.PLANT).breakInstantly().nonOpaque().noCollision().sounds(BlockSoundGroup.GRASS)), ModItemGroup.PREACANTRIX);

    public static final Block HIDDEN_WILD_CHAMOMILE = registerBlockWithoutItem("hidden_wild_chamomile",
            new FernBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XYZ)));

    public static final Block ILLUMINATED_AIR = registerBlockWithoutItem("illuminated_air",
            new IlluminatedAir(FabricBlockSettings.of(Material.AIR).noCollision().nonOpaque().luminance(15).dropsNothing()));

    public static final Block SCARECROW = registerBlock("scarecrow",
            new Scarecrow(FabricBlockSettings.of(Material.PLANT).nonOpaque().sounds(BlockSoundGroup.GRASS)), ModItemGroup.PREACANTRIX);


    //--------------------------------------[register]------------------------------------------

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Praecantrix.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Praecantrix.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Praecantrix.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        Praecantrix.LOGGER.debug("Registering ModBlocks for " +Praecantrix.MOD_ID);
    }
}
