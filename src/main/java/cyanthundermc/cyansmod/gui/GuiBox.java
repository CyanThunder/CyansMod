package cyanthundermc.cyansmod.gui;

import cyanthundermc.cyansmod.inventory.ContainerBox;
import cyanthundermc.cyansmod.lib.Constants;
import cyanthundermc.cyansmod.tileentities.TileEntityBox;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiBox extends GuiContainer{
    private int x, y, z;
    private EntityPlayer player;
    private World world;
    private int xSize, ySize;
    private ResourceLocation backgroundimage = new ResourceLocation(Constants.MODID + ":textures/client/gui/GuiBox.png");

    public GuiBox(EntityPlayer player, TileEntityBox tileEntityBox, World world, int x, int y, int z) {
        super(new ContainerBox(player.inventory, tileEntityBox));
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = player;
        this.world = world;
        xSize = 176;
        ySize = 214;
    }

    /*public GuiBox(EntityPlayer player, World world, int x, int y, int z) {
        super(new ContainerBox(player, world.getTileEntity(x, y, z)));
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = player;
        this.world = world;
        xSize = 176;
        ySize = 214;
    }*/

    /*public void drawScreen(int mouseX, int mouseY, float renderPartialTicks) {
        this.mc.getTextureManager().bindTexture(backgroundimage);
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize,  ySize);
    }*/

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        // new "bind tex"
        this.mc.getTextureManager().bindTexture(backgroundimage);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
