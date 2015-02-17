package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.CyansMod;

import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.item.Item;

public class AlloyCopyIngot extends Item{
    public String name = "AlloyCopyIngot";

    public AlloyCopyIngot() {
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + "AlloyCopyIngot");
        setCreativeTab(CyansMod.CreativeTab);
        GameRegistry.registerItem(this, name);
    }
}
