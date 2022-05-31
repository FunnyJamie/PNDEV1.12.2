package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraBarbclabornia;
import net.lepidodendron.entity.model.entity.ModelBarbclabornia;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBarbclabornia extends RenderLiving<EntityPrehistoricFloraBarbclabornia> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/barbclabornia.png");

    public RenderBarbclabornia(RenderManager mgr) {
        super(mgr, new ModelBarbclabornia(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraBarbclabornia entity) {
        return RenderBarbclabornia.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraBarbclabornia entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}