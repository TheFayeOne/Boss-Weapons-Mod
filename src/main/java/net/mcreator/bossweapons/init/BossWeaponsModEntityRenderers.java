/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bossweapons.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.bossweapons.client.renderer.PosidensTridentProjectileRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BossWeaponsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BossWeaponsModEntities.POSEIDONS_TRIDENT_PROJECTILE.get(), PosidensTridentProjectileRenderer::new);
	}
}