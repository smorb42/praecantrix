package net.smorb42.praecantrix.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.smorb42.praecantrix.block.entity.ModBlockEntities;
import net.smorb42.praecantrix.block.entity.WildChamomileBlockEntity;


public class HiddenWildChamomile extends GrassBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public HiddenWildChamomile(Settings settings) {
        super(settings);


    }

    @Override
    @SuppressWarnings("@Deprecated")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
