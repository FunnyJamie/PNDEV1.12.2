package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraPostosuchus;
import net.lepidodendron.entity.model.entity.ModelPostosuchus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPostosuchus extends RenderLivingBaseWithBook<EntityPrehistoricFloraPostosuchus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/postosuchus.png");

    public static float getScaler() {return 0.67F; }

    public RenderPostosuchus(RenderManager mgr) {
        super(mgr, new ModelPostosuchus(), 0.6f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraPostosuchus entity) {
        return RenderPostosuchus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraPostosuchus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        if (entityLiving.getAnimation() == entityLiving.DRINK_ANIMATION) {
             //rotationYaw = -180;
               int l = 0;
        }
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraPostosuchus entity, float f) {
        float scale = entity.getAgeScale() * this.getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.6F;
    }

}