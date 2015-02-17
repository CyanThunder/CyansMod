package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.item.ItemHoe;

public class ItemBlueGreenHoe extends ItemHoe{

    public static String name = "BlueGreenHoe";
    public ItemBlueGreenHoe(ToolMaterial material) {
        super(material);
        setCreativeTab(CyansMod.CreativeTab);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }
}
