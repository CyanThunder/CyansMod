package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BlueGreenAxe {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModItems.blueGreenAxe, 1), new Object[]{
                " BB",
                " SB",
                " S ",
                'B', ModItems.blueGreenIngotItem,
                'S', Items.stick
        });
    }
}
