package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.item.ItemPickaxe;

public class ItemBlueGreenPickaxe extends ItemPickaxe{

    private String name = "BlueGreenPickaxe";
    public ItemBlueGreenPickaxe(ToolMaterial material) {
        super(material);
        setCreativeTab(CyansMod.CreativeTab);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }
}
