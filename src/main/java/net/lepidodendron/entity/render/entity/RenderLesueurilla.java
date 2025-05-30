package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraLesueurilla;
import net.lepidodendron.entity.model.entity.ModelLesueurilla;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderLesueurilla extends RenderLivingBaseWithBook<EntityPrehistoricFloraLesueurilla> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/lesueurilla.png");

    public static float getScaler() {
        return 0.18F;
    }
    public RenderLesueurilla(RenderManager mgr) {
        super(mgr, new ModelLesueurilla(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraLesueurilla entity) {
        return RenderLesueurilla.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraLesueurilla entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraLesueurilla entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}