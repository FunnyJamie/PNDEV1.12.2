package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraMaterpiscis;
import net.lepidodendron.entity.model.entity.ModelMaterpiscis;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMaterpiscis extends RenderLivingBaseWithBook<EntityPrehistoricFloraMaterpiscis> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/materpiscis_male.png");
    public static final ResourceLocation TEXTURE_F = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/materpiscis_female.png");

    public static float getScaler() {
        return 0.7F * 0.24F;
    }
    public RenderMaterpiscis(RenderManager mgr) {
        super(mgr, new ModelMaterpiscis(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraMaterpiscis entity) {
        if (entity.getPNType() == EntityPrehistoricFloraMaterpiscis.Type.FEMALE) {
            return RenderMaterpiscis.TEXTURE_F;
        }
        return RenderMaterpiscis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraMaterpiscis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
    @Override
    protected void preRenderCallback(EntityPrehistoricFloraMaterpiscis entity, float f) {
        float scale = this.getScaler() * entity.getAgeScale();
        if (entity.getPNType() == EntityPrehistoricFloraMaterpiscis.Type.FEMALE) {
            scale = this.getScaler() * 0.75F;
        }
        if (scale < 0.1f) {
            scale = 0.1f;
        }
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = 0;
    }

}