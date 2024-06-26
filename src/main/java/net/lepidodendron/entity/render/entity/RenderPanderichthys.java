package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraPanderichthys;
import net.lepidodendron.entity.model.entity.ModelPanderichthys;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPanderichthys extends RenderLivingBaseWithBook<EntityPrehistoricFloraPanderichthys> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/panderichthys.png");
    public static float getScaler() {
        return 0.5F;
    }

    public RenderPanderichthys(RenderManager mgr) {
        super(mgr, new ModelPanderichthys(), 0.12f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraPanderichthys entity) {
        return RenderPanderichthys.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraPanderichthys entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}