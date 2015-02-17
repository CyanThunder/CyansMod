package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.item.ItemAxe;

public class ItemBlueGreenAxe extends ItemAxe{

    public static String name = "BlueGreenAxe";
    public ItemBlueGreenAxe(ToolMaterial material) {
        super(material);
        setCreativeTab(CyansMod.CreativeTab);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }
}
