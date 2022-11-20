package net.smorb42.praecantrix.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.smorb42.praecantrix.Praecantrix;
import net.smorb42.praecantrix.block.ModBlocks;
import net.smorb42.praecantrix.item.custom.HalowedLamp;

public class ModItems {
    public static final Item HALOWED_LAMP = registerItem("halowed_lamp",
            new HalowedLamp(new FabricItemSettings().group(ModItemGroup.PREACANTRIX)));

//    public static final Item chamomile_seeds = registerItem("chamomile_seeds",
//            new Item(new FabricItemSettings().group(ModItemGroup.PREACANTRIX)));

    public static final Item CHAMOMILE = registerItem("chamomile",
            new AliasedBlockItem(ModBlocks.CHAMOMILE_CROP,new FabricItemSettings().group(ModItemGroup.PREACANTRIX)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Praecantrix.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Praecantrix.LOGGER.debug("Registering Mod Items for " + Praecantrix.MOD_ID);
    }
}
