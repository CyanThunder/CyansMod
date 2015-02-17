package cyanthundermc.cyansmod.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.tileentities.TileEntityBox;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map;

public class CommonProxy {

    public void registerTileEntities() {

        GameRegistry.registerTileEntity(TileEntityBox.class, TileEntityBox.publicName);
    }

    private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

    public static void storeEntityData(String name, NBTTagCompound compound)
    {
        extendedEntityData.put(name, compound);
    }

    public static NBTTagCompound getEntityData(String name)
    {
        return extendedEntityData.remove(name);
    }

}
