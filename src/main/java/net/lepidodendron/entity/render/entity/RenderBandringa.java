package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraBandringa;
import net.lepidodendron.entity.model.entity.ModelBandringa;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBandringa extends RenderLivingBaseWithBook<EntityPrehistoricFloraBandringa> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/bandringa.png");

    public static float getScaler() {return 0.4f;}

    public RenderBandringa(RenderManager mgr) {
        super(mgr, new ModelBandringa(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraBandringa entity) {
        return RenderBandringa.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraBandringa entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    protected void preRenderCallback(EntityPrehistoricFloraBandringa entity, float f) {
        float scale = this.getScaler();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }
}