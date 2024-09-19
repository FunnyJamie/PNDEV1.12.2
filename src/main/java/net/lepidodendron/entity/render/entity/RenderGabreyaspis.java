package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraGabreyaspis;
import net.lepidodendron.entity.model.entity.ModelGabreyaspis;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGabreyaspis extends RenderLivingBaseWithBook<EntityPrehistoricFloraGabreyaspis> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/gabreyaspis.png");

    public RenderGabreyaspis(RenderManager mgr) {
        super(mgr, new ModelGabreyaspis(), 0.0f);
    }

    public static float getScaler() {return 0.285F; }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraGabreyaspis entity) {
        return RenderGabreyaspis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraGabreyaspis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraGabreyaspis entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {scale = 0.1f;}
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.0F;
    }

}