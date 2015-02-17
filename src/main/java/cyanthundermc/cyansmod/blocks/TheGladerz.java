package cyanthundermc.cyansmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.CyansMod;

import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TheGladerz extends Block{
    //Block and Texture Made by xXHedwigXx, (xXHedwigXx - Friend)
    public String name = "TheGladerz";
    public TheGladerz() {
        super(Material.rock);
        setBlockName(Constants.MODID + "_" + name);
        setCreativeTab(CyansMod.CreativeTab);
        GameRegistry.registerBlock(this, name);
        setBlockTextureName(Constants.MODID + ":" + name);
        setHardness(20F);
        setResistance(6000F);
        setHarvestLevel("pickaxe", 2);
    }
}
