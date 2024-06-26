package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCyrtoceras;
import net.lepidodendron.entity.model.entity.ModelCyrtoceras;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCyrtoceras extends RenderLivingBaseWithBook<EntityPrehistoricFloraCyrtoceras> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/cyrtoceras.png");
    public static float getScaler() {return 0.2F;}

    public RenderCyrtoceras(RenderManager mgr) {
        super(mgr, new ModelCyrtoceras(), 0.1f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCyrtoceras entity) {
        return RenderCyrtoceras.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCyrtoceras entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraCyrtoceras entity, float f) {
        float scale = entity.getAgeScale()*getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.45F;
    }

}