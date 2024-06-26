package net.lepidodendron.procedure;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockMagnoliaFlower;
import net.lepidodendron.block.BlockMagnoliaLeaves;
import net.lepidodendron.block.BlockMagnoliaLog;
import net.lepidodendron.util.Functions;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenMagnoliaBranchEast1 extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenMagnoliaBranchEast1(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure ( Object2ObjectOpenHashMap <String, Object> dependencies ) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenMagnoliaBranchEast1!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenMagnoliaBranchEast1!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenMagnoliaBranchEast1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenMagnoliaBranchEast1!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double randomiser = 0;
		double option  = 0;
		int xx = x;
		int yy = y;
		int zz = z;
		randomiser = Math.random();
		if (randomiser >= 0.50) {
			option = 1;
			}
			else {
				//if (randomiser >= 0.5) {
				option = 2;
				}

		if (option == 1) {
			//Branch option 1:
			xx = x;
			yy = y;
			zz = z;
			Block block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
				new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLog.block.getDefaultState(), 3);
				try {
						IBlockState _bs = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz));
						for (IProperty<?> prop : _bs.getProperties().keySet()) {
							if (prop.getName().equals("facing")) {
								Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz),
										_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
								break;
							}
						}
					} catch (Exception e) {
					}
				}

			//Leaves:
			xx = x;
			yy = y + 1;
			zz = z;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				
			xx = x;
			yy = y;
			zz = z + 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x;
			yy = y;
			zz = z - 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 1;
			yy = y;
			zz = z;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			}
			
		if (option == 2) {
			//Branch option 2:
			xx = x;
			yy = y;
			zz = z;
			Block block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
				new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLog.block.getDefaultState(), 3);
				try {
						IBlockState _bs = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz));
						for (IProperty<?> prop : _bs.getProperties().keySet()) {
							if (prop.getName().equals("facing")) {
								Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz),
										_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
								break;
							}
						}
					} catch (Exception e) {
					}
				}

			xx = x + 1;
			yy = y;
			zz = z;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
				new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLog.block.getDefaultState(), 3);
				try {
						IBlockState _bs = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz));
						for (IProperty<?> prop : _bs.getProperties().keySet()) {
							if (prop.getName().equals("facing")) {
								Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz),
										_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
								break;
							}
						}
					} catch (Exception e) {
					}
				}
				
			xx = x + 2;
			yy = y;
			zz = z;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
				new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLog.block.getDefaultState(), 3);
				try {
						IBlockState _bs = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz));
						for (IProperty<?> prop : _bs.getProperties().keySet()) {
							if (prop.getName().equals("facing")) {
								Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz),
										_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
								break;
							}
						}
					} catch (Exception e) {
					}
				}

			xx = x + 1;
			yy = y;
			zz = z + 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
				new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLog.block.getDefaultState(), 3);
				try {
						IBlockState _bs = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz));
						for (IProperty<?> prop : _bs.getProperties().keySet()) {
							if (prop.getName().equals("facing")) {
								Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz),
										_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
								break;
							}
						}
					} catch (Exception e) {
					}
				}

			xx = x + 1;
			yy = y;
			zz = z - 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
				new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLog.block.getDefaultState(), 3);
				try {
						IBlockState _bs = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz));
						for (IProperty<?> prop : _bs.getProperties().keySet()) {
							if (prop.getName().equals("facing")) {
								Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz),
										_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
								break;
							}
						}
					} catch (Exception e) {
					}
				}

			xx = x;
			yy = y;
			zz = z + 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}

			xx = x;
			yy = y;
			zz = z - 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}

			xx = x + 1;
			yy = y;
			zz = z + 2;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 1;
			yy = y;
			zz = z - 2;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 2;
			yy = y;
			zz = z + 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 2;
			yy = y;
			zz = z - 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 3;
			yy = y;
			zz = z;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 1;
			yy = y + 1;
			zz = z;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 2;
			yy = y + 1;
			zz = z;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 1;
			yy = y + 1;
			zz = z + 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}

			xx = x + 1;
			yy = y + 1;
			zz = z - 1;
			block = world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) xx, (int) yy, (int) zz)), world,
					new BlockPos((int) xx, (int) yy, (int) zz))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockMagnoliaLeaves.block.getDefaultState(), 3);
				}
			//Random flowers here:
			if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos((int) xx, (int) (yy + 1), (int) zz)))) {
				Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) (yy + 1), (int) zz), BlockMagnoliaFlower.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) xx, (int) (yy + 1), (int) zz);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				
			}

		}
		
	}
