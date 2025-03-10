
package net.lepidodendron.entity;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.block.base.IAdvancementGranter;
import net.lepidodendron.entity.ai.DietString;
import net.lepidodendron.entity.render.entity.RenderGobiconodon;
import net.lepidodendron.entity.render.tile.RenderDisplays;
import net.lepidodendron.entity.util.ITrappableLand;
import net.lepidodendron.util.CustomTrigger;
import net.lepidodendron.util.ModTriggers;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;

public class EntityPrehistoricFloraGobiconodon extends EntityPrehistoricFloraMorganucodon implements ITrappableLand, IAdvancementGranter {
	public Animation STAND_ANIMATION;
	public Animation ALERT_ANIMATION;
	private int standCooldown;

	public EntityPrehistoricFloraGobiconodon(World world) {
		super(world);
		setSize(0.3F, 0.3F);
		minWidth = 0.12F;
		maxWidth = 0.3F;
		maxHeight = 0.3F;
		maxHealthAgeable = 8.0D;
		STAND_ANIMATION = Animation.create(35);
		ALERT_ANIMATION = Animation.create(95);
	}

	@Nullable
	@Override
	public CustomTrigger getModTrigger() {
		return ModTriggers.CLICK_GOBICONODON;
	}


	public static String getPeriod() {return "Early Cretaceous";}

	@Override
	public String[] getFoodOreDicts() {
		return ArrayUtils.addAll(ArrayUtils.addAll(DietString.BUG, DietString.MEAT), DietString.FRUIT);
	}

	public float getAISpeedLand() {
		float speedBase = 0.26F;
		if (this.getTicks() < 0) {
			return 0.0F; //Is laying eggs
		}
		if (this.getAnimation() == DRINK_ANIMATION || this.getAnimation() == MAKE_NEST_ANIMATION || this.getAnimation() == STAND_ANIMATION || this.getAnimation() == ALERT_ANIMATION) {
			return 0.0F;
		}
		if (this.getIsFast()) {
			speedBase = speedBase * 1.8F;
		}
		return speedBase;
	}


	public AxisAlignedBB getAttackBoundingBox() {
		float size = this.getRenderSizeModifier() * 0.25F;
		return this.getEntityBoundingBox().grow(1.0F + size, 1.0F + size, 1.0F + size);
	}



	@Override
	public SoundEvent getAmbientSound() {
	    return (SoundEvent) SoundEvent.REGISTRY
	            .getObject(new ResourceLocation("lepidodendron:gobiconodon_idle"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
	    return (SoundEvent) SoundEvent.REGISTRY
	            .getObject(new ResourceLocation("lepidodendron:gobiconodon_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
	    return (SoundEvent) SoundEvent.REGISTRY
	            .getObject(new ResourceLocation("lepidodendron:gobiconodon_death"));
	}

	@Override
	public int getAttackLength() {
		return 11;
	}

	@Override
	public int getRoarLength() {
		return 22;
	}

	@Override
	public int getEatLength() {
		return 15;
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();

		//Sometimes stand up and look around:
		if ((!this.world.isRemote) && this.getEatTarget() == null && this.getAttackTarget() == null && this.getRevengeTarget() == null && this.getAlarmTarget() == null
				&& !this.getIsMoving() && this.getAnimation() == NO_ANIMATION && standCooldown == 0) {
			int next = rand.nextInt(2);
			switch (next) {
				case 0:
				default:
					this.setAnimation(STAND_ANIMATION);
					break;

				case 1:
					this.setAnimation(ALERT_ANIMATION);
					break;
			}
			this.standCooldown = 2000;
		}
		//forces animation to return to base pose by grabbing the last tick and setting it to that.
		if ((!this.world.isRemote) && this.getAnimation() == STAND_ANIMATION && this.getAnimationTick() == STAND_ANIMATION.getDuration() - 1) {
			this.standCooldown = 2000;
			this.setAnimation(NO_ANIMATION);
		}
		if ((!this.world.isRemote) && this.getAnimation() == ALERT_ANIMATION && this.getAnimationTick() == ALERT_ANIMATION.getDuration() - 1) {
			this.standCooldown = 2000;
			this.setAnimation(NO_ANIMATION);
		}

	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//this.renderYawOffset = this.rotationYaw;

		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 11 && this.getAttackTarget() != null) {
			launchAttack();
		}

		if (this.standCooldown > 0) {
			this.standCooldown -= rand.nextInt(3) + 1;
		}
		if (this.standCooldown < 0) {
			this.standCooldown = 0;
		}
		AnimationHandler.INSTANCE.updateAnimations(this);

		//System.err.println("Eating: " + this.getEatTarget() + " isFast " + this.getIsFast());

	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.standCooldown = rand.nextInt(2000);
		return livingdata;
	}

	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setInteger("standCooldown", this.standCooldown);
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.standCooldown = compound.getInteger("standCooldown");
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[]{ATTACK_ANIMATION, ROAR_ANIMATION, LAY_ANIMATION, MAKE_NEST_ANIMATION, EAT_ANIMATION, STAND_ANIMATION, ALERT_ANIMATION};
	}


	@Nullable
	protected ResourceLocation getLootTable() {
		return LepidodendronMod.GOBICONODON_LOOT;
	}



	//Rendering taxidermy:
	//--------------------
	public static double offsetPlinth() { return 0.16; }
	public static double offsetWall(@Nullable String variant) { return 0.05; }
	public static double upperfrontverticallinedepth(@Nullable String variant) {return 0;}
	public static double upperbackverticallinedepth(@Nullable String variant) {return 0;}
	public static double upperfrontlineoffset(@Nullable String variant) {return 0;}
	public static double upperfrontlineoffsetperpendiular(@Nullable String variant) {return 0.0F;}
	public static double upperbacklineoffset(@Nullable String variant) {return 0;}
	public static double upperbacklineoffsetperpendiular(@Nullable String variant) {return 0.0F;}
	public static double lowerfrontverticallinedepth(@Nullable String variant) {return 0;}
	public static double lowerbackverticallinedepth(@Nullable String variant) {return 0;}
	public static double lowerfrontlineoffset(@Nullable String variant) {return 0;}
	public static double lowerfrontlineoffsetperpendiular(@Nullable String variant) {return 0.0F;}
	public static double lowerbacklineoffset(@Nullable String variant) {return 0;}
	public static double lowerbacklineoffsetperpendiular(@Nullable String variant) {return 0.0F;}
	@SideOnly(Side.CLIENT)
	public static ResourceLocation textureDisplay(@Nullable String variant) {return RenderGobiconodon.TEXTURE;}
	@SideOnly(Side.CLIENT)
	public static ModelBase modelDisplay(@Nullable String variant) {return RenderDisplays.modelGobiconodon;}
	public static float getScaler(@Nullable String variant) {return RenderGobiconodon.getScaler();}


}