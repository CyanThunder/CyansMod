package cyanthundermc.cyansmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.tileentities.TileEntityBox;
import net.minecraft.block.Block;

public final class ModBlocks {

    public static Block BlueGreenDottedOre;
    public static Block CopyOre;
    public static Block BoxBlock;
    public static Block TheGladerz;
    public static Block SugarBlock;
    public static void init(){

        BlueGreenDottedOre = new BlueGreenDottedOre();
        CopyOre = new CopyOre();
        BoxBlock = new BoxBlock();
        TheGladerz = new TheGladerz();
        SugarBlock = new SugarBlock();
    }
}
