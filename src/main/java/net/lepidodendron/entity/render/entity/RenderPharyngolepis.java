package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraPharyngolepis;
import net.lepidodendron.entity.model.entity.ModelPharyngolepis;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPharyngolepis extends RenderLivingBaseWithBook<EntityPrehistoricFloraPharyngolepis> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/pharyngolepis.png");
    public static float getScaler() {
        return 0.65F * 0.343F;
    }

    public RenderPharyngolepis(RenderManager mgr) {
        super(mgr, new ModelPharyngolepis(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraPharyngolepis entity) {
        return RenderPharyngolepis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraPharyngolepis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}