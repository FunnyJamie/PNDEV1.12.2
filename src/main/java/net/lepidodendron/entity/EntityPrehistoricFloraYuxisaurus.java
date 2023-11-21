
package net.lepidodendron.entity;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.ai.*;
import net.lepidodendron.entity.base.EntityPrehistoricFloraAgeableBase;
import net.lepidodendron.entity.base.EntityPrehistoricFloraLandBase;
import net.lepidodendron.entity.render.entity.RenderYuxisaurus;
import net.lepidodendron.entity.render.tile.RenderDisplays;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;

public class EntityPrehistoricFloraYuxisaurus extends EntityPrehistoricFloraLandBase {

	public BlockPos currentTarget;
	@SideOnly(Side.CLIENT)
	public ChainBuffer tailBuffer;

	private int inPFLove;
	public Animation HIDE_ANIMATION;

	public final EntityDamageSource SPIKY = new EntityDamageSource("spiky", this);
	
	public EntityPrehistoricFloraYuxisaurus(World world) {
		super(world);
		setSize(1.5F, 1F);
		minWidth = 0.3F;
		maxWidth = 1.5F;
		maxHeight = 1F;
		maxHealthAgeable = 25.0D;
		HIDE_ANIMATION = Animation.create(this.hideAnimationLength());
		if (FMLCommonHandler.instance().getSide().isClient()) {
			tailBuffer = new ChainBuffer();
		}
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (world.isRemote && !this.isAIDisabled()) {
			tailBuffer.calculateChainSwingBuffer(120, 10, 5F, this);
		}
	}
	@Override
	public int getEatLength() {
		return 20;
	}

	@Override
	public int getRoarLength() {
		return 30;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[]{DRINK_ANIMATION, ATTACK_ANIMATION, ROAR_ANIMATION, LAY_ANIMATION, EAT_ANIMATION, MAKE_NEST_ANIMATION, HIDE_ANIMATION};
	}

	@Override
	protected void collideWithEntity(Entity entityIn) {
		super.collideWithEntity(entityIn);
		if (entityIn instanceof EntityPlayer) {
			entityIn.attackEntityFrom(SPIKY, (float) 2);
		}
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (player.getHeldItem(hand).isEmpty()) {
			player.attackEntityFrom(SPIKY, (float) 2);
		}
		return super.processInteract(player, hand);
	}

	@Override
	public boolean attackEntityFrom(DamageSource ds, float i) {
		Entity entityIn = ds.getImmediateSource();
		boolean result;
		if (ds.getTrueSource() instanceof EntityLivingBase && this.getAnimation() == HIDE_ANIMATION) {
			result = super.attackEntityFrom(ds, i/10F);
		}
		else {
			result = super.attackEntityFrom(ds, i);
		}
		if (result && ds.getTrueSource() instanceof EntityLivingBase && this.getAnimation() != HIDE_ANIMATION) {
			this.setAnimation(HIDE_ANIMATION);
		}

		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			if (player.getHeldItem(getActiveHand()).isEmpty()) {
				entityIn.attackEntityFrom(SPIKY, (float) 2);
			}
		}
		if (ds.getTrueSource() instanceof EntityLivingBase && !(entityIn instanceof EntityPlayer)) {
			entityIn.attackEntityFrom(SPIKY, (float) 2);
		}

		return result;
	}

	public int hideAnimationLength() {
		return 160;
	}

	@Override
	public int getEggType(@Nullable String variantIn) {
		return 0; //small
	}

	public static String getPeriod() {return "Jurassic";}

	//public static String getHabitat() {return "Terrestrial Diadectomorph";}

