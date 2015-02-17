package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GoldIngot {
    public static void registerRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 7), new Object[]{
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Items.coal,
                ModItems.blueGreenIngotItem
        });
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 14), new Object[]{
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Blocks.gold_ore,
                Items.coal,
                ModItems.alloyCopyIngot
        });
    }
}
