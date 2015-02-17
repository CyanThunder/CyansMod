package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SugarBoots {

    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModItems.sugarBoots, 1), new Object[]{
                "SSS",
                "SBS",
                "SSS",
                'S', ModBlocks.SugarBlock,
                'B', Items.diamond_boots
        });
    }
}
