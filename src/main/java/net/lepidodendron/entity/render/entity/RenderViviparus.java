package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraViviparus;
import net.lepidodendron.entity.model.entity.ModelViviparus;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderViviparus extends RenderLiving<EntityPrehistoricFloraViviparus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/viviparus.png");

    public static float getScaler() {
        return 0.7F * 0.395F;
    }
    public RenderViviparus(RenderManager mgr) {
        super(mgr, new ModelViviparus(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraViviparus entity) {
        return RenderViviparus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraViviparus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraViviparus entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}