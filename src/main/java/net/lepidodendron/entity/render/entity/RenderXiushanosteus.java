package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraXiushanosteus;
import net.lepidodendron.entity.model.entity.ModelXiushanosteus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderXiushanosteus extends RenderLivingBaseWithBook<EntityPrehistoricFloraXiushanosteus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/xiushanosteus.png");

    public static float getScaler() {
        return 0.7F * 0.3F;
    }
    public RenderXiushanosteus(RenderManager mgr) {
        super(mgr, new ModelXiushanosteus(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraXiushanosteus entity) {
        return RenderXiushanosteus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraXiushanosteus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraXiushanosteus entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}