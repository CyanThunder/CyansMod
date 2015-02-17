package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.PlayerUtils;
import cyanthundermc.cyansmod.lib.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDebugTool extends Item {
    private String name = "ItemDebugTool";

    public ItemDebugTool() {
        setUnlocalizedName(Constants.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (world.isRemote) {
        }
        return super.onItemRightClick(itemStack, world, player);
    }
}
