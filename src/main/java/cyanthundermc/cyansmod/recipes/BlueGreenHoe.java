package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BlueGreenHoe {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModItems.blueGreenHoe, 1), new Object[]{
                " BB",
                " S ",
                " S ",
                'B', ModItems.blueGreenIngotItem,
                'S', Items.stick
        });
    }
}
