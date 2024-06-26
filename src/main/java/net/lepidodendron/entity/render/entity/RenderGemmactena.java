package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraGemmactena;
import net.lepidodendron.entity.model.entity.ModelCombJelly;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGemmactena extends RenderLivingBaseWithBook<EntityPrehistoricFloraGemmactena> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/gemmactena.png");

    public RenderGemmactena(RenderManager mgr) {
        super(mgr, new ModelCombJelly(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraGemmactena entity) {
        return RenderGemmactena.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraGemmactena entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}