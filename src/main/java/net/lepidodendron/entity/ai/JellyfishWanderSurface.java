package net.lepidodendron.entity.ai;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.lepidodendron.entity.base.EntityPrehistoricFloraJellyfishBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

//public class FishWander extends EntityAIBase {
public class JellyfishWanderSurface extends AnimationAINoAnimation<EntityPrehistoricFloraJellyfishBase> {

    protected Animation animation;
    protected EntityPrehistoricFloraJellyfishBase PrehistoricFloraJellyfishBase;

    public JellyfishWanderSurface(EntityPrehistoricFloraJellyfishBase PrehistoricFloraJellyfishBase, Animation animation)
    {
        super(PrehistoricFloraJellyfishBase);
        setMutexBits(4);
        this.PrehistoricFloraJellyfishBase = PrehistoricFloraJellyfishBase;
        this.animation = animation;
    }

    @Override
    public Animation getAnimation()
    {
        return animation;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        super.updateTask();

    }

    @Override
    public boolean shouldExecute() {
        if (!this.PrehistoricFloraJellyfishBase.isInWater()) {
            return false;
        }
        if (this.PrehistoricFloraJellyfishBase.getRNG().nextFloat() < 0.5F) {
            Path path = this.PrehistoricFloraJellyfishBase.getNavigator().getPath();
            if (
                    ((!this.PrehistoricFloraJellyfishBase.getNavigator().noPath())
                            && (!isDirectPathBetweenPoints(this.PrehistoricFloraJellyfishBase, this.PrehistoricFloraJellyfishBase.getPositionVector(), new Vec3d(path.getFinalPathPoint().x, path.getFinalPathPoint().y, path.getFinalPathPoint().z))))
                            ||
                            (path != null && path.getFinalPathPoint() != null
                                    && this.PrehistoricFloraJellyfishBase.getDistanceSq(path.getFinalPathPoint().x, path.getFinalPathPoint().y, path.getFinalPathPoint().z) <= Math.pow(this.PrehistoricFloraJellyfishBase.width,2))
            )
            {
                this.PrehistoricFloraJellyfishBase.getNavigator().clearPath();
            }
            if (this.PrehistoricFloraJellyfishBase.getNavigator().noPath()) {
                BlockPos vec3 = this.findWaterSurfaceTarget();
                if (vec3 != null) {
                    double Xoffset = this.entity.posX - this.entity.getPosition().getX();
                    double Zoffset = this.entity.posZ - this.entity.getPosition().getZ();

                    this.PrehistoricFloraJellyfishBase.getNavigator().tryMoveToXYZ(vec3.getX() + 0.5D + Xoffset, vec3.getY() + 0.5D, vec3.getZ() + 0.5D + Zoffset, 1.0);

                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDirectPathBetweenPoints(Entity entity, Vec3d vec1, Vec3d vec2) {
        RayTraceResult movingobjectposition = entity.world.rayTraceBlocks(vec1, new Vec3d(vec2.x, vec2.y + (double) entity.height * 0.5D, vec2.z), false, true, false);
        return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return false;
    }

    public BlockPos findWaterSurfaceTarget() {
        Random rand = this.PrehistoricFloraJellyfishBase.getRNG();
        if (this.PrehistoricFloraJellyfishBase.getAttackTarget() == null) {
            for (int i = 0; i < 12; i++) {
                BlockPos randPos = this.PrehistoricFloraJellyfishBase.getPosition().add(rand.nextInt(17) - 8, rand.nextInt(3) - 1, rand.nextInt(17) - 8);
                boolean surfaceCheck = false;
                if (this.PrehistoricFloraJellyfishBase.world.isAirBlock(randPos.up())) {
                    surfaceCheck = true;
                }
                if (!surfaceCheck) {
                    IBlockState state = this.PrehistoricFloraJellyfishBase.world.getBlockState(randPos.up());
                    if (state.getMaterial() != Material.WATER) {
                        surfaceCheck = true;
                    }
                }
                if (surfaceCheck) {
                    return randPos;
                }
            }
        } else {
            BlockPos blockpos1;
            blockpos1 = new BlockPos(this.PrehistoricFloraJellyfishBase.getAttackTarget());
            if (this.PrehistoricFloraJellyfishBase.world.getBlockState(blockpos1).getMaterial() == Material.WATER) {
                return blockpos1;
            }
        }
        return null;
    }
}