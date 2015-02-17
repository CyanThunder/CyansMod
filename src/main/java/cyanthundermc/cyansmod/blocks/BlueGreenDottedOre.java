package cyanthundermc.cyansmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

public class BlueGreenDottedOre extends Block {

    IIcon icons[] = new IIcon[6];
    public String name = "BlueGreenDottedOre";
    public BlueGreenDottedOre(){
        super(Material.rock);
        setBlockName(Constants.MODID + "_" + name);
        setCreativeTab(CyansMod.CreativeTab);
        setBlockTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerBlock(this, name);
        setHardness(3F);
        setResistance(15F);
        setHarvestLevel("pickaxe", 1);
    }
}
