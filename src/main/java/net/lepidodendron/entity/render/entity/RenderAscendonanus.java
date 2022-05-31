package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAscendonanus;
import net.lepidodendron.entity.model.entity.ModelAscendonanus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAscendonanus extends RenderLiving<EntityPrehistoricFloraAscendonanus> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/ascendonanus.png");

    public RenderAscendonanus(RenderManager mgr) {
        super(mgr, new ModelAscendonanus(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAscendonanus entity) {
        return RenderAscendonanus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAscendonanus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}