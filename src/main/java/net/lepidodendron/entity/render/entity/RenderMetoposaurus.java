package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraMetoposaurus;
import net.lepidodendron.entity.model.entity.ModelMetoposaurus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMetoposaurus extends RenderLivingBaseWithBook<EntityPrehistoricFloraMetoposaurus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/metoposaurus.png");

    public RenderMetoposaurus(RenderManager mgr) {
        super(mgr, new ModelMetoposaurus(), 0.0f);
    }

    public static float getScaler() {return 1.375F * 0.7F * 0.8F; }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraMetoposaurus entity) {
        return RenderMetoposaurus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraMetoposaurus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraMetoposaurus entity, float f) {
        float scale = entity.getAgeScale() * this.getScaler();
        if (scale < 0.1f) {scale = 0.1f;}
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.67F;
    }

}

