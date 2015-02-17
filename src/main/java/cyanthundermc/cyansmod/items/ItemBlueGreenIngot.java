package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import scala.collection.immutable.Stream;

public class ItemBlueGreenIngot extends Item {
    private String name = "BlueGreenIngot";

    public ItemBlueGreenIngot() {
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        setCreativeTab(CyansMod.CreativeTab);
        GameRegistry.registerItem(this, name);
    }
}
