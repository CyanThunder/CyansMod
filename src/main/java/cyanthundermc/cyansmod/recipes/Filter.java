package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Filter {
    public static void registerRecipes() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemFilter, 1), new Object[]{
                "T T",
                "TST",
                "T T",
                'T', Blocks.stone,
                'S', Items.string
        });
    }
}
