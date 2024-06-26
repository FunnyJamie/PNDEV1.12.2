package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraGyracanthides;
import net.lepidodendron.entity.model.entity.ModelGyracanthides;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGyracanthides extends RenderLivingBaseWithBook<EntityPrehistoricFloraGyracanthides> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/gyracanthides.png");

    public RenderGyracanthides(RenderManager mgr) {
        super(mgr, new ModelGyracanthides(), 0.0f);
    }

    public static float getScaler() {return 0.42F; }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraGyracanthides entity) {
        return RenderGyracanthides.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraGyracanthides entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraGyracanthides entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {scale = 0.1f;}
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.0F;
    }

}