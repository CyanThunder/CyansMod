package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.item.ItemStack;

public class BlueGreenIngot {
    public static void registerRecipes() {
        GameRegistry.addSmelting(ModBlocks.BlueGreenDottedOre, new ItemStack(ModItems.blueGreenIngotItem, 1), 1);
    }
}
