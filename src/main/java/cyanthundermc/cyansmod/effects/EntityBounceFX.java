package cyanthundermc.cyansmod.effects;

import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import static org.lwjgl.opengl.GL11.*;

public class EntityBounceFX extends EntityFX {

    public static final ResourceLocation texture = new ResourceLocation(Constants.MODID, "textures/particles/ParticleBounce.png");

    public EntityBounceFX(World world, double posX, double posY, double posZ) {
        super(world, posX, posY, posZ);
        setGravity(-0.01F);
    }

    public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6, float par7) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        glDepthMask(false);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glAlphaFunc(GL_GREATER, 0.003921569F);
        tess.startDrawingQuads();
        tess.setBrightness(getBrightnessForRender(partialTicks));
        float scale = 0.1F*particleScale;
        float x = (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
        float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
        float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
        tess.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 0);
        tess.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 0);
        tess.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z + par5 * scale + par7 * scale, 1, 1);
        tess.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z + par5 * scale - par7 * scale, 0, 1);
        tess.draw();
        glDisable(GL_BLEND);
        glDepthMask(true);
        glAlphaFunc(GL_GREATER, 0.1F);
    }

    public int getFXLayer() {
        return 3;
    }

    public EntityBounceFX setMaxAge(int maxAge) {
        particleMaxAge = maxAge;
        return this;
    }

    public EntityBounceFX setGravity(float gravity) {
        particleGravity = gravity;
        return this;
    }

    public EntityBounceFX setScale(float scale) {
        particleScale = scale;
        return this;
    }
}
