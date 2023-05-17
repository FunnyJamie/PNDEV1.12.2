package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCambroraster;
import net.lepidodendron.entity.model.entity.ModelCambroraster;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCambroraster extends RenderLiving<EntityPrehistoricFloraCambroraster> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/cambroraster.png");

    public static float getScaler() {
        return 0.65F;
    }

    public RenderCambroraster(RenderManager mgr) {
        super(mgr, new ModelCambroraster(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCambroraster entity) {
        return RenderCambroraster.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCambroraster entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraCambroraster entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }
}