
package net.lepidodendron.block;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.creativetab.TabLepidodendronPlants;
import net.lepidodendron.item.ItemMonkeyPuzzleAraucariaNuts;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockMonkeyPuzzleAraucariaFruitBlock extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:monkey_puzzle_araucaria_fruit_block")
	public static final Block block = null;
	public BlockMonkeyPuzzleAraucariaFruitBlock(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.monkey_puzzle_araucaria_fruit_block);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("monkey_puzzle_araucaria_fruit_block"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:monkey_puzzle_araucaria_fruit_block", "inventory"));
	}
	public static class BlockCustom extends BlockFalling {
		public BlockCustom() {
			super(Material.PLANTS);
			setTranslationKey("pf_monkey_puzzle_araucaria_fruit_block");
			setSoundType(SoundType.WOOD);
			setHardness(1F);
			setResistance(0F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabLepidodendronPlants.tab);
			//setTickRandomly(true);
		}

		@SideOnly(Side.CLIENT)
		@Override
    public BlockRenderLayer getRenderLayer()
    {
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

		public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			
			drops.add(new ItemStack(ItemMonkeyPuzzleAraucariaNuts.block, (int) (3)));
			
			if (((world.getBlockState(pos.north())).getMaterial() == Material.WATER) 
				|| ((world.getBlockState(pos.south())).getMaterial() == Material.WATER)
				|| ((world.getBlockState(pos.east())).getMaterial() == Material.WATER)
				|| ((world.getBlockState(pos.west())).getMaterial() == Material.WATER)
				|| ((world.getBlockState(pos.up())).getMaterial() == Material.WATER))
			{
				drops.removeAll(drops);
				drops.add(new ItemStack(this, (int) (1)));
			}
			
		}

		@Override
		public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
			super.onBlockAdded(world, pos, state);
			if ((((world.getBlockState(pos.down())).getMaterial() == Material.VINE)
				|| ((world.getBlockState(pos.down())).getMaterial() == Material.SNOW)
				|| ((world.getBlockState(pos.down())).getMaterial()== Material.WEB)
				|| ((world.getBlockState(pos.down())).getMaterial() == Material.PLANTS))
				&& (world.getBlockState(pos.down()).getBlock() != this)) {
					world.destroyBlock(pos.down(), false);
			}
			else {
				if ((world.getBlockState(pos.down())).getBlock() == this) {
					world.destroyBlock(pos.down(), true);
				}
				else {
					if (!world.isAirBlock(pos.down()) && world.getBlockState(pos.down()).getBlockFaceShape(world, pos.down(), EnumFacing.UP) != BlockFaceShape.SOLID)
					{
						world.destroyBlock(pos, false);
						if (!world.isRemote) {
							EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
			}
		}

		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			super.neighborChanged(state, world, pos, neighborBlock, fromPos);
			if ((((world.getBlockState(pos.down())).getMaterial() == Material.VINE)
				|| ((world.getBlockState(pos.down())).getMaterial() == Material.SNOW)
				|| ((world.getBlockState(pos.down())).getMaterial()== Material.WEB)
				|| ((world.getBlockState(pos.down())).getMaterial() == Material.PLANTS))
				&& (world.getBlockState(pos.down()).getBlock() != this)) {
					world.destroyBlock(pos.down(), false);
			}
			else {
				if ((world.getBlockState(pos.down())).getBlock() == this) {
					world.destroyBlock(pos.down(), true);
				}
				else {
					if (!world.isAirBlock(pos.down()) && world.getBlockState(pos.down()).getBlockFaceShape(world, pos.down(), EnumFacing.UP) != BlockFaceShape.SOLID)
					{
						world.destroyBlock(pos, false);
						if (!world.isRemote) {
							EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
			}
		}

		@Override
		public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
			super.onEntityCollision(world, pos, state, entity);
			
			if ((entity instanceof EntityLiving) ||(entity instanceof EntityPlayer)) {
				entity.attackEntityFrom(DamageSource.FALLING_BLOCK, (float) 5);
				world.destroyBlock(pos, true);
			}
		}
		
		@Override
		protected boolean canSilkHarvest()
	    {
	        return true;
	    }
		
		@Override
		public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
			return BlockFaceShape.UNDEFINED;
		}
	    
	}
}
