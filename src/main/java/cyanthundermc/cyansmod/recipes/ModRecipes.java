package cyanthundermc.cyansmod.recipes;

import com.jcraft.jorbis.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void init() {
        IronIngot.registerRecipes();
        BlueGreenIngot.registerRecipes();
        CopyIngot.registerRecipes();
        GoldIngot.registerRecipes();
        Box.registerRecipes();
        TheGladerz.registerRecipes();
        Knife.registerRecipes();
        Fries.registerRecipes();
        Filter.registerRecipes();
        Salt.registerRecipes();
        BlueGreenSword.registerRecipes();
        BlueGreenPickaxe.registerRecipes();
        BlueGreenAxe.registerRecipes();
        BlueGreenShovel.registerRecipes();
        BlueGreenHoe.registerRecipes();
        SugarBlock.registerRecipes();
        SugarBoots.registerRecipes();
        AntiWither.registerRecipes();
    }
}
