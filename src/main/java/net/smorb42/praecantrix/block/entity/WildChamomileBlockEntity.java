package net.smorb42.praecantrix.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.smorb42.praecantrix.block.ModBlocks;

public class WildChamomileBlockEntity extends BlockEntity {

    private int timer = 4;

    public WildChamomileBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WILD_CHAMOMILE, pos, state);
    }

    public static void setTimer(WildChamomileBlockEntity be) {
        be.timer = 4;
    }

    public static void tick(World world1, BlockPos pos, BlockState state1, WildChamomileBlockEntity be) {
        be.timer = be.timer - 1;
        if (be.timer == 0) {
            world1.setBlockState(pos, ModBlocks.HIDDEN_WILD_CHAMOMILE.getDefaultState());
        }
        BlockPos blockPos = pos.up();
        if (world1.getBlockState(blockPos).isAir() && !world1.getBlockState(blockPos).isOpaqueFullCube(world1, blockPos)) {
            Random random = Random.create();
            if (random.nextInt(25) == 0) {
                double d = (double) pos.getX() + random.nextDouble();
                double e = (double) pos.getY() + 0.9;
                double f = (double) pos.getZ() + random.nextDouble();
                world1.addParticle(ParticleTypes.ELECTRIC_SPARK, d, e, f, 0.0, 0.1, 0.0);
                if (random.nextInt(4) == 0) {
                world1.playSound(d, e, f, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
                }
            }
        }
    }
}
