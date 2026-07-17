/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bossweapons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.bossweapons.item.WitherstaffItem;
import net.mcreator.bossweapons.item.WitherbladeItem;
import net.mcreator.bossweapons.item.SonorousStaffItem;
import net.mcreator.bossweapons.item.PosidensTridentItem;
import net.mcreator.bossweapons.item.EnderBladeItem;
import net.mcreator.bossweapons.item.DragontailGreatswordItem;
import net.mcreator.bossweapons.item.AxeOfTheSeaItem;
import net.mcreator.bossweapons.BossWeaponsMod;

import java.util.function.Function;

public class BossWeaponsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BossWeaponsMod.MODID);
	public static final DeferredItem<Item> WITHERSTAFF = register("witherstaff", WitherstaffItem::new);
	public static final DeferredItem<Item> WITHERBLADE = register("witherblade", WitherbladeItem::new);
	public static final DeferredItem<Item> DRAGONTAIL_GREATSWORD = register("dragontail_greatsword", DragontailGreatswordItem::new);
	public static final DeferredItem<Item> ENDER_BLADE = register("ender_blade", EnderBladeItem::new);
	public static final DeferredItem<Item> SONOROUS_STAFF = register("sonorous_staff", SonorousStaffItem::new);
	public static final DeferredItem<Item> POSEIDONS_TRIDENT = register("poseidons_trident", PosidensTridentItem::new);
	public static final DeferredItem<Item> AXE_OF_THE_SEA = register("axe_of_the_sea", AxeOfTheSeaItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}