
package net.lepidodendron.item.entities;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.creativetab.TabLepidodendronMobile;
import net.lepidodendron.item.ItemGlassCaseDisplayItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;

@ElementsLepidodendronMod.ModElement.Tag
public class ItemAmplectobeluaRaw extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:amplectobelua_raw")
	public static final Item block = null;
	public ItemAmplectobeluaRaw(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.amplectobelua_raw);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("lepidodendron:entities/amplectobelua_raw", "inventory"));
	}
	public void init(FMLInitializationEvent event) {
		super.init(event);
		OreDictionary.registerOre("mobdnaPNlepidodendron:prehistoric_flora_amplectobelua", ItemAmplectobeluaRaw.block);
		OreDictionary.registerOre("listAllfishraw", ItemAmplectobeluaRaw.block);
		OreDictionary.registerOre("listAllmeatraw", ItemAmplectobeluaRaw.block);
		OreDictionary.registerOre("foodMeat", ItemAmplectobeluaRaw.block);
		OreDictionary.registerOre("pndietCrustacean", ItemAmplectobeluaRaw.block);
	}
	public static class ItemFoodCustom extends ItemGlassCaseDisplayItem {
		public ItemFoodCustom() {
			super();
			setTranslationKey("pf_amplectobelua_raw");
			setRegistryName("amplectobelua_raw");
			setCreativeTab(TabLepidodendronMobile.tab);
			setMaxStackSize(64);
		}

		@Nullable
		@Override
		public String getMobStr() {
			return "lepidodendron:prehistoric_flora_amplectobelua";
		}

		@Nullable
		@Override
		public String getVariantStr() {
			return null;
		}
	}
}
