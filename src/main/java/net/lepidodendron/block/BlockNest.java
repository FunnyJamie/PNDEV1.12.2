
package net.lepidodendron.block;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.creativetab.TabLepidodendronMobile;
import net.lepidodendron.entity.base.EntityPrehistoricFloraAgeableBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockNest extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:nest")
	public static final Block block = null;
	public BlockNest(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.nest);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("nest"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(BlockNest.TileEntityCustom.class, "lepidodendron:tileentitynest");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:nest", "inventory"));
	}

	public static class BlockCustom extends Block implements IShearable {

		public static final PropertyBool MOUND = PropertyBool.create("mound");
		public static final PropertyBool BIRD = PropertyBool.create("bird");

		public BlockCustom() {
			super(Material.PLANTS);
			setTranslationKey("pf_nest");
			setSoundType(SoundType.PLANT);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabLepidodendronMobile.tab);
			this.setDefaultState(this.blockState.getBaseState().withProperty(MOUND, false).withProperty(BIRD, true));

		}

		@Override
		public Material getMaterial(IBlockState state) {
			if (state.getValue(BIRD)) {
				return Material.PLANTS;
			}
			return Material.SAND;
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{MOUND, BIRD});
		}

		public IBlockState getStateFromMeta(int meta)
		{
			return this.getDefaultState();
		}

		public int getMetaFromState(IBlockState state)
		{
			return 0;
		}

		@Override
		public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity)
		{
			if (state.getValue(BIRD)) {
				return SoundType.PLANT;
			}
			return SoundType.SAND;
		}

		@Override
		public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
			boolean isMound = false;
			//if (worldIn instanceof World) {
				isMound = (isMound( worldIn, pos));
			//}
			boolean isBird = (worldIn.getBlockState(pos.down()).getMaterial() == Material.LEAVES
				|| worldIn.getBlockState(pos.down()).getMaterial() == Material.WOOD);

			return state.withProperty(MOUND, isMound).withProperty(BIRD, (isBird && !isMound));
		}

		public static boolean isMound(IBlockAccess world, BlockPos pos) {
			String nestType = new Object() {
				public String getValue(BlockPos pos1, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos1);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(pos, "creature");

			if (!nestType.equalsIgnoreCase("")) {
				if (nestType.equalsIgnoreCase("lepidodendron:prehistoric_flora_claudiosaurus")
						|| nestType.equalsIgnoreCase("lepidodendron:prehistoric_flora_glaurung")
						|| nestType.equalsIgnoreCase("lepidodendron:prehistoric_flora_rautiania")
						|| nestType.equalsIgnoreCase("lepidodendron:prehistoric_flora_coelurosauravus")
				) {
					return true;
				}
				//Dangit the entity isn't available to a IBlockAccess to check!
				//EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(nestType));
				//if (ee != null) {
				//	Entity entityEggs = ee.newInstance(world);
				//	if (entityEggs instanceof EntityPrehistoricFloraAgeableBase) {
				//		EntityPrehistoricFloraAgeableBase entityLand = (EntityPrehistoricFloraAgeableBase) entityEggs;
				//		if (entityLand.isNestMound()) {
				//			return true;
				//		}
				//	}
				//}
			}
			return false;
		}

		@Override
		public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
			if (this.isMound(worldIn, pos)) {
				addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0625, 0, 0.0625, 0.9375, 0.0625, 0.9375));
				addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.1875, 0, 0.1875, 0.8125, 0.125, 0.8125));
			}
			else if (!this.getActualState(state, worldIn, pos).getValue(BIRD)){
				addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.05, 0, 0.05, 0.95, 0.2, 0.95));
			}
		}

		@Override
		@Nullable
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			if (source instanceof World) {
				if (this.isMound((World) source, pos)) {
					return new AxisAlignedBB(0.0, 0, 0.0, 1.0, 0.125, 1.0);
				}
			}
			if (state.getValue(BIRD)) {
				return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.6, 1.0);
			}
			return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.2, 1.0);
		}

		@Override
		public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
			if (worldIn.isAirBlock(pos.down())) {
				worldIn.destroyBlock(pos, false);
				//((World) world).setBlockToAir(pos);
			}

			super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
		}

		@Override
		public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
			if (worldIn.isAirBlock(pos.down())) {
				return false;
			}
			return super.canPlaceBlockAt(worldIn, pos);
		}

		@Nullable
		public static ItemStack getEggItemStack(@Nullable String stringEgg) {
			stringEgg = stringEgg.replace(LepidodendronMod.MODID + ":prehistoric_flora_", "");
			String eggs = LepidodendronMod.MODID + ":eggs_" + stringEgg;
			Item eggItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(eggs));
			if (eggItem != null) {
				return new ItemStack(eggItem, 1);
			}
			return null;
		}

		@Nullable
		public static Class getNestOwner(World world, BlockPos pos) {
			//Get the matching entity for the nbt applied:
			String nestType = new Object() {
				public String getValue(BlockPos pos1, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos1);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(pos, "creature");

			if (!nestType.equals("")) {
				//Get the mob:
				Class<? extends Entity> clazz = findEntity(nestType);
				if (clazz != null) {
					return findEntity(nestType);
				}
			}
			return null;
		}

		@Nullable
		private static Class<? extends Entity> findEntity(String entity) {
			Class<? extends Entity> entityClass;
			EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(entity));
			entityClass = ee == null ? null : ee.getEntityClass();
			return entityClass;
		}

		public static <T extends EntityPrehistoricFloraAgeableBase> void AggroMob(World world, BlockPos pos, @Nullable Class <? extends T > classEntity, @Nullable EntityPlayer player, boolean onlySight) {

			if (classEntity != null) {
				if (player != null) { //Aggro on the player
					if (!player.capabilities.isCreativeMode) {
						List<EntityPrehistoricFloraAgeableBase> Entities = world.getEntitiesWithinAABB(classEntity, new AxisAlignedBB(pos.add(-16, -8, -16), pos.add(16, 8, 16)));
						for (EntityPrehistoricFloraAgeableBase currentEntity : Entities) {
							if (currentEntity.isPFAdult() && !player.isInvisible()) {
								currentEntity.setAttackTarget(player);
								currentEntity.setOneHit(true);
							}
						}
					}
				} else { //Aggro on the nearest living Entity
					EntityLivingBase entityLivingBase = null;
					List<EntityLivingBase> Entity = world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(pos.add(-6, -4, -6), pos.add(6, 4, 6)));
					for (EntityLivingBase currentEntity : Entity) {
						if (!(currentEntity.getClass().equals(classEntity))) {
							entityLivingBase = currentEntity;
							break;
						}
					}
					if (entityLivingBase != null) {
						List<EntityPrehistoricFloraAgeableBase> Entities = world.getEntitiesWithinAABB(classEntity, new AxisAlignedBB(pos.add(-16, -8, -16), pos.add(16, 8, 16)));
						for (EntityPrehistoricFloraAgeableBase currentEntity : Entities) {
							if (currentEntity.isPFAdult()
								&& entityLivingBase.canEntityBeSeen(currentEntity)
							) {
								currentEntity.setAttackTarget(entityLivingBase);
								currentEntity.setOneHit(true);
							}
						}
					}
				}
			}
		}

		@Override
		protected boolean canSilkHarvest() {
			return false;
		}

		@Override
		public boolean isShearable(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos) {
			if (world instanceof World) {
				if (this.isMound((World) world, pos)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
			return NonNullList.withSize(1, new ItemStack(this, (int) (1)));
		}

		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			return new ItemStack(Blocks.AIR, (int) (1)).getItem();
		}

		@SideOnly(Side.CLIENT)
		@Override
		public EnumBlockRenderType getRenderType(IBlockState state) {
			if (state.getValue(MOUND)) {
				return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
			}
			return EnumBlockRenderType.MODEL;
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 10;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 10;
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.FOLIAGE;
		}

		@Override
		public void breakBlock(World world, BlockPos pos, IBlockState state) {
			if (!world.isRemote ) {
				SpawnEggs(world, pos);
			}
			world.removeTileEntity(pos);

			super.breakBlock(world, pos, state);
		}

		@Override
		public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
			if (!worldIn.isRemote) {
				ItemStack stack = playerIn.getHeldItemMainhand();
				if (stack.getItem() == Items.SHEARS && !this.isMound(worldIn, pos)) {
					//This will harvest:
					AggroMob(worldIn, pos, getNestOwner(worldIn, pos), playerIn, false);
				}
			}
			super.onBlockClicked(worldIn, pos, playerIn);
		}

		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
		{
			if (!world.isRemote) {
				if (this.isMound(world, pos)) {
					return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
				}
				String eggRenderType = "";
				eggRenderType = new Object() {
					public String getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(new BlockPos(pos), "egg");

				if ((!player.capabilities.allowEdit) || (!player.getHeldItemMainhand().isEmpty()) || eggRenderType.equals("")) {
					return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
				} else {
					if (!((hand != player.getActiveHand()) && (hand == EnumHand.MAIN_HAND))) {
						ItemStack stackEggs = getEggItemStack(eggRenderType);
						if (stackEggs != null) {
							stackEggs.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(player, stackEggs);
							TileEntity te = world.getTileEntity(pos);
							if (te != null) {
								te.getTileData().setString("egg", "");
								if (te instanceof TileEntityCustom) {
									TileEntityCustom tee = (TileEntityCustom) te;
									tee.setInventorySlotContents(0, ItemStack.EMPTY);
								}
							}
							IBlockState bstate = world.getBlockState(pos);
							world.notifyBlockUpdate(pos, bstate, bstate, 3);
							if (!player.capabilities.isCreativeMode) {
								AggroMob(world, pos, getNestOwner(world, pos), player, false);
							}
							return true;
						}
					}
					return true;
				}
			}
			return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
		}

		public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
			//Aggro nearby adults:
			if (!player.capabilities.isCreativeMode) {
				AggroMob(world, pos, getNestOwner(world, pos), player, false);
			}
			return super.removedByPlayer(state, world, pos, player, willHarvest);
		}

		public void SpawnEggs(World world, BlockPos pos) {
			String eggRenderType = new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos(pos), "egg");

			EntityItem entityToSpawn = null;
			if (!eggRenderType.equals("")) {
				ItemStack itemEgg = getEggItemStack(eggRenderType);
				//System.err.println("Block " + blockSpawn);
				if (itemEgg != null) {
					entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(itemEgg.getItem(), (int) (1)));
				}
			}
			if (!world.isRemote && entityToSpawn != null) {
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
				//System.err.println("Spawned " + entityToSpawn);
			}
		}

		@Override
		public boolean hasTileEntity(IBlockState state) {
			return true;
		}

		@Nullable
		@Override
		public TileEntity createTileEntity(World world, IBlockState state) {
			return new BlockNest.TileEntityCustom();
		}

		public BlockNest.TileEntityCustom createNewTileEntity(World worldIn, int meta) {
			return new BlockNest.TileEntityCustom();
		}

		@Override
		public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
			super.eventReceived(state, worldIn, pos, eventID, eventParam);
			TileEntity tileentity = worldIn.getTileEntity(pos);
			return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
		}

		@Override
		public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing side) {
			return BlockFaceShape.UNDEFINED;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getRenderLayer() {
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
			return layer == BlockRenderLayer.CUTOUT_MIPPED;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean isFullBlock(IBlockState state) {
			return false;
		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
			return false;
		}
	}

	public static class TileEntityCustom extends TileEntityLockableLoot implements ITickable {

		private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
		private String egg;
		private String creature;

		@Override
		public SPacketUpdateTileEntity getUpdatePacket() {
			NBTTagCompound tag = new NBTTagCompound();
			this.writeToNBT(tag);
			return new SPacketUpdateTileEntity(pos, 1, tag);
		}

		@Override
		public void onDataPacket(NetworkManager netManager, SPacketUpdateTileEntity packet) {
			readFromNBT(packet.getNbtCompound());
		}

		@Override
		public NBTTagCompound getUpdateTag() {
			return this.writeToNBT(new NBTTagCompound());
		}

		@Override
		public void handleUpdateTag(NBTTagCompound tag) {
			this.readFromNBT(tag);
		}

		@Override
		public void readFromNBT(NBTTagCompound compound)
		{
			super.readFromNBT(compound);
			if (compound.hasKey("egg")) {
				this.egg = compound.getString("egg");
			}
			if (compound.hasKey("creature")) {
				this.creature = compound.getString("creature");
			}
			this.stacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
			if (!this.checkLootAndRead(compound))
				ItemStackHelper.loadAllItems(compound, this.stacks);
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound)
		{
			super.writeToNBT(compound);
			if (this.hasEgg())
			{
				compound.setString("egg", this.egg);
			}
			if (this.hasCreature())
			{
				compound.setString("creature", this.creature);
			}
			if (!this.checkLootAndWrite(compound))
				ItemStackHelper.saveAllItems(compound, this.stacks);
			return compound;
		}

		public boolean hasEgg()
		{
			return this.egg != null;
		}

		public boolean hasCreature()
		{
			return this.creature != null && !this.creature.equals("");
		}

		@Override
		protected NonNullList<ItemStack> getItems() {
			return this.stacks;
		}

		@Override
		public int getSizeInventory() {
			return 1;
		}

		@Override
		public boolean isEmpty() {
			for (ItemStack itemstack : this.stacks)
				if (!itemstack.isEmpty())
					return false;
			return true;
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			if (stack.getItem() instanceof ItemEgg) {
				return true;
			}
			return false;
		}

		@Override
		public ItemStack getStackInSlot(int slot) {
			return stacks.get(slot);
		}

		@Override
		public int getInventoryStackLimit() {
			return 1;
		}

		@Override
		public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
			return null;
		}

		@Override
		public String getGuiID() {
			return null;
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public void update() {
			//Check that this egg nbt tag matches the inventory contents:
			//If they do not match then either a player has removed an egg or some event has removed from the inventory
			//In either case, reset both to null and aggro the relevant mobs:
			if (!world.isRemote) {
				boolean flag = false;

				String egg = this.getTileData().getString("egg");

				//System.err.println("update tile: getStackInSlot(0) = " + getStackInSlot(0));
				//System.err.println("update tile: egg = " + egg);

				if (
					(egg.equals(""))
					&&
					(getStackInSlot(0) != ItemStack.EMPTY && getStackInSlot(0).getItem() != Items.AIR)
				) {
					flag = true;
				}
				//if
				//(egg != null) {
				if (!egg.equals("")
						&&
						(getStackInSlot(0) == ItemStack.EMPTY || getStackInSlot(0).getItem() == Items.AIR)
				) {
					flag = true;
					//System.err.println("Setting flag to true");
				}
				//}

				World world = this.getWorld();
				BlockPos pos = this.getPos();
				if (flag && BlockNest.BlockCustom.isMound(world, pos)) {
					world.setBlockToAir(pos);
				}
				else if (flag) {
					setInventorySlotContents(0, ItemStack.EMPTY);
					this.egg = "";
					this.getTileData().setString("egg", "");
					BlockNest.BlockCustom.AggroMob(world, pos, BlockNest.BlockCustom.getNestOwner(world, pos), null, true);
				}
			}
		}
	}
}