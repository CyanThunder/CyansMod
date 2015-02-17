package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Knife {
    public static void registerRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.itemKnife, 1), new Object[] {
                "  I",
                " I ",
                "S  ",
                'I', Items.iron_ingot,
                'S', Items.stick
        });
        GameRegistry.addRecipe(new ItemStack(ModItems.itemKnife, 1), new Object[]{
                "I  ",
                " I ",
                "  S",
                'I', Items.iron_ingot,
                'S', Items.stick
        });
    }
}
