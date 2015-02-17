package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class IronIngot {
    public static void registerRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 7), new Object[]{
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Items.coal,
                ModItems.blueGreenIngotItem
        });
        GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 14), new Object[]{
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Blocks.iron_ore,
                Items.coal,
                ModItems.alloyCopyIngot
        });
    }
}
