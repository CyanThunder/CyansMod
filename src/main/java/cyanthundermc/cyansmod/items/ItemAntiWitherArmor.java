package cyanthundermc.cyansmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cyanthundermc.cyansmod.CyansMod;
import cyanthundermc.cyansmod.ExtendedPlayer;
import cyanthundermc.cyansmod.PacketHandler;
import cyanthundermc.cyansmod.effects.EntityBounceFX;
import cyanthundermc.cyansmod.lib.Constants;
import cyanthundermc.cyansmod.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.Random;

public class ItemAntiWitherArmor extends ItemArmor implements ISpecialArmor{

    public double reductionValue;

    public ItemAntiWitherArmor(ArmorMaterial material, int armorType, String name) {
        super(material, 0, armorType);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        setCreativeTab(CyansMod.CreativeTab);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List nbt, boolean par4) {
        ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
        nbt.add("Protective!");
        if (stack == player.getCurrentArmor(0) || stack == player.getCurrentArmor(1) || stack == player.getCurrentArmor(2) || stack == player.getCurrentArmor(3)) {
            if (props.getProperty("AntiWitherEffect")) {
                nbt.add("Anti-Wither Effect is On!");
            } else {
                nbt.add("Anti-Wither Effect is Off!");
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
                nbt.add("");
                nbt.add("Armor Properties: ");
                if (props.getProperty(ExtendedPlayer.PropTypes.AntiWitherEffect))
                    nbt.add("Withering Effect Heals You");
                nbt.add("Lowers Damage From Wither");
            } else {
                nbt.add("");
                nbt.add("Hold SHIFT to see more info...");
            }
        }
    }

    int tick = 0;
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        tick++;
        ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
        ItemStack armorHelm = player.getCurrentArmor(3);
        ItemStack armorChest = player.getCurrentArmor(2);
        ItemStack armorLeggings = player.getCurrentArmor(1);
        ItemStack armorBoots = player.getCurrentArmor(0);
        if (armorHelm != null && armorChest != null && armorLeggings != null && armorBoots != null) {
            if (armorHelm.getItem() == ModItems.antiWitherHelm && armorChest.getItem() == ModItems.antiWitherChest && armorLeggings.getItem() == ModItems.antiWitherLeggings && armorBoots.getItem() == ModItems.antiWitherBoots) {
                if (props.getProperty(ExtendedPlayer.PropTypes.AntiWitherEffect)) {
                    if (player.isPotionActive(Potion.wither) && !player.capabilities.isCreativeMode) {
                        player.removePotionEffect(Potion.wither.getId());
                        int armorDmg = (int)Math.round(world.difficultySetting.getDifficultyId() * 8);
                        armorHelm.setItemDamage(armorHelm.getItemDamage() + armorDmg);
                        armorChest.setItemDamage(armorChest.getItemDamage() + armorDmg);
                        armorLeggings.setItemDamage(armorLeggings.getItemDamage() + armorDmg);
                        armorBoots.setItemDamage(armorBoots.getItemDamage() + armorDmg);
                    }
                }
            }
        }

