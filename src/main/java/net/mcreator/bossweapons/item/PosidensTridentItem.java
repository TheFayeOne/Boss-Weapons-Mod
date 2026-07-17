package net.mcreator.bossweapons.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.bossweapons.entity.PosidensTridentProjectileEntity;

public class PosidensTridentItem extends Item {
	public PosidensTridentItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1).fireResistant()
				.attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 20;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = InteractionResult.FAIL;
		if (entity.getAbilities().instabuild || findAmmo(entity) != ItemStack.EMPTY) {
			ar = InteractionResult.SUCCESS;
			entity.startUsingItem(hand);
		}
		return ar;
	}

	@Override
	public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		if (!world.isClientSide() && entity instanceof ServerPlayer player) {
			float pullingPower = BowItem.getPowerForTime(this.getUseDuration(itemstack, player) - time);
			if (pullingPower < 0.1)
				return false;
			ItemStack stack = findAmmo(player);
			if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
				PosidensTridentProjectileEntity projectile = PosidensTridentProjectileEntity.shoot(world, entity, world.getRandom(), pullingPower);
				if (player.getAbilities().instabuild) {
					projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
				} else {
					if (stack.isDamageableItem()) {
						if (world instanceof ServerLevel serverLevel)
							stack.hurtAndBreak(1, serverLevel, player, _stkprov -> {
							});
					} else {
						stack.shrink(1);
					}
				}
			}
		}
		return super.releaseUsing(itemstack, world, entity, time);
	}

	private ItemStack findAmmo(Player player) {
		return new ItemStack(PosidensTridentProjectileEntity.PROJECTILE_ITEM.getItem());
	}
}