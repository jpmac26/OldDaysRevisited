package com.jpmac26.olddays.entity.enderman;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.jpmac26.olddays.entity.EntityODEnderman;

/**
 * Created by James Pelster on 7/11/2016.
 */
@SideOnly(Side.CLIENT)
public class LayerODEndermanEyes implements LayerRenderer<EntityEnderman>
{
    //private static ResourceLocation RES_ENDERMAN_EYES;
    private final RenderODEnderman endermanRenderer;

    public LayerODEndermanEyes(RenderODEnderman rendererIn)
    {
        this.endermanRenderer = rendererIn;
    }

    public void doRenderLayer(EntityEnderman entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (EntityODEnderman.oldAppearance)
            this.endermanRenderer.bindTexture(new ResourceLocation("olddays:textures/enderman_eyes.png"));
        else
            this.endermanRenderer.bindTexture(new ResourceLocation("textures/entity/enderman/enderman_eyes.png"));

        //this.endermanRenderer.bindTexture(RES_ENDERMAN_EYES);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!entitylivingbaseIn.isInvisible());
        int i = 61680;
        int j = 61680;
        int k = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.endermanRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.endermanRenderer.setLightmap(entitylivingbaseIn, partialTicks);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}
