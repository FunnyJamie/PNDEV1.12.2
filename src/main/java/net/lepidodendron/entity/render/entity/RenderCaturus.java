package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCaturus;
import net.lepidodendron.entity.model.entity.ModelCaturus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCaturus extends RenderLivingBaseWithBook<EntityPrehistoricFloraCaturus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/strobilodus.png");

    public RenderCaturus(RenderManager mgr) {
        super(mgr, new ModelCaturus(), 0.0f);
    }

    public static float getScaler() {return 0.342F; }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCaturus entity) {
        return RenderCaturus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCaturus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraCaturus entity, float f) {
        float scale = this.getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.2F;
    }

}




