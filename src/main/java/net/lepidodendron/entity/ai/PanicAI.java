package net.lepidodendron.entity.ai;

import net.lepidodendron.entity.base.EntityPrehistoricFloraAgeableBase;
import net.lepidodendron.entity.util.IScreamer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PanicAI extends EntityAIBase
{
    protected final EntityCreature creature;
    protected double speed;
    protected double randPosX;
    protected double randPosY;
    protected double randPosZ;

    public PanicAI(EntityCreature creature, double speedIn)
    {
        this.creature = creature;
        this.speed = speedIn;
        this.setMutexBits(1);
    }

    public boolean shouldExecute()
    {
        if (this.creature.getRevengeTarget() == null && !this.creature.isBurning())
        {
            if (this.creature instanceof EntityPrehistoricFloraAgeableBase) {
                EntityPrehistoricFloraAgeableBase entity = (EntityPrehistoricFloraAgeableBase) this.creature;
                entity.setIsFast(false);

                if (this.creature instanceof IScreamer) {
                    ((IScreamer)this.creature).setScreaming(false);
                }
            }
            return false;
        }
        else
        {
            if (this.creature.isBurning())
            {
                BlockPos blockpos = this.getRandPos(this.creature.world, this.creature, 5, 4);

                if (blockpos != null)
                {
                    this.randPosX = (double)blockpos.getX();
                    this.randPosY = (double)blockpos.getY();
                    this.randPosZ = (double)blockpos.getZ();
                    if (this.creature instanceof IScreamer) {
                        ((IScreamer)this.creature).setScreaming(true);
                    }
                    return true;
                }
            }

            return this.findRandomPosition();
        }
    }

    protected boolean findRandomPosition()
    {
        Vec3d vec3d = RandomPositionGenerator.findRandomTarget(this.creature, 5, 4);

        if (vec3d == null)
        {
            return false;
        }
        else
        {
            this.randPosX = vec3d.x;
            this.randPosY = vec3d.y;
            this.randPosZ = vec3d.z;
            if (this.creature instanceof IScreamer) {
                ((IScreamer)this.creature).setScreaming(true);
            }
            return true;
        }
    }

    public void startExecuting()
    {
        if (this.creature instanceof EntityPrehistoricFloraAgeableBase) {
            EntityPrehistoricFloraAgeableBase entity = (EntityPrehistoricFloraAgeableBase) this.creature;
            entity.setIsFast(true);
        }
        this.creature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }

    public boolean shouldContinueExecuting()
    {
        return !this.creature.getNavigator().noPath();
    }

    @Nullable
    private BlockPos getRandPos(World worldIn, Entity entityIn, int horizontalRange, int verticalRange)
    {
        BlockPos blockpos = new BlockPos(entityIn);
        int i = blockpos.getX();
        int j = blockpos.getY();
        int k = blockpos.getZ();
        float f = (float)(horizontalRange * horizontalRange * verticalRange * 2);
        BlockPos blockpos1 = null;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int l = i - horizontalRange; l <= i + horizontalRange; ++l)
        {
            for (int i1 = j - verticalRange; i1 <= j + verticalRange; ++i1)
            {
                for (int j1 = k - horizontalRange; j1 <= k + horizontalRange; ++j1)
                {
                    blockpos$mutableblockpos.setPos(l, i1, j1);
                    IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos);

                    if (iblockstate.getMaterial() == Material.WATER)
                    {
                        float f1 = (float)((l - i) * (l - i) + (i1 - j) * (i1 - j) + (j1 - k) * (j1 - k));

                        if (f1 < f)
                        {
                            f = f1;
                            blockpos1 = new BlockPos(blockpos$mutableblockpos);
                        }
                    }
                }
            }
        }

        return blockpos1;
    }
}
