package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.item.Item;

public class ItemSalt extends Item {

    public String name = "Salt";

    public ItemSalt()
    {
        setUnlocalizedName(Constants.MODID + "_" + name);
        setCreativeTab(CyansMod.CreativeTab);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }
}
