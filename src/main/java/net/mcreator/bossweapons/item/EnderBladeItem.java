package net.mcreator.bossweapons.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.bossweapons.procedures.EnderBladeRightclickedProcedure;

public class EnderBladeItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 2000, 1f, 0, 12, TagKey.create(Registries.ITEM, ResourceLocation.parse("boss_weapons:ender_blade_repair_items")));

	public EnderBladeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 6f, -2.4f, properties);
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		EnderBladeRightclickedProcedure.execute(entity, entity.getItemInHand(hand));
		return ar;
	}
}