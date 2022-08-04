package net.lepidodendron.entity.ai;

import net.lepidodendron.entity.EntityPrehistoricFloraPlateosaurus;
import net.lepidodendron.entity.base.EntityPrehistoricFloraAgeableBase;
import net.lepidodendron.entity.base.EntityPrehistoricFloraLandBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Comparator;
import java.util.List;

public class EatAlgaeItemsAI extends EntityAIBase {
    private final EntityPrehistoricFloraAgeableBase entity;
    private final ItemsSorter targetSorter;
    private EntityItem targetItem;
    private double speed;

    public EatAlgaeItemsAI(EntityPrehistoricFloraAgeableBase entity, double speedIn) {
        super();
        this.entity = entity;
        this.speed = speedIn;
        this.targetSorter = new ItemsSorter(entity);
        this.setMutexBits(1);
    }

    @Override
    public void resetTask()
    {
        this.entity.setEatTarget(null);
        this.targetItem = null;
    }

    @Override
    public boolean shouldExecute() {
        if (this.entity.getHealth() <= 0) {
            return false;
        }

        if (this.entity instanceof EntityPrehistoricFloraLandBase) {
            EntityPrehistoricFloraLandBase LandBase = (EntityPrehistoricFloraLandBase) this.entity;
            if (LandBase.getAnimation() == LandBase.DRINK_ANIMATION) {
                return false;
            }
        }

        if (this.entity instanceof EntityPrehistoricFloraPlateosaurus) {
            EntityPrehistoricFloraPlateosaurus PlateosaurusBase = (EntityPrehistoricFloraPlateosaurus) this.entity;
            if (PlateosaurusBase.getAnimation() == PlateosaurusBase.STAND_ANIMATION) {
                return false;
            }
        }

        this.targetItem = this.getNearestItem(16);
        return this.targetItem != null;
    }

    @Override
    public boolean shouldContinueExecuting() {
        if (this.targetItem == null || !this.targetItem.isEntityAlive()) {
            return false;
        }
        return true;
    }

    @Override
    public void updateTask() {
        double distance = Math.sqrt(Math.pow(this.entity.posX - this.targetItem.posX, 2.0D) + Math.pow(this.entity.posY - this.targetItem.posY, 2.0D)  + Math.pow(this.entity.posZ - this.targetItem.posZ, 2.0D));
        this.entity.setEatTarget(this.targetItem);
        this.entity.getNavigator().tryMoveToXYZ(this.targetItem.posX, this.targetItem.posY, this.targetItem.posZ, this.speed);
        //if (distance < Math.max(this.entity.getEntityBoundingBox().getAverageEdgeLength(), 1D)) {
        if (distance < this.entity.getEntityBoundingBox().getAverageEdgeLength()) {
            if (this.targetItem != null) {
                this.entity.setEatTarget(null);
                this.entity.eatItem(this.targetItem.getItem());
                this.targetItem.getItem().shrink(1);
            }
        }
        if (this.entity.getNavigator().noPath()) {
            resetTask();
        }
    }

    private EntityItem getNearestItem(int range) {
        List<EntityItem> Items = this.entity.world.getEntitiesWithinAABB(EntityItem.class, this.entity.getEntityBoundingBox().grow(range, range, range));
        Items.sort(this.targetSorter);
        for (EntityItem currentItem : Items) {
            if (!currentItem.getItem().isEmpty()) {
                if (OreDictionary.containsMatch(false, OreDictionary.getOres("itemAlgae"), currentItem.getItem())
                    && !cantReachItem(currentItem)) {
                    return currentItem;
                }
            }
        }
        return null;
    }

    public boolean cantReachItem(Entity item) {
        if (this.entity instanceof EntityPrehistoricFloraLandBase) {
            EntityPrehistoricFloraLandBase ee = (EntityPrehistoricFloraLandBase) this.entity;
            if (item.isInWater()) {
                return true;
            }
        }
        RayTraceResult rayTrace = this.entity.world.rayTraceBlocks(this.entity.getPositionVector().add(0, this.entity.height / 2, 0), item.getPositionVector().add(0, item.height / 2, 0), false);
        if (rayTrace != null && rayTrace.hitVec != null) {
            BlockPos sidePos = rayTrace.getBlockPos();
            BlockPos pos = new BlockPos(rayTrace.hitVec);
            if (!this.entity.world.isAirBlock(pos) || !this.entity.world.isAirBlock(sidePos)) {
                return true;
            } else {
                return rayTrace.typeOfHit != RayTraceResult.Type.MISS;
            }
        }
        return false;
    }

    public class ItemsSorter implements Comparator<Entity> {
        private final Entity e;

        public ItemsSorter(Entity entity) {
            this.e = entity;
        }

        @Override
        public int compare(Entity entity1, Entity entity2) {
            double distance1 = this.e.getDistanceSq(entity1);
            double distance2 = this.e.getDistanceSq(entity2);
            return Double.compare(distance1, distance2);
        }
    }
}