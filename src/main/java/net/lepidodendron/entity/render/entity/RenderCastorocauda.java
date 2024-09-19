package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCastorocauda;
import net.lepidodendron.entity.model.entity.ModelCastorocauda;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCastorocauda extends RenderLivingBaseWithBook<EntityPrehistoricFloraCastorocauda> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/castorocauda.png");

    public RenderCastorocauda(RenderManager mgr) {
        super(mgr, new ModelCastorocauda(), 0.3f);
    }

    public static float getScaler() {
        return 0.3F;
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCastorocauda entity) {
        return RenderCastorocauda.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCastorocauda entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraCastorocauda entity, float f) {
        float scale = entity.getAgeScale() * this.getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.35F;
    }

}