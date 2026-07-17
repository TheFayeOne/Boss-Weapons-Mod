package net.mcreator.bossweapons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.bossweapons.entity.PosidensTridentProjectileEntity;
import net.mcreator.bossweapons.client.model.ModelPosidensTrident;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PosidensTridentProjectileRenderer extends EntityRenderer<PosidensTridentProjectileEntity, LivingEntityRenderState> {
	private static final ResourceLocation texture = ResourceLocation.parse("boss_weapons:textures/entities/trident.png");
	private final ModelPosidensTrident model;

	public PosidensTridentProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelPosidensTrident(context.bakeLayer(ModelPosidensTrident.LAYER_LOCATION));
	}

	@Override
	public void render(LivingEntityRenderState state, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(texture));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + state.xRot));
		model.setupAnim(state);
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(state, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(PosidensTridentProjectileEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.xRot = entity.getXRot(partialTicks);
		state.yRot = entity.getYRot(partialTicks);
	}
}