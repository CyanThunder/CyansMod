package cyanthundermc.cyansmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SugarBlock extends Block {
    public static String name = "SugarBlock";
    public SugarBlock() {
        super(Material.sand);
        setCreativeTab(CyansMod.CreativeTab);
        setBlockTextureName(Constants.MODID + ":" + name);
        setHardness(0.5F);
        setResistance(2.5F);
        setBlockName(Constants.MODID + "_" + name);
        GameRegistry.registerBlock(this, name);
    }
}
