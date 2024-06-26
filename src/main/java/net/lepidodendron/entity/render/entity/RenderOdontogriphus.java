package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraOdontogriphus;
import net.lepidodendron.entity.model.entity.ModelOdontogriphus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderOdontogriphus extends RenderLivingBaseWithBook<EntityPrehistoricFloraOdontogriphus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/odontogriphus.png");

    public RenderOdontogriphus(RenderManager mgr) {
        super(mgr, new ModelOdontogriphus(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraOdontogriphus entity) {
        return RenderOdontogriphus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraOdontogriphus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}