package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPreparedCopyIngot extends Item{
    public String name = "PreparedCopyIngot";

    public ItemPreparedCopyIngot() {
        setUnlocalizedName(Constants.MODID + "_" + name);
        setCreativeTab(CyansMod.CreativeTab);
        GameRegistry.registerItem(this, name);
        setTextureName(Constants.MODID + ":" + name);
    }
}
