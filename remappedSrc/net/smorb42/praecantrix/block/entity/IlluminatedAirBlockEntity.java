package net.smorb42.praecantrix.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IlluminatedAirBlockEntity extends BlockEntity {

    private int timer = 3;
    public IlluminatedAirBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ILLUMINATED_AIR, pos, state);
    }

    public static void settimer(IlluminatedAirBlockEntity be){
        be.timer = 3;
    }
    public static void tick(World world1, BlockPos pos, BlockState state1, IlluminatedAirBlockEntity be) {
        be.timer = be.timer - 1;
        if (be.timer == 0){
            world1.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }

}
