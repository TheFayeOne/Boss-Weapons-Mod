package net.mcreator.bossweapons.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

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
import net.minecraft.core.component.DataComponents;

import net.mcreator.bossweapons.procedures.DragontailGreatswordRightclickedProcedure;
import net.mcreator.bossweapons.init.BossWeaponsModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DragontailGreatswordItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 1f, 0, 22, TagKey.create(Registries.ITEM, ResourceLocation.parse("boss_weapons:dragontail_greatsword_repair_items")));

	public DragontailGreatswordItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 11f, -3.4f, properties.fireResistant());
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(BossWeaponsModItems.DRAGONTAIL_GREATSWORD.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		DragontailGreatswordRightclickedProcedure.execute(entity, entity.getItemInHand(hand));
		return ar;
	}
}