//	@Override
//	public boolean hasNest() {
//		return true;
//	}

	@Override
	public String getTexture() {
		return this.getTexture();
	}

	@Override
	public boolean dropsEggs() {
		return false;
	}

	@Override
	public boolean laysEggs() {
		return true;
	}

	@Override
	public boolean hasNest() {
		return true;
	}

	public float getAISpeedLand() {
		float speedBase = 0.310F;
		if (this.getTicks() < 0) {
			return 0.0F; //Is laying eggs
		}
		if (this.getAnimation() == DRINK_ANIMATION || this.getAnimation() == MAKE_NEST_ANIMATION
			|| this.getAnimation() == HIDE_ANIMATION || this.getAnimation() == GRAZE_ANIMATION) {
			return 0.0F;
		}
		if (this.getIsFast()) {
			speedBase = speedBase * 2.47F;
			speedBase = speedBase / 0.85F;
			speedBase = 0.6F;
		}
		return speedBase;
	}

	@Override
	public int getTalkInterval() {
		return 100;
	}

	@Override
	public int getAdultAge() {
		return 48000;
	}

	public AxisAlignedBB getAttackBoundingBox() {
		float size = this.getRenderSizeModifier() * 0.25F;
		return this.getEntityBoundingBox().grow(2.0F + size, 2.0F + size, 2.0F + size);
	}

	@Override
	public float getEyeHeight()
	{
		return Math.max(super.getEyeHeight(),  this.height * 1.05F);
	}

	protected void initEntityAI() {
		tasks.addTask(0, new EntityMateAIAgeableBase(this, 1.0D));
		tasks.addTask(1, new EntityTemptAI(this, 1, false, false, 0));
		tasks.addTask(2, new LandEntitySwimmingAI(this, 0.75, false));
		tasks.addTask(3, new LandWanderNestAI(this));
		tasks.addTask(4, new LandWanderFollowParent(this, 1.05D));
		tasks.addTask(5, new LandWanderHerd(this, 1.00D, this.getNavigator().getPathSearchRange()*0.75F));
		tasks.addTask(6, new LandWanderAvoidWaterAI(this, 1.0D, 40));
		tasks.addTask(7, new EntityWatchClosestAI(this, EntityPlayer.class, 6.0F));
		tasks.addTask(8, new EntityWatchClosestAI(this, EntityPrehistoricFloraAgeableBase.class, 8.0F));
		tasks.addTask(9, new EntityLookIdleAI(this));
		this.targetTasks.addTask(0, new EatItemsEntityPrehistoricFloraAgeableBaseAI(this, 1));
		}

	@Override
	public String[] getFoodOreDicts() {
		return ArrayUtils.addAll(DietString.PLANTS, DietString.FRUIT);
	}

