package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraPelurgaspis;
import net.lepidodendron.entity.model.entity.ModelPelurgaspis;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPelurgaspis extends RenderLivingBaseWithBook<EntityPrehistoricFloraPelurgaspis> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/pelurgaspis.png");
    public static float getScaler() {
        return 0.4F;
    }

    public RenderPelurgaspis(RenderManager mgr) {
        super(mgr, new ModelPelurgaspis(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraPelurgaspis entity) {
        return RenderPelurgaspis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraPelurgaspis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}