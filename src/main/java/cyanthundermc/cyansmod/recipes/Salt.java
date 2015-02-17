package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Salt {

    public static void registerRecipes()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemSalt, 1), new Object[]{
                new ItemStack(ModItems.itemFilter, 1, OreDictionary.WILDCARD_VALUE),
                Items.water_bucket
        });
    }
}
