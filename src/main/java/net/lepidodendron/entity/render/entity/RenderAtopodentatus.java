package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAtopodentatus;
import net.lepidodendron.entity.model.entity.ModelAtopodentatus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAtopodentatus extends RenderLivingBaseWithBook<EntityPrehistoricFloraAtopodentatus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/atopodentatus.png");

    public static float getScaler() {return 1.0F* 0.367F;}

    public RenderAtopodentatus(RenderManager mgr) {
        super(mgr, new ModelAtopodentatus(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAtopodentatus entity) {
        return RenderAtopodentatus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAtopodentatus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraAtopodentatus entity, float f) {
        float scale = entity.getAgeScale()*getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.58F;
    }

}