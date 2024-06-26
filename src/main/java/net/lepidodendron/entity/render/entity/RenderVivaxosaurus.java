package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraVivaxosaurus;
import net.lepidodendron.entity.model.entity.ModelVivaxosaurus;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVivaxosaurus extends RenderLivingBaseWithBook<EntityPrehistoricFloraVivaxosaurus> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/vivaxosaurus.png");
    public static float getScaler() {
        return 0.63f;
    }

    public RenderVivaxosaurus(RenderManager mgr) {
        super(mgr, new ModelVivaxosaurus(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraVivaxosaurus entity) {
        return RenderVivaxosaurus.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraVivaxosaurus entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPrehistoricFloraVivaxosaurus entity, float f) {
        float scale = entity.getAgeScale() * this.getScaler();
        GlStateManager.scale(scale, scale, scale);
        this.shadowSize = entity.width * scale * 0.30F;
    }

}