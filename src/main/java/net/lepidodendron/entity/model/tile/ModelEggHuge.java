package net.lepidodendron.entity.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelEggHuge extends ModelBase {
    private final ModelRenderer root;
    private final ModelRenderer shape1;
    private final ModelRenderer shape2;
    private final ModelRenderer shape3;
    private final ModelRenderer shape4;
    private final ModelRenderer shape1a;
    private final ModelRenderer shape2a;
    private final ModelRenderer shape3a;
    private final ModelRenderer shape4a;
    private final ModelRenderer shape1b;
    private final ModelRenderer shape2b;
    private final ModelRenderer shape3b;
    private final ModelRenderer shape4b;

    public ModelEggHuge() {
        this.textureWidth = 16;
        this.textureHeight = 16;

        this.root = new ModelRenderer(this);
        this.root.setRotationPoint(-1.0F, 0.0F, 1.0F);


        this.shape1 = new ModelRenderer(this);
        this.shape1.setRotationPoint(-0.8F, 24.0F, -4.0F);
        this.root.addChild(shape1);
        this.setRotateAngle(shape1, -0.2731F, -0.2276F, 0.0F);
        this.shape1.cubeList.add(new ModelBox(shape1, 0, 5, -2.0F, -0.5F, -2.0F, 4, 1, 4, 0.0F, false));

        this.shape2 = new ModelRenderer(this);
        this.shape2.setRotationPoint(0.0F, -1.8F, 0.0F);
        this.shape1.addChild(shape2);
        this.shape2.cubeList.add(new ModelBox(shape2, 0, 8, -0.5F, -1.5F, -2.5F, 3, 3, 5, 0.0F, false));
        this.shape2.cubeList.add(new ModelBox(shape2, 1, 3, -2.5F, -1.5F, -2.5F, 2, 3, 5, 0.0F, false));

        this.shape3 = new ModelRenderer(this);
        this.shape3.setRotationPoint(0.0F, -2.1F, 0.0F);
        this.shape2.addChild(shape3);
        this.shape3.cubeList.add(new ModelBox(shape3, 0, 5, -2.0F, -1.0F, -2.0F, 4, 2, 4, 0.0F, false));

        this.shape4 = new ModelRenderer(this);
        this.shape4.setRotationPoint(0.0F, -1.2F, 0.0F);
        this.shape3.addChild(shape4);
        this.shape4.cubeList.add(new ModelBox(shape4, 2, 5, -1.5F, -0.5F, -1.5F, 3, 1, 3, 0.0F, false));

        this.shape1a = new ModelRenderer(this);
        this.shape1a.setRotationPoint(3.2F, 23.8F, 1.1F);
        this.root.addChild(shape1a);
        this.setRotateAngle(shape1a, 0.0F, 0.0F, 0.3187F);
        this.shape1a.cubeList.add(new ModelBox(shape1a, 0, 9, -2.0F, -0.5F, -2.0F, 4, 1, 4, 0.0F, false));

        this.shape2a = new ModelRenderer(this);
        this.shape2a.setRotationPoint(0.0F, -1.8F, 0.0F);
        this.shape1a.addChild(shape2a);
        this.shape2a.cubeList.add(new ModelBox(shape2a, 0, 8, -0.5F, -1.5F, -2.5F, 3, 3, 5, 0.0F, false));
        this.shape2a.cubeList.add(new ModelBox(shape2a, 0, 1, -2.5F, -1.5F, -2.5F, 2, 3, 5, 0.0F, false));

        this.shape3a = new ModelRenderer(this);
        this.shape3a.setRotationPoint(0.0F, -2.1F, 0.0F);
        this.shape2a.addChild(shape3a);
        this.shape3a.cubeList.add(new ModelBox(shape3a, 0, 2, -2.0F, -1.0F, -2.0F, 4, 2, 4, 0.0F, false));

        this.shape4a = new ModelRenderer(this);
        this.shape4a.setRotationPoint(0.0F, -1.2F, 0.0F);
        this.shape3a.addChild(shape4a);
        this.shape4a.cubeList.add(new ModelBox(shape4a, 3, 10, -1.5F, -0.5F, -1.5F, 3, 1, 3, 0.0F, false));

        this.shape1b = new ModelRenderer(this);
        this.shape1b.setRotationPoint(-0.6F, 22.7F, 1.2F);
        this.root.addChild(shape1b);
        this.setRotateAngle(shape1b, -0.182F, 0.2276F, 1.8213F);
        this.shape1b.cubeList.add(new ModelBox(shape1b, 0, 7, -2.0F, -0.5F, -2.0F, 4, 1, 4, 0.0F, false));

        this.shape2b = new ModelRenderer(this);
        this.shape2b.setRotationPoint(0.0F, -1.8F, 0.0F);
        this.shape1b.addChild(shape2b);
        this.shape2b.cubeList.add(new ModelBox(shape2b, 0, 0, -0.5F, -1.5F, -2.5F, 3, 3, 5, 0.0F, false));
        this.shape2b.cubeList.add(new ModelBox(shape2b, 0, 1, -2.5F, -1.5F, -2.5F, 2, 3, 5, 0.0F, false));

        this.shape3b = new ModelRenderer(this);
        this.shape3b.setRotationPoint(0.0F, -2.1F, 0.0F);
        this.shape2b.addChild(shape3b);
        this.shape3b.cubeList.add(new ModelBox(shape3b, 0, 10, -2.0F, -1.0F, -2.0F, 4, 2, 4, 0.0F, false));

        this.shape4b = new ModelRenderer(this);
        this.shape4b.setRotationPoint(0.0F, -1.2F, 0.0F);
        this.shape3b.addChild(shape4b);
        this.shape4b.cubeList.add(new ModelBox(shape4b, 3, 6, -1.5F, -0.5F, -1.5F, 3, 1, 3, 0.0F, false));

    }

    public void renderAll(float f) {
        this.root.render(f);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
