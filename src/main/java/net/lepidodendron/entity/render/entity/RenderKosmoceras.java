package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraKosmoceras;
import net.lepidodendron.entity.model.entity.ModelKosmoceras;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKosmoceras extends RenderLivingBaseWithBook<EntityPrehistoricFloraKosmoceras> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/kosmoceras.png");

    public static float getScaler() {
        return 0.7F * 0.4F;
    }
    public RenderKosmoceras(RenderManager mgr) {
        super(mgr, new ModelKosmoceras(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraKosmoceras entity) {
        return RenderKosmoceras.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraKosmoceras entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraKosmoceras entity, float f) {
        float scale = this.getScaler() * entity.getAgeScale();
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}