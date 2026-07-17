package net.mcreator.bossweapons.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.bossweapons.procedures.SonorousStaffRightclickedProcedure;

public class SonorousStaffItem extends Item {
	public SonorousStaffItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1).fireResistant()
				.attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.SPEAR;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		SonorousStaffRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}
}