/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bossweapons.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.bossweapons.client.model.ModelPosidensTrident;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BossWeaponsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelPosidensTrident.LAYER_LOCATION, ModelPosidensTrident::createBodyLayer);
	}
}