package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemKnife extends Item{

    public String name = "Knife";

    public ItemKnife() {
        super();
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        setCreativeTab(CyansMod.CreativeTab);
        GameRegistry.registerItem(this, name);
        setMaxStackSize(1);
        setMaxDamage(499);
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

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() + 1);
        stack.stackSize = 1;

        return stack;
    }
}
