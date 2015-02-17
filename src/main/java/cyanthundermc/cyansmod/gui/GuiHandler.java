package cyanthundermc.cyansmod.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cyanthundermc.cyansmod.blocks.BoxBlock;
import cyanthundermc.cyansmod.inventory.ContainerBox;
import cyanthundermc.cyansmod.tileentities.TileEntityBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityBox){
            return new ContainerBox(player.inventory, (TileEntityBox) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityBox){
            return new GuiBox(player, (TileEntityBox) tileEntity, world, x, y, z);
        }
        return null;
    }

}
