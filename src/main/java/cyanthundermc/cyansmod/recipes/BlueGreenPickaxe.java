package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BlueGreenPickaxe {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModItems.blueGreenPickaxe, 1), new Object[]{
                "BBB",
                " S ",
                " S ",
                'B', ModItems.blueGreenIngotItem,
                'S', Items.stick
        });
    }
}
