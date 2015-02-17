package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Box {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BoxBlock, 1), new Object[]{
                "OSO",
                "O O",
                "LLL",
                'O', new ItemStack(Blocks.planks, 1, 0),
                'L', new ItemStack(Blocks.log, 1, 0),
                'S', new ItemStack(Blocks.wooden_slab, 1, 0)
        });
    }
}
