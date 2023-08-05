
package net.lepidodendron.item;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.block.BlockPlaneSapling;
import net.lepidodendron.creativetab.TabLepidodendronPlants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@ElementsLepidodendronMod.ModElement.Tag
public class ItemPlaneSeeds extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:plane_seeds")
	public static final Item block = null;
	public ItemPlaneSeeds(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.plane_seeds);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		OreDictionary.registerOre("pndietSeed", ItemPlaneSeeds.block);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("lepidodendron:plane_seeds", "inventory"));
	}
	public static class ItemCustom extends ItemPrehistoricPlantable {
		public ItemCustom() {
			super(BlockPlaneSapling.block.getDefaultState(),1);
			setTranslationKey("pf_plane_seeds");
			setRegistryName("plane_seeds");
			setCreativeTab(TabLepidodendronPlants.tab);
		}
	}
}
