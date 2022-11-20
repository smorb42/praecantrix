package net.smorb42.praecantrix.block.custom;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.smorb42.praecantrix.block.entity.IlluminatedAirBlockEntity;
import net.smorb42.praecantrix.block.entity.ModBlockEntities;
import net.smorb42.praecantrix.block.entity.VatBlockEntity;


public class IlluminatedAir extends BlockWithEntity {


    public IlluminatedAir(Settings settings) {
        super(settings);
    }


    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new IlluminatedAirBlockEntity(pos, state);
    }

    /*@Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }
    */
    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    @SuppressWarnings("@Deprecated")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }


    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.ILLUMINATED_AIR, (world1, pos, state1, be) -> IlluminatedAirBlockEntity.tick(world1, pos, state1, be));
    }
}
