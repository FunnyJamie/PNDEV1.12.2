package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraDrepanaspis;
import net.lepidodendron.entity.model.entity.ModelDrepanaspis;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDrepanaspis extends RenderLivingBaseWithBook<EntityPrehistoricFloraDrepanaspis> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/drepanaspis.png");

    public RenderDrepanaspis(RenderManager mgr) {
        super(mgr, new ModelDrepanaspis(), 0.325f);
    }

    public static float getScaler() {return 0.5F;}

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraDrepanaspis entity) {
        return RenderDrepanaspis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraDrepanaspis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraDrepanaspis entity, float f) {
        float scale = this.getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.0F;
    }

}