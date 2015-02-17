package cyanthundermc.cyansmod.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AntiWither {

    public static void registerRecipes() {
        //Helmet
        GameRegistry.addRecipe(new ItemStack(ModItems.antiWitherHelm, 1), new Object[] {
                "SNS",
                "S S",
                "   ",
                'S', Blocks.soul_sand,
                'N', Items.nether_star
        });
        //Chestplate
        GameRegistry.addRecipe(new ItemStack(ModItems.antiWitherChest, 1), new Object[] {
                "S S",
                "SNS",
                "SSS",
                'S', Blocks.soul_sand,
                'N', Items.nether_star
        });
        //Leggings
        GameRegistry.addRecipe(new ItemStack(ModItems.antiWitherLeggings, 1), new Object[] {
                "SNS",
                "S S",
                "S S",
                'S', Blocks.soul_sand,
                'N', Items.nether_star
        });
        //Boots
        GameRegistry.addRecipe(new ItemStack(ModItems.antiWitherBoots, 1), new Object[] {
                "S S",
                "SNS",
                "   ",
                'S', Blocks.soul_sand,
                'N', Items.nether_star
        });

        //Effect Toggler
        GameRegistry.addRecipe(new ItemStack(ModItems.antiWitherEffectToggler, 1), new Object[] {
                " S ",
                "SRS",
                " S ",
                'S', Blocks.soul_sand,
                'R', Items.redstone
        });
    }
}
