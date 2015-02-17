package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Fries {
    public static void registerRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemFries, 2), new Object[]{
                new ItemStack(ModItems.itemKnife, 1, OreDictionary.WILDCARD_VALUE),
                ModItems.itemSalt,
                Items.potato
        });
    }
}
