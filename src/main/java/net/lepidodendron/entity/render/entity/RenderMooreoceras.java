package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraMooreoceras;
import net.lepidodendron.entity.model.entity.ModelMooreoceras;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMooreoceras extends RenderLivingBaseWithBook<EntityPrehistoricFloraMooreoceras> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/mooreoceras.png");

    public RenderMooreoceras(RenderManager mgr) {
        super(mgr, new ModelMooreoceras(), 0.1f);
    }
    public static float getScaler() {
        return 0.225F;
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraMooreoceras entity) {
        return RenderMooreoceras.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraMooreoceras entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraMooreoceras entity, float f) {
        float scale = entity.getAgeScale();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.15F;
    }

}