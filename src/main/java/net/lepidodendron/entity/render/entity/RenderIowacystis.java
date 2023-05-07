package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraIowacystis;
import net.lepidodendron.entity.model.entity.ModelIowacystis;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderIowacystis extends RenderLiving<EntityPrehistoricFloraIowacystis> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/iowacystis.png");
    public static float getScaler() {
        return 0.7F * 0.3F;
    }
    public RenderIowacystis(RenderManager mgr) {
        super(mgr, new ModelIowacystis(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraIowacystis entity) {
        return RenderIowacystis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraIowacystis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraIowacystis entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}