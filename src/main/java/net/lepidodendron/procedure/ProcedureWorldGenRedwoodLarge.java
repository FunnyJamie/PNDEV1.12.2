package net.lepidodendron.procedure;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.lepidodendron.ElementsLepidodendronMod;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenRedwoodLarge extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenRedwoodLarge(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure ( Object2ObjectOpenHashMap <String, Object> dependencies ) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenRedwoodLarge!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenRedwoodLarge!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenRedwoodLarge!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenRedwoodLarge!");
			return;
		}
		if (dependencies.get("SaplingSpawn") == null) {
			System.err.println("Failed to load dependency SaplingSpawn for procedure WorldGenRedwoodLarge!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		boolean SaplingSpawn = (boolean) dependencies.get("SaplingSpawn");
		
		Material material = world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getMaterial();
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			&& material != Material.GRASS
			&& material != Material.GROUND
			&& material != Material.GLASS
			&& material != Material.IRON
			&& material != Material.ROCK
			&& material != Material.SAND
			&& material != Material.WOOD
			&& (world.canSeeSky(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))))
			&& (world.canSeeSky(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))))
			&& (world.canSeeSky(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z - 1))))
			&& (world.canSeeSky(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)))
			&& (world.canSeeSky(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1))))
			&& (world.canSeeSky(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z - 1))))
			&& (world.canSeeSky(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)))
			&& (world.canSeeSky(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 1))))
			) {

			Object2ObjectOpenHashMap<String, Object> $_dependencies = new Object2ObjectOpenHashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				$_dependencies.put("SaplingSpawn", SaplingSpawn);
				
				ProcedureWorldGenRedwoodLargeNoCheck.executeProcedure($_dependencies);

		}
	}
}