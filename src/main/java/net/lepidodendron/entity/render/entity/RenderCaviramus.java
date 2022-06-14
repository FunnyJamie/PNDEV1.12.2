package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCaviramus;
import net.lepidodendron.entity.model.entity.ModelCaviramus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCaviramus extends RenderLiving<EntityPrehistoricFloraCaviramus> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/caviramus.png");

    public RenderCaviramus(RenderManager mgr) {
        super(mgr, new ModelCaviramus(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCaviramus entity) {
        return RenderCaviramus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCaviramus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}








