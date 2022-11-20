package net.smorb42.praecantrix.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.smorb42.praecantrix.block.entity.IlluminatedAirBlockEntity;
import net.smorb42.praecantrix.block.entity.ModBlockEntities;
import net.smorb42.praecantrix.block.entity.WildChamomileBlockEntity;


public class WildChamomile extends BlockWithEntity {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public WildChamomile(Settings settings) {
        super(settings);

    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WildChamomileBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }


    @Override
    @SuppressWarnings("@Deprecated")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.WILD_CHAMOMILE, (world1, pos, state1, be) -> WildChamomileBlockEntity.tick(world1, pos, state1, be));
    }

}
