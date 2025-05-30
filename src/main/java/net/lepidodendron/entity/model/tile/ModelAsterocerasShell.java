package net.lepidodendron.entity.model.tile;

import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.lepidodendron.entity.model.llibraryextensions.AdvancedModelBaseExtended;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelAsterocerasShell extends AdvancedModelBaseExtended {
    private final AdvancedModelRenderer Root;
    private final AdvancedModelRenderer Shell1;
    private final AdvancedModelRenderer Shell2;
    private final AdvancedModelRenderer Shell3;
    private final AdvancedModelRenderer Shell4;
    private final AdvancedModelRenderer Shell5;
    private final AdvancedModelRenderer Shell6;
    private final AdvancedModelRenderer Shell7;
    private final AdvancedModelRenderer Shell8;
    private final AdvancedModelRenderer Mantle;
    private final AdvancedModelRenderer Mantle2;
    private final AdvancedModelRenderer leftEye;
    private final AdvancedModelRenderer rightEye;
    private final AdvancedModelRenderer bone;
    private final AdvancedModelRenderer Tentacle1a;
    private final AdvancedModelRenderer Tentacle1b;
    private final AdvancedModelRenderer Tentacle1c;
    private final AdvancedModelRenderer Tentacle2a;
    private final AdvancedModelRenderer Tentacle2b;
    private final AdvancedModelRenderer Tentacle2c;
    private final AdvancedModelRenderer Tentacle3a;
    private final AdvancedModelRenderer Tentacle3b;
    private final AdvancedModelRenderer Tentacle3c;
    private final AdvancedModelRenderer Tentacle4a;
    private final AdvancedModelRenderer Tentacle4b;
    private final AdvancedModelRenderer Tentacle4c;
    private final AdvancedModelRenderer Tentacle5a;
    private final AdvancedModelRenderer Tentacle5b;
    private final AdvancedModelRenderer Tentacle5c;
    private final AdvancedModelRenderer Tentacle6a;
    private final AdvancedModelRenderer Tentacle6b;
    private final AdvancedModelRenderer Tentacle6c;
    private final AdvancedModelRenderer Tentacle7a;
    private final AdvancedModelRenderer Tentacle7b;
    private final AdvancedModelRenderer Tentacle7c;
    private final AdvancedModelRenderer Tentacle8a;
    private final AdvancedModelRenderer Tentacle8b;
    private final AdvancedModelRenderer Tentacle8c;
    private final AdvancedModelRenderer Tentacle9a;
    private final AdvancedModelRenderer Tentacle9b;
    private final AdvancedModelRenderer Tentacle9c;
    private final AdvancedModelRenderer Tentacle10a;
    private final AdvancedModelRenderer Tentacle10b;
    private final AdvancedModelRenderer Tentacle10c;

    public ModelAsterocerasShell() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.Root = new AdvancedModelRenderer(this);
        this.Root.setRotationPoint(1.0F, 12.4479F, -1.5483F);
        this.setRotateAngle(Root, 0.0F, 3.1416F, 0.0F);


        this.Shell1 = new AdvancedModelRenderer(this);
        this.Shell1.setRotationPoint(-1.0F, 5.5521F, -8.7017F);
        this.Root.addChild(Shell1);
        this.setRotateAngle(Shell1, -0.8727F, 0.0F, 0.0F);
        this.Shell1.cubeList.add(new ModelBox(Shell1, 0, 0, -2.0F, -6.0F, 0.0F, 4, 6, 7, 0.0F, false));

        this.Shell2 = new AdvancedModelRenderer(this);
        this.Shell2.setRotationPoint(1.0F, 0.0F, 7.0F);
        this.Shell1.addChild(Shell2);
        this.setRotateAngle(Shell2, 0.7418F, 0.0F, 0.0F);
        this.Shell2.cubeList.add(new ModelBox(Shell2, 0, 13, -3.0F, -5.0F, 0.0F, 4, 5, 7, -0.01F, false));
        this.Shell2.cubeList.add(new ModelBox(Shell2, 15, 18, -1.5F, -13.0F, 1.0F, 1, 8, 7, 0.0F, false));

        this.Shell3 = new AdvancedModelRenderer(this);
        this.Shell3.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Shell2.addChild(Shell3);
        this.setRotateAngle(Shell3, 0.6981F, 0.0F, 0.0F);
        this.Shell3.cubeList.add(new ModelBox(Shell3, 15, 6, -2.5F, -5.0F, 0.0F, 3, 5, 7, 0.04F, false));

        this.Shell4 = new AdvancedModelRenderer(this);
        this.Shell4.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Shell3.addChild(Shell4);
        this.setRotateAngle(Shell4, 0.7854F, 0.0F, 0.0F);
        this.Shell4.cubeList.add(new ModelBox(Shell4, 0, 27, -2.5F, -5.0F, 0.0F, 3, 5, 6, 0.01F, false));

        this.Shell5 = new AdvancedModelRenderer(this);
        this.Shell5.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.Shell4.addChild(Shell5);
        this.setRotateAngle(Shell5, 0.6981F, 0.0F, 0.0F);
        this.Shell5.cubeList.add(new ModelBox(Shell5, 28, 0, -2.5F, -4.0F, 0.0F, 3, 4, 6, 0.0F, false));

        this.Shell6 = new AdvancedModelRenderer(this);
        this.Shell6.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.Shell5.addChild(Shell6);
        this.setRotateAngle(Shell6, 0.7418F, 0.0F, 0.0F);
        this.Shell6.cubeList.add(new ModelBox(Shell6, 12, 33, -2.0F, -4.0F, 0.0F, 2, 4, 6, 0.04F, false));

        this.Shell7 = new AdvancedModelRenderer(this);
        this.Shell7.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.Shell6.addChild(Shell7);
        this.setRotateAngle(Shell7, 0.9163F, 0.0F, 0.0F);
        this.Shell7.cubeList.add(new ModelBox(Shell7, 29, 12, -2.0F, -4.0F, 0.0F, 2, 4, 6, 0.01F, false));

        this.Shell8 = new AdvancedModelRenderer(this);
        this.Shell8.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.Shell7.addChild(Shell8);
        this.setRotateAngle(Shell8, 0.829F, 0.0F, 0.0F);
        this.Shell8.cubeList.add(new ModelBox(Shell8, 24, 26, -2.0F, -3.0F, 0.0F, 2, 3, 7, 0.0F, false));

        this.Mantle = new AdvancedModelRenderer(this);
        this.Mantle.setRotationPoint(-1.0F, 2.5521F, -4.7017F);
        this.Root.addChild(Mantle);
        this.setRotateAngle(Mantle, -0.5236F, 0.0F, 0.0F);
        this.Mantle.cubeList.add(new ModelBox(Mantle, 40, 43, -1.5F, -0.5F, -2.0F, 3, 3, 2, -0.01F, false));

        this.Mantle2 = new AdvancedModelRenderer(this);
        this.Mantle2.setRotationPoint(0.0F, -0.483F, -1.982F);
        this.Mantle.addChild(Mantle2);
        this.setRotateAngle(Mantle2, 0.5236F, 0.0F, 0.0F);
        this.Mantle2.cubeList.add(new ModelBox(Mantle2, 35, 22, -1.5F, 0.0F, -4.0F, 3, 3, 4, 0.0F, false));

        this.leftEye = new AdvancedModelRenderer(this);
        this.leftEye.setRotationPoint(1.3F, 0.75F, -0.825F);
        this.Mantle2.addChild(leftEye);
        this.setRotateAngle(leftEye, 0.0F, 0.0F, -0.2182F);
        this.leftEye.cubeList.add(new ModelBox(leftEye, 13, 43, -1.05F, -1.0F, -1.5F, 2, 2, 3, 0.0F, false));
        this.leftEye.cubeList.add(new ModelBox(leftEye, 23, 0, -0.95F, -0.5F, -1.0F, 2, 1, 2, 0.0F, false));

        this.rightEye = new AdvancedModelRenderer(this);
        this.rightEye.setRotationPoint(-1.3F, 0.75F, -0.825F);
        this.Mantle2.addChild(rightEye);
        this.setRotateAngle(rightEye, 0.0F, 0.0F, 0.2182F);
        this.rightEye.cubeList.add(new ModelBox(rightEye, 13, 43, -0.95F, -1.0F, -1.5F, 2, 2, 3, 0.0F, true));
        this.rightEye.cubeList.add(new ModelBox(rightEye, 23, 0, -1.05F, -0.5F, -1.0F, 2, 1, 2, 0.0F, true));

        this.bone = new AdvancedModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 3.2F, -1.6F);
        this.Mantle2.addChild(bone);
        this.setRotateAngle(bone, 0.1745F, 0.0F, 0.0F);
        this.bone.cubeList.add(new ModelBox(bone, 15, 0, -1.0F, -1.0F, -3.0F, 2, 2, 4, 0.0F, false));

        this.Tentacle1a = new AdvancedModelRenderer(this);
        this.Tentacle1a.setRotationPoint(0.5F, 2.0F, -3.5F);
        this.Mantle2.addChild(Tentacle1a);
        this.setRotateAngle(Tentacle1a, -0.0437F, 0.048F, -0.0021F);
        this.Tentacle1a.cubeList.add(new ModelBox(Tentacle1a, 45, 11, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, false));

        this.Tentacle1b = new AdvancedModelRenderer(this);
        this.Tentacle1b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle1a.addChild(Tentacle1b);
        this.setRotateAngle(Tentacle1b, 0.0F, -0.0175F, 0.0F);
        this.Tentacle1b.cubeList.add(new ModelBox(Tentacle1b, 30, 42, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, false));

        this.Tentacle1c = new AdvancedModelRenderer(this);
        this.Tentacle1c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle1b.addChild(Tentacle1c);
        this.setRotateAngle(Tentacle1c, 0.0F, -0.0262F, 0.0F);
        this.Tentacle1c.cubeList.add(new ModelBox(Tentacle1c, 24, 41, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, false));

        this.Tentacle2a = new AdvancedModelRenderer(this);
        this.Tentacle2a.setRotationPoint(1.0F, 2.0F, -3.5F);
        this.Mantle2.addChild(Tentacle2a);
        this.setRotateAngle(Tentacle2a, 0.0F, 0.0F, 0.7854F);
        this.Tentacle2a.cubeList.add(new ModelBox(Tentacle2a, 45, 6, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, false));

        this.Tentacle2b = new AdvancedModelRenderer(this);
        this.Tentacle2b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle2a.addChild(Tentacle2b);
        this.setRotateAngle(Tentacle2b, -0.0349F, 0.0742F, 0.0F);
        this.Tentacle2b.cubeList.add(new ModelBox(Tentacle2b, 40, 38, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, false));

        this.Tentacle2c = new AdvancedModelRenderer(this);
        this.Tentacle2c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle2b.addChild(Tentacle2c);
        this.setRotateAngle(Tentacle2c, 0.0F, -0.0131F, 0.0F);
        this.Tentacle2c.cubeList.add(new ModelBox(Tentacle2c, 40, 0, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, false));

        this.Tentacle3a = new AdvancedModelRenderer(this);
        this.Tentacle3a.setRotationPoint(1.0F, 1.25F, -3.5F);
        this.Mantle2.addChild(Tentacle3a);
        this.setRotateAngle(Tentacle3a, 0.0F, -0.1265F, 0.0F);
        this.Tentacle3a.cubeList.add(new ModelBox(Tentacle3a, 44, 29, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, false));
        this.Tentacle3a.cubeList.add(new ModelBox(Tentacle3a, 11, 0, 0.5F, 0.0F, -4.0F, 2, 0, 4, 0.0F, false));

        this.Tentacle3b = new AdvancedModelRenderer(this);
        this.Tentacle3b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle3a.addChild(Tentacle3b);
        this.setRotateAngle(Tentacle3b, 0.0175F, 0.1134F, 0.0F);
        this.Tentacle3b.cubeList.add(new ModelBox(Tentacle3b, 39, 10, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, false));
        this.Tentacle3b.cubeList.add(new ModelBox(Tentacle3b, 0, 13, 0.5F, 0.0F, -4.0F, 1, 0, 4, 0.0F, false));

        this.Tentacle3c = new AdvancedModelRenderer(this);
        this.Tentacle3c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle3b.addChild(Tentacle3c);
        this.setRotateAngle(Tentacle3c, -0.0175F, 0.1047F, 0.0F);
        this.Tentacle3c.cubeList.add(new ModelBox(Tentacle3c, 6, 39, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, false));
        this.Tentacle3c.cubeList.add(new ModelBox(Tentacle3c, 0, 0, 0.0F, 0.0F, -4.0F, 1, 0, 4, 0.0F, false));

        this.Tentacle4a = new AdvancedModelRenderer(this);
        this.Tentacle4a.setRotationPoint(1.0F, 0.5F, -3.5F);
        this.Mantle2.addChild(Tentacle4a);
        this.setRotateAngle(Tentacle4a, 0.0611F, 0.0F, 0.7854F);
        this.Tentacle4a.cubeList.add(new ModelBox(Tentacle4a, 6, 44, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, false));

        this.Tentacle4b = new AdvancedModelRenderer(this);
        this.Tentacle4b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle4a.addChild(Tentacle4b);
        this.setRotateAngle(Tentacle4b, -0.0218F, -0.0567F, -0.0005F);
        this.Tentacle4b.cubeList.add(new ModelBox(Tentacle4b, 38, 32, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, false));

        this.Tentacle4c = new AdvancedModelRenderer(this);
        this.Tentacle4c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle4b.addChild(Tentacle4c);
        this.setRotateAngle(Tentacle4c, 0.0305F, 0.0F, 0.0F);
        this.Tentacle4c.cubeList.add(new ModelBox(Tentacle4c, 0, 38, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, false));

        this.Tentacle5a = new AdvancedModelRenderer(this);
        this.Tentacle5a.setRotationPoint(0.5F, 0.5F, -3.5F);
        this.Mantle2.addChild(Tentacle5a);
        this.setRotateAngle(Tentacle5a, 0.035F, 0.0611F, 0.0019F);
        this.Tentacle5a.cubeList.add(new ModelBox(Tentacle5a, 0, 43, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, false));

        this.Tentacle5b = new AdvancedModelRenderer(this);
        this.Tentacle5b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle5a.addChild(Tentacle5b);
        this.setRotateAngle(Tentacle5b, 0.048F, -0.0218F, -0.001F);
        this.Tentacle5b.cubeList.add(new ModelBox(Tentacle5b, 34, 37, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, false));

        this.Tentacle5c = new AdvancedModelRenderer(this);
        this.Tentacle5c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle5b.addChild(Tentacle5c);
        this.setRotateAngle(Tentacle5c, 0.0306F, -0.0393F, -0.0012F);
        this.Tentacle5c.cubeList.add(new ModelBox(Tentacle5c, 28, 36, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, false));

        this.Tentacle6a = new AdvancedModelRenderer(this);
        this.Tentacle6a.setRotationPoint(-0.5F, 2.0F, -3.5F);
        this.Mantle2.addChild(Tentacle6a);
        this.setRotateAngle(Tentacle6a, -0.048F, -0.048F, 0.0021F);
        this.Tentacle6a.cubeList.add(new ModelBox(Tentacle6a, 45, 11, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, true));

        this.Tentacle6b = new AdvancedModelRenderer(this);
        this.Tentacle6b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle6a.addChild(Tentacle6b);
        this.setRotateAngle(Tentacle6b, 0.0F, 0.0175F, 0.0F);
        this.Tentacle6b.cubeList.add(new ModelBox(Tentacle6b, 30, 42, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, true));

        this.Tentacle6c = new AdvancedModelRenderer(this);
        this.Tentacle6c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle6b.addChild(Tentacle6c);
        this.setRotateAngle(Tentacle6c, 0.0F, 0.0262F, 0.0F);
        this.Tentacle6c.cubeList.add(new ModelBox(Tentacle6c, 24, 41, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, true));

        this.Tentacle7a = new AdvancedModelRenderer(this);
        this.Tentacle7a.setRotationPoint(-1.0F, 2.0F, -3.5F);
        this.Mantle2.addChild(Tentacle7a);
        this.setRotateAngle(Tentacle7a, 0.0F, 0.0F, -0.7854F);
        this.Tentacle7a.cubeList.add(new ModelBox(Tentacle7a, 45, 6, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, true));

        this.Tentacle7b = new AdvancedModelRenderer(this);
        this.Tentacle7b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle7a.addChild(Tentacle7b);
        this.setRotateAngle(Tentacle7b, -0.0349F, -0.0742F, 0.0F);
        this.Tentacle7b.cubeList.add(new ModelBox(Tentacle7b, 40, 38, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, true));

        this.Tentacle7c = new AdvancedModelRenderer(this);
        this.Tentacle7c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle7b.addChild(Tentacle7c);
        this.setRotateAngle(Tentacle7c, 0.0F, 0.0131F, 0.0F);
        this.Tentacle7c.cubeList.add(new ModelBox(Tentacle7c, 40, 0, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, true));

        this.Tentacle8a = new AdvancedModelRenderer(this);
        this.Tentacle8a.setRotationPoint(-1.0F, 1.25F, -3.5F);
        this.Mantle2.addChild(Tentacle8a);
        this.setRotateAngle(Tentacle8a, 0.0F, 0.1265F, 0.0F);
        this.Tentacle8a.cubeList.add(new ModelBox(Tentacle8a, 44, 29, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, true));
        this.Tentacle8a.cubeList.add(new ModelBox(Tentacle8a, 11, 0, -2.5F, 0.0F, -4.0F, 2, 0, 4, 0.0F, true));

        this.Tentacle8b = new AdvancedModelRenderer(this);
        this.Tentacle8b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle8a.addChild(Tentacle8b);
        this.setRotateAngle(Tentacle8b, 0.0175F, -0.1134F, 0.0F);
        this.Tentacle8b.cubeList.add(new ModelBox(Tentacle8b, 39, 10, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, true));
        this.Tentacle8b.cubeList.add(new ModelBox(Tentacle8b, 0, 13, -1.5F, 0.0F, -4.0F, 1, 0, 4, 0.0F, true));

        this.Tentacle8c = new AdvancedModelRenderer(this);
        this.Tentacle8c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle8b.addChild(Tentacle8c);
        this.setRotateAngle(Tentacle8c, -0.0175F, -0.1047F, 0.0F);
        this.Tentacle8c.cubeList.add(new ModelBox(Tentacle8c, 6, 39, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, true));
        this.Tentacle8c.cubeList.add(new ModelBox(Tentacle8c, 0, 0, -1.0F, 0.0F, -4.0F, 1, 0, 4, 0.0F, true));

        this.Tentacle9a = new AdvancedModelRenderer(this);
        this.Tentacle9a.setRotationPoint(-1.0F, 0.5F, -3.5F);
        this.Mantle2.addChild(Tentacle9a);
        this.setRotateAngle(Tentacle9a, 0.0611F, 0.0F, -0.7854F);
        this.Tentacle9a.cubeList.add(new ModelBox(Tentacle9a, 6, 44, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, true));

        this.Tentacle9b = new AdvancedModelRenderer(this);
        this.Tentacle9b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle9a.addChild(Tentacle9b);
        this.setRotateAngle(Tentacle9b, -0.0218F, 0.0567F, 0.0005F);
        this.Tentacle9b.cubeList.add(new ModelBox(Tentacle9b, 38, 32, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, true));

        this.Tentacle9c = new AdvancedModelRenderer(this);
        this.Tentacle9c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle9b.addChild(Tentacle9c);
        this.setRotateAngle(Tentacle9c, 0.0305F, 0.0F, 0.0F);
        this.Tentacle9c.cubeList.add(new ModelBox(Tentacle9c, 0, 38, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, true));

        this.Tentacle10a = new AdvancedModelRenderer(this);
        this.Tentacle10a.setRotationPoint(-0.5F, 0.5F, -3.5F);
        this.Mantle2.addChild(Tentacle10a);
        this.setRotateAngle(Tentacle10a, 0.0306F, -0.0611F, -0.0019F);
        this.Tentacle10a.cubeList.add(new ModelBox(Tentacle10a, 0, 43, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.01F, true));

        this.Tentacle10b = new AdvancedModelRenderer(this);
        this.Tentacle10b.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle10a.addChild(Tentacle10b);
        this.setRotateAngle(Tentacle10b, 0.048F, 0.0218F, 0.001F);
        this.Tentacle10b.cubeList.add(new ModelBox(Tentacle10b, 34, 37, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.02F, true));

        this.Tentacle10c = new AdvancedModelRenderer(this);
        this.Tentacle10c.setRotationPoint(0.0F, 0.0F, -3.5F);
        this.Tentacle10b.addChild(Tentacle10c);
        this.setRotateAngle(Tentacle10c, 0.0306F, 0.0393F, 0.0012F);
        this.Tentacle10c.cubeList.add(new ModelBox(Tentacle10c, 28, 36, -0.5F, -0.5F, -4.0F, 1, 1, 4, -0.04F, true));
        updateDefaultPose();
    }

    public void renderAll(float f) {
        this.resetToDefaultPose();
        this.Root.offsetY = -1F;
        this.Root.render(0.08f);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
