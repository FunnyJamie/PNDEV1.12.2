package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraHerrerasaurus;
import net.lepidodendron.entity.model.entity.ModelHerrerasaurus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHerrerasaurus extends RenderLivingBaseWithBook<EntityPrehistoricFloraHerrerasaurus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/herrerasaurus.png");

    public static float getScaler() {return 0.785F;}

    public RenderHerrerasaurus(RenderManager mgr) {
        super(mgr, new ModelHerrerasaurus(), 0.6f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraHerrerasaurus entity) {
        return RenderHerrerasaurus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraHerrerasaurus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraHerrerasaurus entity, float f) {
        float scale = entity.getAgeScale() * this.getScaler();
        if (scale < 0.01f) {scale = 0.01f;}
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.6F;
    }

}