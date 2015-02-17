package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemUnpreparedCopyIngot extends Item {
    private String name = "UnpreparedCopyIngot";

    public ItemUnpreparedCopyIngot() {
        setUnlocalizedName(Constants.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(CyansMod.CreativeTab);
        setTextureName(Constants.MODID + ":" + name);
    }

}
