package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
//Recipe chosen by xXHedwigXx
public class TheGladerz {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.TheGladerz, 1), new Object[]{
                "IOI",
                "DCD",
                "IOI",
                'I', Blocks.ice,
                'O', Blocks.obsidian,
                'D', Blocks.dirt,
                'C', Items.cake
        });
    }
}
