package net.smorb42.praecantrix.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.smorb42.praecantrix.Praecantrix;
import net.smorb42.praecantrix.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup PREACANTRIX = FabricItemGroupBuilder.build(
            new Identifier(Praecantrix.MOD_ID, "praecantrix"), () -> new ItemStack(ModItems.HALOWED_LAMP));
}
