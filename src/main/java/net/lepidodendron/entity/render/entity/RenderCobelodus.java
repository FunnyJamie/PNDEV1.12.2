package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCobelodus;
import net.lepidodendron.entity.model.entity.ModelCobelodus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCobelodus extends RenderLivingBaseWithBook<EntityPrehistoricFloraCobelodus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/cobelodus.png");

    public RenderCobelodus(RenderManager mgr) {
        super(mgr, new ModelCobelodus(), 0.0f);
    }

    public static float getScaler() {
        return 0.5F;
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCobelodus entity) {
        return RenderCobelodus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCobelodus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraCobelodus entity, float f) {
        float scale = entity.getAgeScale() * this.getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.35F;
    }

}
