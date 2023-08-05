
package net.lepidodendron.item.entities;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.creativetab.TabLepidodendronMobile;
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
public class ItemPalaeotarbusRaw extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:palaeotarbus_raw")
	public static final Item block = null;
	public ItemPalaeotarbusRaw(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.palaeotarbus_raw);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("lepidodendron:entities/palaeotarbus_raw", "inventory"));
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		OreDictionary.registerOre("mobdnaPNlepidodendron:prehistoric_flora_trigonotarbid_palaeotarbus", ItemPalaeotarbusRaw.block);
		OreDictionary.registerOre("listAllmeatraw", ItemPalaeotarbusRaw.block);
		OreDictionary.registerOre("foodMeat", ItemPalaeotarbusRaw.block);
		OreDictionary.registerOre("listAllinsectraw", ItemPalaeotarbusRaw.block);
		OreDictionary.registerOre("foodInsect", ItemPalaeotarbusRaw.block);
		OreDictionary.registerOre("pndietBug", ItemPalaeotarbusRaw.block);
	}

	public static class ItemFoodCustom extends ItemPNTaxidermyItem {
		public ItemFoodCustom() {
			super(1, 0.05f, false);
			setTranslationKey("pf_palaeotarbus_raw");
			setRegistryName("palaeotarbus_raw");
			setCreativeTab(TabLepidodendronMobile.tab);
			setMaxStackSize(64);
		}
	}
}
