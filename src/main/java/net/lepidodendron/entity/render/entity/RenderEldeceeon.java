package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraEldeceeon;
import net.lepidodendron.entity.model.entity.ModelEldeceeon;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEldeceeon extends RenderLivingBaseWithBook<EntityPrehistoricFloraEldeceeon> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/eldeceeon.png");

    public static float getScaler() {return 0.26f;}

    public RenderEldeceeon(RenderManager mgr) {
        super(mgr, new ModelEldeceeon(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraEldeceeon entity) {
        return RenderEldeceeon.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraEldeceeon entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraEldeceeon entity, float f) {
        float scale = entity.getAgeScale()*getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.0F;
    }

}