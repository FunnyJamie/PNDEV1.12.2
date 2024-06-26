package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAulacephalodon;
import net.lepidodendron.entity.model.entity.ModelAulacephalodon;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAulacephalodon extends RenderLivingBaseWithBook<EntityPrehistoricFloraAulacephalodon> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/aulacephalodon.png");

    public RenderAulacephalodon(RenderManager mgr) {
        super(mgr, new ModelAulacephalodon(), 0.325f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAulacephalodon entity) {
        return RenderAulacephalodon.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAulacephalodon entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraAulacephalodon entity, float f) {
        float scale = entity.getAgeScale();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.325F;
    }

}