package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemFilter extends Item{
    public String name = "Filter";

    public ItemFilter()
    {
        setUnlocalizedName(Constants.MODID + "_" + name);
        setCreativeTab(CyansMod.CreativeTab);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
        setMaxStackSize(1);
        setMaxDamage(999);
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return false;
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    private boolean loseDamage;
    private int damageChance;
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        {
            Random rand = new Random();
            damageChance = rand.nextInt(2) + 1;
            loseDamage = damageChance == 2;
        }
        if (loseDamage) {
            stack.setItemDamage(stack.getItemDamage() + 1);
        }
        stack.stackSize = 1;
        return stack;
    }
}
