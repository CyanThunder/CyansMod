package cyanthundermc.cyansmod.eventhandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cyanthundermc.cyansmod.ExtendedPlayer;
import cyanthundermc.cyansmod.PlayerUtils;
import cyanthundermc.cyansmod.items.ModItems;
import cyanthundermc.cyansmod.proxy.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.Random;

public class CyansModEventHandler {

    public static CommonProxy proxy;

    @SubscribeEvent
    public void onEntityContructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
            ExtendedPlayer.register((EntityPlayer) event.entity);
        }
    }

    @SubscribeEvent
    public void onLivingDeathEvent(LivingDeathEvent event) {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
        {
            ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
        }
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event)
    {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
            ExtendedPlayer.loadProxyData((EntityPlayer) event.entity);
        }
    }

    //region onLivingEventUpdate(LivingEvent.LivingUpdateEvent event)
    @SubscribeEvent
    public void onLivingEventUpdate(LivingEvent.LivingUpdateEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            //Register "player" variable
            EntityPlayer player = (EntityPlayer) event.entity;

            //Get Items in Inventory
            //Armor
            ItemStack armorBoots = player.getCurrentArmor(0);

            //Is the player wearing boots?
            if (armorBoots != null) {
                //region Wearing SugarBoots
                /*Is player wearing SugarBoots?*/
                if (armorBoots.getItem() == ModItems.sugarBoots) {
                    //OLD
                    //player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 3, Reference.sugarBootSpeedValue - 1));
                    //Sets Player Walking Speed to 0.25F (Defualt is 0.1F)
                    player.capabilities.setPlayerWalkSpeed(0.25F);
                    //Makes player able to step up 1 high blocks
                    player.stepHeight = 1F;
                    //Removes some fall damage when falling
                    if (player.fallDistance > 0.25)
                        player.fallDistance -= 0.25;
                }
                else {
                    player.capabilities.setPlayerWalkSpeed(0.1F);
                    player.stepHeight = 0.5F;
                }
                //endregion
            }
            //If not set player with regular settings
            else {
                //region Set Default Settings
                player.capabilities.setPlayerWalkSpeed(0.1F);
                player.stepHeight = 0.5F;
                //endregion
            }
        }
    }
    //endregion

    //region onLivingJumpEvent(LivingEvent.LivingJumpEvent event)
    @SubscribeEvent
    //If Entity Jumps run this
    public void onLivingJumpEvent(LivingEvent.LivingJumpEvent event) {
        //Checks to see if event.entity is a player
        if (event.entity instanceof EntityPlayer) {
            //Creates a "player" variable
            EntityPlayer player = (EntityPlayer) event.entity;

            //Gets Current Worn Boots
            ItemStack armorBoots = player.getCurrentArmor(0);

            //Is player wearing boots?
            if (armorBoots != null) {
                //Is player wearing Sugar Boots?
                if (armorBoots.getItem() == ModItems.sugarBoots) {
                    //Make player jump Higher
                    player.motionY += 0.2D;
                }
            }
        }
    }
    //endregion

    //region onPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event)
    @SubscribeEvent
    public void onPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event)
    {
        EntityPlayer player = (EntityPlayer) event.player;
        PlayerUtils.sendChat(player, EnumChatFormatting.DARK_GREEN + "[Cyan's Mod] " + randomMsg().replace("%PLAYERNAME%", player.getDisplayName()));
    }
    //endregion

    //region onLivingAttackEvent(LivingAttackEvent event)
    @SubscribeEvent
    public void onLivingAttackEvent(LivingAttackEvent event)
    {
        Entity attacker = event.source.getSourceOfDamage();
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            ItemStack armorHelm = player.getCurrentArmor(3);
            ItemStack armorChest = player.getCurrentArmor(2);
            ItemStack armorLeggings = player.getCurrentArmor(1);
            ItemStack armorBoots = player.getCurrentArmor(0);
            if (attacker instanceof EntityWither || attacker instanceof EntityWitherSkull) {
                float damageReduction = 0F;
                if (armorHelm != null && armorHelm.getItem() == ModItems.antiWitherHelm)
                    damageReduction += 15F;
                if (armorChest != null && armorChest.getItem() == ModItems.antiWitherChest)
                    damageReduction += 40F;
                if (armorLeggings != null && armorLeggings.getItem() == ModItems.antiWitherLeggings)
                    damageReduction += 30F;
                if (armorBoots != null && armorBoots.getItem() == ModItems.antiWitherBoots)
                    damageReduction += 15F;
                /*float finalDamage = event.ammount - event.ammount * (damageReduction / 100F);
                if (attacker instanceof EntityWither || attacker instanceof EntityWitherSkull)
                    player.attackEntityFrom(DamageSource.wither, finalDamage);*/
                if (damageReduction == 100F) {
                    attacker.attackEntityFrom(DamageSource.causeThornsDamage(player), event.ammount * 0.75F);
                }
            }
        }
    }
    //endregion

    //region randomMsg()
    public String randomMsg()
    {
        Random rand = new Random();

        //List of Random Messages to use
        String[] messages = {"Hello %PLAYERNAME%!",
                "Hey %PLAYERNAME%, how are you?",
                "BOO! Did I scare you!? No? :(",
                "BEHIND YOU! CREEPERRRR! *BOOM*",
                "Bring it on!",
                "Created by: CyanThunderMC!",
                "%PLAYERNAME%, YOUR AWESOME!",
                "Check out CyanThunderMC.weebly.com!"
        };

        //Randomly Chooses a Number depending on the how many messages are in the string[] messages
        int randNum = rand.nextInt(messages.length);

        //Returns a random chosen message
        return messages[randNum];
    }
    //endregion
}
