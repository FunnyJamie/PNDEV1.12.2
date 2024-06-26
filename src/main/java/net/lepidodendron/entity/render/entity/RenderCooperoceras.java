package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraCooperoceras;
import net.lepidodendron.entity.model.entity.ModelCooperoceras;
import net.lepidodendron.entity.render.RenderLivingBaseWithBook;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCooperoceras extends RenderLivingBaseWithBook<EntityPrehistoricFloraCooperoceras> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/cooperoceras.png");
    public static float getScaler() {
        return 0.082F;
    }
    public RenderCooperoceras(RenderManager mgr) {
        super(mgr, new ModelCooperoceras(), 0.1f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraCooperoceras entity) {
        return RenderCooperoceras.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraCooperoceras entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}