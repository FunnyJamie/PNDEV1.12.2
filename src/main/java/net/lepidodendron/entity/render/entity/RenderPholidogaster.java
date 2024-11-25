package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraPholidogaster;
import net.lepidodendron.entity.model.entity.ModelPholidogaster;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPholidogaster extends RenderLivingBaseWithBook<EntityPrehistoricFloraPholidogaster> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/pholidogaster.png");

    public static float getScaler() {return 0.43f;}

    public RenderPholidogaster(RenderManager mgr) {
        super(mgr, new ModelPholidogaster(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraPholidogaster entity) {
        return RenderPholidogaster.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraPholidogaster entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraPholidogaster entity, float f) {
        float scale = entity.getAgeScale()*getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.4F;
    }

}