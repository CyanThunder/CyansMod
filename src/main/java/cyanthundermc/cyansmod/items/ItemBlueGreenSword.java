package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemBlueGreenSword extends ItemSword{

    public static String name = "BlueGreenSword";
    public ItemBlueGreenSword(ToolMaterial material) {
        super(material);
        setCreativeTab(CyansMod.CreativeTab);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }
}