        if (Reference.antiWitherAutoRepair && tick == 100) {
            Random random = new Random();
            if (random.nextInt(20) == 0 && itemStack.getItemDamage() <= itemStack.getMaxDamage()) {
                itemStack.setItemDamage(itemStack.getItemDamage() + 1);
                tick = 0;
                System.out.println("[Cyan's Mod] [DEBUG] TRUE");
            }
            System.out.println("[Cyan's Mod] [DEBUG] FALSE");
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        Item armor = stack.getItem();
        if (armor == ModItems.antiWitherHelm || armor == ModItems.antiWitherChest || armor == ModItems.antiWitherBoots) {
            return Constants.MODID + ":textures/models/armor/antiwither_layer_1.png";
        }
        else if (armor == ModItems.antiWitherLeggings) {
            return Constants.MODID + ":textures/models/armor/antiwither_layer_2.png";
        }
        else {
            System.out.println("Invalid Item ItemAntiWitherArmor");
            return null;
        }
    }


    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        Entity attacker = source.getEntity();
        if (player instanceof EntityPlayer) {
            EntityPlayer ePlayer = (EntityPlayer) player;
            ExtendedPlayer props = (ExtendedPlayer) ePlayer.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            ItemStack boots = ePlayer.getCurrentArmor(0);
            ItemStack leggings = ePlayer.getCurrentArmor(1);
            ItemStack chestplate = ePlayer.getCurrentArmor(2);
            ItemStack helmet = ePlayer.getCurrentArmor(3);
            if (helmet != null && helmet.getItem() == ModItems.antiWitherHelm) {
                reductionValue += 12F;
            }
            if (chestplate != null && chestplate.getItem() == ModItems.antiWitherLeggings) {
                reductionValue += 32F;
            }
            if (leggings != null && leggings.getItem() == ModItems.antiWitherLeggings) {
                reductionValue += 24F;
            }
            if (boots != null && boots.getItem() == ModItems.antiWitherBoots) {
                reductionValue += 12F;
            }

            if (helmet != null && chestplate != null && leggings != null && boots != null && helmet.getItem() == ModItems.antiWitherHelm && chestplate.getItem() == ModItems.antiWitherChest && leggings.getItem() == ModItems.antiWitherLeggings && boots.getItem() == ModItems.antiWitherBoots) {
                if (attacker instanceof EntityWither || attacker instanceof EntityWitherSkull) {
                    return new ArmorProperties(-1, 3, 100000);
                }
                if (source == DamageSource.wither) {
                    if (props.getProperty(ExtendedPlayer.PropTypes.AntiWitherEffect)) {
                        double armorDmg = Math.round(damage / 4);
                        if (armorDmg < 1)
                            armorDmg = 1;
                        armorDmg += 4;
                        helmet.setItemDamage(helmet.getItemDamage() + (int) armorDmg);
                        chestplate.setItemDamage(chestplate.getItemDamage() + (int) armorDmg);
                        leggings.setItemDamage(leggings.getItemDamage() + (int) armorDmg);
                        boots.setItemDamage(boots.getItemDamage() + (int) armorDmg);
                        player.heal((float)damage);
                        return new ArmorProperties(1, 3, 100000);
                    }
                }
            }

            if (source.isUnblockable())
            {
                reductionValue = Math.round(reductionValue / 2);
            }
            return new ArmorProperties(-1, reductionValue / 100, 20);
        }
        return new ArmorProperties(-1, 0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        if (armor.getItem() == ModItems.antiWitherHelm)
            return 3;
        if (armor.getItem() == ModItems.antiWitherChest)
            return 8;
        if (armor.getItem() == ModItems.antiWitherLeggings)
            return 6;
        if (armor.getItem() == ModItems.antiWitherBoots)
            return 3;
        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
        Entity attacker = source.getEntity();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (attacker instanceof EntityWither || attacker instanceof EntityWitherSkull) {
                /*if (player.worldObj.isRemote) {
                    Random rand = new Random();
                    //Get Player's Position
                    double playerX = player.posX;
                    double playerY = player.posY;
                    double playerZ = player.posZ;
                    double bounceX = playerX;
                    double bounceY = playerY;
                    double bounceZ = playerZ;
                    for (int i = 0; i < 100; i++) {
                        //Get Attacker Positions
                        double attackerX = attacker.posX;
                        double attackerZ = attacker.posZ;
                        double attackerY = attacker.posY;

                        //Wither location from the player X/Z/Y
                        //Is attacker's X higher or lower then player's?
                        if (attackerX > playerX)
                            bounceX += 0.1;
                        else
                            bounceX -= 0.1;
                        //Is attacker's Y higher or lower then player's?
                        if (attackerY > playerY)
                            bounceY += 0.1;
                        else
                            bounceY -= 0.1;
                        //Is attacker's Z higher or lower then player's?
                        if (attackerZ > playerZ)
                            bounceZ += 0.1;
                        else
                            bounceZ -= 0.1;

                        //Spread Particles apart a bit
                        //Spread X
                        float spreadX = rand.nextFloat();
                        //Spread Z
                        float spreadZ = rand.nextFloat();
                        //Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBounceFX(player.getEntityWorld(), bounceX + spreadX, bounceY, bounceZ + spreadZ));
                    }
                }*/
            }
        }
        stack.setItemDamage(stack.getItemDamage() + 1);
    }


}
