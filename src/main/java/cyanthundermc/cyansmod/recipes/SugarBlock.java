package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SugarBlock {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.SugarBlock, 1), new Object[]{
                "SSS",
                "SSS",
                "SSS",
                'S', Items.sugar
        });
    }
}
