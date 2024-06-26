package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAdamanteryon;
import net.lepidodendron.entity.model.entity.ModelAdamanteryon;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAdamanteryon extends RenderLivingBaseWithBook<EntityPrehistoricFloraAdamanteryon> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/adamanteryon.png");

    public static float getScaler() {
        return 0.7F * 0.3F;
    }
    public RenderAdamanteryon(RenderManager mgr) {
        super(mgr, new ModelAdamanteryon(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAdamanteryon entity) {
        return RenderAdamanteryon.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAdamanteryon entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraAdamanteryon entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}