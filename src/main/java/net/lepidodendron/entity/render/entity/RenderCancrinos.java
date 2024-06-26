package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCancrinos;
import net.lepidodendron.entity.model.entity.ModelCancrinos;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCancrinos extends RenderLivingBaseWithBook<EntityPrehistoricFloraCancrinos> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/cancrinos.png");

    public static float getScaler() {
        return 0.65F * 0.45F;
    }
    public RenderCancrinos(RenderManager mgr) {
        super(mgr, new ModelCancrinos(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCancrinos entity) {
        return RenderCancrinos.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCancrinos entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraCancrinos entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}