//	@Override
//	public boolean panics() {
//		return true;
//	}

	
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	public boolean drinksWater() {
		return false; //grazes, does not drink
	}

	@Override
	public int getDrinkLength() {
		return 50;  //grazes, does not drink
	}

	@Override
	public int getDrinkCooldown() {
		return 400;
	}

	public boolean isDrinking()
	{
		//Is GRAZING!
		EnumFacing facing = this.getAdjustedHorizontalFacing();
		boolean test = (this.getPFDrinking() <= 0
				&& !world.isRemote
				&& !this.getIsFast()
				&& !this.getIsMoving()
				&& this.DRINK_ANIMATION.getDuration() > 0
				&& this.getAnimation() == NO_ANIMATION
				&& !this.isReallyInWater()
				&& (this.world.getBlockState(this.getPosition().offset(facing).down()).getMaterial() == Material.GROUND
				|| this.world.getBlockState(this.getPosition().offset(facing).down()).getMaterial() == Material.GRASS
				|| this.world.getBlockState(this.getPosition().offset(facing).down()).getMaterial() == Material.PLANTS
				|| this.world.getBlockState(this.getPosition().offset(facing).down()).getMaterial() == Material.LEAVES)
				//|| this.world.getBlockState(this.getPosition().offset(facing).down()).getMaterial() == Material.SAND)
		);
		if (test) {
			//Which one is water?
			facing = null;
			if (this.world.getBlockState(this.getPosition().north().down()).getMaterial() == Material.GRASS
					|| this.world.getBlockState(this.getPosition().north().down()).getMaterial() == Material.GROUND
					|| this.world.getBlockState(this.getPosition().north().down()).getMaterial() == Material.PLANTS
					|| this.world.getBlockState(this.getPosition().north().down()).getMaterial() == Material.LEAVES) {
				facing = EnumFacing.NORTH;
			}
			else if (this.world.getBlockState(this.getPosition().south().down()).getMaterial() == Material.GRASS
					|| this.world.getBlockState(this.getPosition().south().down()).getMaterial() == Material.GROUND
					|| this.world.getBlockState(this.getPosition().south().down()).getMaterial() == Material.PLANTS
					|| this.world.getBlockState(this.getPosition().south().down()).getMaterial() == Material.LEAVES) {
				facing = EnumFacing.SOUTH;
			}
			else if (this.world.getBlockState(this.getPosition().east().down()).getMaterial() == Material.GRASS
					|| this.world.getBlockState(this.getPosition().east().down()).getMaterial() == Material.GROUND
					|| this.world.getBlockState(this.getPosition().east().down()).getMaterial() == Material.PLANTS
					|| this.world.getBlockState(this.getPosition().east().down()).getMaterial() == Material.LEAVES) {
				facing = EnumFacing.EAST;
			}
			else if (this.world.getBlockState(this.getPosition().west().down()).getMaterial() == Material.GRASS
					|| this.world.getBlockState(this.getPosition().west().down()).getMaterial() == Material.GROUND
					|| this.world.getBlockState(this.getPosition().west().down()).getMaterial() == Material.PLANTS
					|| this.world.getBlockState(this.getPosition().west().down()).getMaterial() == Material.LEAVES) {
				facing = EnumFacing.WEST;
			}
			if (facing != null) {
				this.setDrinkingFrom(this.getPosition().offset(facing));
				this.faceBlock(this.getDrinkingFrom(), 10F, 10F);
			}
		}
		return test;

	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return (SoundEvent) SoundEvent.REGISTRY
				.getObject(new ResourceLocation("lepidodendron:yuxisaurus_idle"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return (SoundEvent) SoundEvent.REGISTRY
				.getObject(new ResourceLocation("lepidodendron:yuxisaurus_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return (SoundEvent) SoundEvent.REGISTRY
				.getObject(new ResourceLocation("lepidodendron:yuxisaurus_death"));
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < (double) this.world.getSeaLevel() && this.isInWater();
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 11 && this.getAttackTarget() != null) {
			launchAttack();
		}

		AnimationHandler.INSTANCE.updateAnimations(this);

	}

	public static final PropertyDirection FACING = BlockDirectional.FACING;

	public boolean testLay(World world, BlockPos pos) {
		//System.err.println("Testing laying conditions");
		BlockPos posNest = pos;
		if (isLayableNest(world, posNest)) {
			String eggRenderType = new Object() {
				public String getValue(BlockPos posNest, String tag) {
					TileEntity tileEntity = world.getTileEntity(posNest);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos(posNest), "egg");

			//System.err.println("eggRenderType " + eggRenderType);

			if (eggRenderType.equals("")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (this.getAnimation() == NO_ANIMATION) {
			this.setAnimation(ATTACK_ANIMATION);
			//System.err.println("set attack");
		}
		return false;
	}

	public boolean isDirectPathBetweenPoints(Vec3d vec1, Vec3d vec2) {
		RayTraceResult movingobjectposition = this.world.rayTraceBlocks(vec1, new Vec3d(vec2.x, vec2.y, vec2.z), false, true, false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		if (!this.isPFAdult()) {
			return LepidodendronMod.YUXISAURUS_LOOT_YOUNG;
		}
		return LepidodendronMod.YUXISAURUS_LOOT;
	}

	//Rendering taxidermy:
	//--------------------
	public static double offsetWall(@Nullable String variant) {
		return 0.15;
	}
	public static double upperfrontverticallinedepth(@Nullable String variant) {
		return 0.0;
	}
	public static double upperbackverticallinedepth(@Nullable String variant) {
		return 0.0;
	}
	public static double upperfrontlineoffset(@Nullable String variant) {
		return 0.4;
	}
	public static double upperfrontlineoffsetperpendiular(@Nullable String variant) {
		return -0F;
	}
	public static double upperbacklineoffset(@Nullable String variant) {
		return 0.4;
	}
	public static double upperbacklineoffsetperpendiular(@Nullable String variant) {
		return -0.15F;
	}
	public static double lowerfrontverticallinedepth(@Nullable String variant) {
		return 0.00F;
	}
	public static double lowerbackverticallinedepth(@Nullable String variant) {
		return 0.00F;
	}
	public static double lowerfrontlineoffset(@Nullable String variant) {
		return 0.325;
	}
	public static double lowerfrontlineoffsetperpendiular(@Nullable String variant) {
		return 0.00F;
	}
	public static double lowerbacklineoffset(@Nullable String variant) {
		return 0.125;
	}
	public static double lowerbacklineoffsetperpendiular(@Nullable String variant) {
		return -0.01F;
	}
	@SideOnly(Side.CLIENT)
	public static ResourceLocation textureDisplay(@Nullable String variant) {
		return RenderYuxisaurus.TEXTURE;
	}

	@SideOnly(Side.CLIENT)
	public static ModelBase modelDisplay(@Nullable String variant) {
		return RenderDisplays.modelYuxisaurus;
	}

	public static float getScaler(@Nullable String variant) {
		return RenderYuxisaurus.getScaler();
	}


}