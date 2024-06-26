package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAnthracomedusa;
import net.lepidodendron.entity.model.entity.ModelAnthracomedusa;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAnthracomedusa extends RenderLivingBaseWithBook<EntityPrehistoricFloraAnthracomedusa> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/anthracomedusa.png");

    public RenderAnthracomedusa(RenderManager mgr) {
        super(mgr, new ModelAnthracomedusa(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAnthracomedusa entity) {
        return RenderAnthracomedusa.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAnthracomedusa entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}