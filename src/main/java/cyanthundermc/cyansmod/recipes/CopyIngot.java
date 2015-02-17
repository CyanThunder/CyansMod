package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import cyanthundermc.cyansmod.items.AlloyCopyIngot;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.item.ItemStack;

public class CopyIngot {
    public static void registerRecipes() {
        //Unprepared Copy Ingot
        GameRegistry.addSmelting(
                ModBlocks.CopyOre,
                new ItemStack(ModItems.unpreparedCopyIngot, 1),
                1
        );
        //Prepared Copy Ingot
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.preparedCopyIngot), new Object[]{
                    ModItems.unpreparedCopyIngot,
                    ModItems.blueGreenIngotItem
        });
        //Alloy Copy Ingot
        GameRegistry.addSmelting(
                ModItems.preparedCopyIngot,
                new ItemStack(ModItems.alloyCopyIngot, 1),
                1
        );
    }
}
