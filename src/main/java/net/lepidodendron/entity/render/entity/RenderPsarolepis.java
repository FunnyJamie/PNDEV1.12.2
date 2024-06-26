package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraPsarolepis;
import net.lepidodendron.entity.model.entity.ModelPsarolepis;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPsarolepis extends RenderLivingBaseWithBook<EntityPrehistoricFloraPsarolepis> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/psarolepis.png");
    public static float getScaler() {
        return 0.189f;
    }
    public RenderPsarolepis(RenderManager mgr) {
        super(mgr, new ModelPsarolepis(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraPsarolepis entity) {
        return RenderPsarolepis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraPsarolepis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}