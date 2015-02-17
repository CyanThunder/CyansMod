package cyanthundermc.cyansmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CopyOre extends Block {
    public String name = "CopyOre";
    public CopyOre() {
        super(Material.rock);
        setCreativeTab(CyansMod.CreativeTab);
        setBlockName(Constants.MODID + "_" + name);
        GameRegistry.registerBlock(this, name);
        setBlockTextureName(Constants.MODID + ":" + name);
        setHardness(3F);
        setResistance(15);
        setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
