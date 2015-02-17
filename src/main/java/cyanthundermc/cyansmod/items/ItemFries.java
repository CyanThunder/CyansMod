package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemFries extends ItemFood {
    public String name = "Fries";

    public ItemFries(int heal, float saturation, boolean wolfMeat) {
        super(heal, saturation, wolfMeat);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        setCreativeTab(CyansMod.CreativeTab);
        GameRegistry.registerItem(this, name);
    }
}
