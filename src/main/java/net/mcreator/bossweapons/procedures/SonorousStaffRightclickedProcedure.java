package net.mcreator.bossweapons.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.bossweapons.BossWeaponsMod;

public class SonorousStaffRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack, 31);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SONIC_BOOM, x, y, z, 1, 1, 1, 1, 1);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 11, 255, false, true));
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.NONE);
		BossWeaponsMod.queueServerWork(10, () -> {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = initProjectileProperties(new ThrownEnderpearl(EntityType.ENDER_PEARL, projectileLevel), entity, Vec3.ZERO);
				_entityToSpawn.setPos(x, y, z);
				_entityToSpawn.shoot(0, (-1), 0, 1, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = createPotionProjectile(projectileLevel, PotionContents.createItemStack(Items.SPLASH_POTION, Potions.HARMING), entity, new Vec3(0, 1, 0));
				_entityToSpawn.setPos(x, y, z);
				_entityToSpawn.shoot(0, (-1), 0, 1, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		});
	}

	private static Projectile initProjectileProperties(Projectile entityToSpawn, Entity shooter, Vec3 acceleration) {
		entityToSpawn.setOwner(shooter);
		if (!Vec3.ZERO.equals(acceleration)) {
			entityToSpawn.setDeltaMovement(acceleration);
			entityToSpawn.hasImpulse = true;
		}
		return entityToSpawn;
	}

	private static Projectile createPotionProjectile(Level level, ItemStack contents, Entity shooter, Vec3 acceleration) {
		ThrownPotion entityToSpawn = new ThrownPotion(EntityType.POTION, level);
		entityToSpawn.setItem(contents);
		return initProjectileProperties(entityToSpawn, shooter, acceleration);
	}
}