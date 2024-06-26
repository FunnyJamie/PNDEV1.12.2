package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAphetoceras;
import net.lepidodendron.entity.model.entity.ModelAphetoceras;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAphetoceras extends RenderLivingBaseWithBook<EntityPrehistoricFloraAphetoceras> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/aphetoceras.png");
    public static float getScaler() {return 0.2F;}

    public RenderAphetoceras(RenderManager mgr) {
        super(mgr, new ModelAphetoceras(), 0.1f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAphetoceras entity) {
        return RenderAphetoceras.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAphetoceras entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraAphetoceras entity, float f) {
        float scale = entity.getAgeScale()*getScaler();
        GlStateManager.scale(scale * 0.55, scale * 0.55, scale * 0.55);
        this.shadowSize = entity.width * scale * 0.45F;
    }

}