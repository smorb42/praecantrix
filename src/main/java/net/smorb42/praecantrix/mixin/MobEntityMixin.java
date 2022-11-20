package net.smorb42.praecantrix.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;
import net.smorb42.praecantrix.Praecantrix;
import net.smorb42.praecantrix.block.ModBlocks;
import net.smorb42.praecantrix.entity.goal.MoveToTargetBlockGoal;
import net.smorb42.praecantrix.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PathAwareEntity.class)
public abstract class MobEntityMixin extends MobEntity{


    protected MobEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    protected void PathAwareEntity(EntityType<? extends MobEntity> entityType, World world,CallbackInfo info) {
        if (world != null && !world.isClient) {
            this.targetSelector.add(0, new MoveToTargetBlockGoal(ModBlocks.SCARECROW, (PathAwareEntity) (Object) this, 1.0, 4));
        }
    }
}

