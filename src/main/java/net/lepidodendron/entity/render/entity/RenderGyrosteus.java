package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraGyrosteus;
import net.lepidodendron.entity.model.entity.ModelGyrosteus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGyrosteus extends RenderLivingBaseWithBook<EntityPrehistoricFloraGyrosteus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/gyrosteus.png");

    public static float getScaler() {
        return 0.9F;
    }
    public RenderGyrosteus(RenderManager mgr) {
        super(mgr, new ModelGyrosteus(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraGyrosteus entity) {
        return RenderGyrosteus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraGyrosteus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraGyrosteus entity, float f) {
        float scale = entity.getAgeScale()*getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}