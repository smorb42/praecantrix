package net.smorb42.praecantrix.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smorb42.praecantrix.Praecantrix;
import net.smorb42.praecantrix.block.ModBlocks;
import net.smorb42.praecantrix.block.entity.IlluminatedAirBlockEntity;
import net.smorb42.praecantrix.block.entity.WildChamomileBlockEntity;

public class HalowedLamp extends Item {
    public HalowedLamp(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity) {
            if (selected) {
                PlayerEntity playerEntity = (PlayerEntity) entity;
                BlockPos blockPos = playerEntity.getBlockPos().up(1);
                //at eyes
                makeLight(world, blockPos);

                if( world.getTimeOfDay() > 13000 && world.getTimeOfDay() < 23000){
                    int radius = 5;

                    Iterable<BlockPos> Result = BlockPos.iterateOutwards(blockPos, radius, radius, radius);

                    for (BlockPos pos : Result) {
                        if (world.getBlockState(pos) == ModBlocks.WILD_CHAMOMILE.getDefaultState()) {
                            WildChamomileBlockEntity be = (WildChamomileBlockEntity) world.getBlockEntity(pos);
                            WildChamomileBlockEntity.setTimer(be);
                        }
                        if (world.getBlockState(pos) == ModBlocks.HIDDEN_WILD_CHAMOMILE.getDefaultState()) {
                            world.setBlockState(pos, ModBlocks.WILD_CHAMOMILE.getDefaultState());
                        }

                    }
                }
            }
        }
    }


    public void makeLight(World world, BlockPos blockPos) {
        //at eyes
        if (world.getBlockState(blockPos).isAir()) {
            world.setBlockState(blockPos, ModBlocks.ILLUMINATED_AIR.getDefaultState());
        } else if (world.getBlockState(blockPos) == ModBlocks.ILLUMINATED_AIR.getDefaultState()) {
            IlluminatedAirBlockEntity be = (IlluminatedAirBlockEntity) world.getBlockEntity(blockPos);
            IlluminatedAirBlockEntity.setTimer(be);
        } else {
            //above eyes
            blockPos = blockPos.up(1);
            if (world.getBlockState(blockPos).isAir()) {
                world.setBlockState(blockPos, ModBlocks.ILLUMINATED_AIR.getDefaultState());
            } else if (world.getBlockState(blockPos) == ModBlocks.ILLUMINATED_AIR.getDefaultState()) {
                IlluminatedAirBlockEntity be = (IlluminatedAirBlockEntity) world.getBlockEntity(blockPos);
                IlluminatedAirBlockEntity.setTimer(be);
            } else {
                //at feet
                blockPos = blockPos.down(2);
                if (world.getBlockState(blockPos).isAir()) {
                    world.setBlockState(blockPos, ModBlocks.ILLUMINATED_AIR.getDefaultState());
                } else if (world.getBlockState(blockPos) == ModBlocks.ILLUMINATED_AIR.getDefaultState()) {
                    IlluminatedAirBlockEntity be = (IlluminatedAirBlockEntity) world.getBlockEntity(blockPos);
                    IlluminatedAirBlockEntity.setTimer(be);
                }

            }
        }
    }
}

