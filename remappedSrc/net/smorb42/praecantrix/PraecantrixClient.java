package net.smorb42.praecantrix;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.World;
import net.smorb42.praecantrix.block.ModBlocks;

public class PraecantrixClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_CHAMOMILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HIDDEN_WILD_CHAMOMILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAMOMILE_CROP, RenderLayer.getCutout());

        //Fake grass
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
        return world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getColor(0.5, 1.0);
        }, ModBlocks.HIDDEN_WILD_CHAMOMILE);
    }
}
