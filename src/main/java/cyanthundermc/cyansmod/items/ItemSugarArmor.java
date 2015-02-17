package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;

import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.lib.Constants;
import cyanthundermc.cyansmod.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

import java.util.Random;

public class ItemSugarArmor extends ItemArmor{

    public ItemSugarArmor(ArmorMaterial material, int armorType, String name) {
        super(material, 0, armorType);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setCreativeTab(CyansMod.CreativeTab);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }

    int tick;
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        tick++;
        if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() == ModItems.sugarBoots) {
            ItemStack boots = player.getCurrentArmor(0);
            /*  Now done in Mod's EventHandler @ CyansModEventHandler

                if (boots.getItem() == ModItems.sugarBoots) {
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 3, Reference.sugarBootSpeedValue - 1));
            }*/
            //If ENABLED make SugarBoots slowly lose durability every (DEFAULT:) 1200 Ticks (actual time may vary)
            if (tick == Reference.sugarBootDOTTime && Reference.sugarBootDOT) {
                boots.setItemDamage(boots.getItemDamage() + 1);
                tick = 0;
            }
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == ModItems.sugarBoots) {
            return Constants.MODID + ":textures/models/armor/sugar_layer_1.png";
        }
        else {
            System.out.println("Invalid Item ItemSugarArmor");
            return null;
        }
    }
}
