package net.smorb42.praecantrix.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.smorb42.praecantrix.Praecantrix;
import net.smorb42.praecantrix.block.ModBlocks;
import net.smorb42.praecantrix.item.custom.ChamomileTea;
import net.smorb42.praecantrix.item.custom.HalowedLamp;

public class ModItems {
    //--------------------------------------[items]------------------------------------------
    public static final Item HALOWED_LAMP = registerItem("halowed_lamp",
            new HalowedLamp(new FabricItemSettings().group(ModItemGroup.PREACANTRIX)));

    public static final Item CHAMOMILE = registerItem("chamomile",
            new Item(new FabricItemSettings().group(ModItemGroup.PREACANTRIX)));

    public static final Item CHAMOMILE_SEEDS = registerItem("chamomile_seeds",
            new AliasedBlockItem(ModBlocks.CHAMOMILE_CROP,new FabricItemSettings().group(ModItemGroup.PREACANTRIX)));

    public static final Item CHAMOMILE_TEA = registerItem("chamomile_tea",
            new ChamomileTea(new FabricItemSettings().group(ModItemGroup.PREACANTRIX).maxCount(16)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(4f).snack().alwaysEdible()
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,40),1f).build())));

    //--------------------------------------[register]------------------------------------------
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Praecantrix.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Praecantrix.LOGGER.debug("Registering Mod Items for " + Praecantrix.MOD_ID);
    }
}
