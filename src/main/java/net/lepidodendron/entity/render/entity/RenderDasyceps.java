package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraDasyceps;
import net.lepidodendron.entity.model.entity.ModelDasyceps;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDasyceps extends RenderLivingBaseWithBook<EntityPrehistoricFloraDasyceps> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/dasyceps.png");
    public static float getScaler() {
        return 0.305F;
    }

    public RenderDasyceps(RenderManager mgr) {
        super(mgr, new ModelDasyceps(), 0.3f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraDasyceps entity) {
        return RenderDasyceps.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraDasyceps entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraDasyceps entity, float f) {
        float scale = entity.getAgeScale() * this.getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.15F;
    }

}