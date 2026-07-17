package net.mcreator.bossweapons.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.bossweapons.procedures.AxeOfTheSeaToolInHandTickProcedure;
import net.mcreator.bossweapons.init.BossWeaponsModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AxeOfTheSeaItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 12f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("boss_weapons:axe_of_the_sea_repair_items")));

	public AxeOfTheSeaItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 9f, -3f, properties.fireResistant());
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(BossWeaponsModItems.AXE_OF_THE_SEA.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			AxeOfTheSeaToolInHandTickProcedure.execute(entity);
	}
}