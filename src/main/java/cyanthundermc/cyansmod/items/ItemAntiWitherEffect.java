package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.ExtendedPlayer;
import cyanthundermc.cyansmod.PlayerUtils;
import cyanthundermc.cyansmod.lib.Constants;
import cyanthundermc.cyansmod.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.Random;

public class ItemAntiWitherEffect extends Item {

    public String name = "AntiWitherEffectTool";

    public ItemAntiWitherEffect() {
        setUnlocalizedName(Constants.MODID + "_" + name);
        setCreativeTab(CyansMod.CreativeTab);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote) {
            ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            props.toggleProperty(ExtendedPlayer.PropTypes.AntiWitherEffect);

            ItemStack armorHelm = player.getCurrentArmor(3);
            ItemStack armorChest = player.getCurrentArmor(2);
            ItemStack armorLeggings = player.getCurrentArmor(1);
            ItemStack armorBoots = player.getCurrentArmor(0);
            String mode = "Off";
            EnumChatFormatting modeColor = EnumChatFormatting.RED;
            if (props.getProperty(ExtendedPlayer.PropTypes.AntiWitherEffect)) {
                mode = "On";
                modeColor = EnumChatFormatting.GREEN;
                if (armorHelm == null || armorChest == null || armorLeggings == null || armorBoots == null || armorHelm.getItem() != ModItems.antiWitherHelm || armorChest.getItem() != ModItems.antiWitherChest || armorLeggings.getItem() != ModItems.antiWitherLeggings || armorBoots.getItem() != ModItems.antiWitherBoots) {
                    PlayerUtils.sendChat(player, EnumChatFormatting.DARK_AQUA + "[WARNING] REQUIRES FULL SET OF ANTI-WITHER ARMOR!");
                }
            }
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Anti-Wither Effect Mode: " + modeColor + mode));
        }
        return super.onItemRightClick(stack, world, player);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int l, float f, float f1, float f2) {
        return super.onItemUse(stack, player, world, x, y, z, l, f, f1, f2);
    }
}
