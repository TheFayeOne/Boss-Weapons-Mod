// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelPosidensTrident<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "posidenstrident"), "main");
	private final ModelPart bb_main;

	public ModelPosidensTrident(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.0F, -10.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(-1.0F, -6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 4)
						.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 8)
						.addBox(-1.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-3.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 12)
						.addBox(-5.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(1.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 0)
						.addBox(3.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 4)
						.addBox(-1.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 16)
						.addBox(-5.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 8)
						.addBox(3.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 12)
						.addBox(-1.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}