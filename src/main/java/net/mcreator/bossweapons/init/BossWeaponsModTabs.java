/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bossweapons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.bossweapons.BossWeaponsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BossWeaponsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BossWeaponsMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(BossWeaponsModItems.AXE_OF_THE_SEA.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(BossWeaponsModItems.ENDER_BLADE.get());
			tabData.accept(BossWeaponsModItems.DRAGONTAIL_GREATSWORD.get());
			tabData.accept(BossWeaponsModItems.WITHERSTAFF.get());
			tabData.accept(BossWeaponsModItems.WITHERBLADE.get());
			tabData.accept(BossWeaponsModItems.POSEIDONS_TRIDENT.get());
			tabData.accept(BossWeaponsModItems.SONOROUS_STAFF.get());
		}
	}
}