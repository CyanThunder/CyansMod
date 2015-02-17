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

public class ItemAntiWitherArmor extends ItemArmor implements ISpecialArmor {

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

    //DEBUG:
    public static int tick = 0;

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (world.isRemote) {
            tick += 1;
            ExtendedPlayer props = (ExtendedPlayer) player.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME);
            ItemStack[] wearingArmor = {player.getCurrentArmor(3), player.getCurrentArmor(2), player.getCurrentArmor(1), player.getCurrentArmor(0)};
            if (wearingArmor[0] != null && wearingArmor[1] != null && wearingArmor[2] != null && wearingArmor[3] != null) {
                if (wearingArmor[0].getItem() == ModItems.antiWitherHelm && wearingArmor[1].getItem() == ModItems.antiWitherChest && wearingArmor[2].getItem() == ModItems.antiWitherLeggings && wearingArmor[3].getItem() == ModItems.antiWitherBoots) {
                    if (props.getProperty(ExtendedPlayer.PropTypes.AntiWitherEffect)) {
                        if (player.isPotionActive(Potion.wither) && !player.capabilities.isCreativeMode) {
                            player.removePotionEffect(Potion.wither.getId());
                            int armorDmg = (int) Math.round(world.difficultySetting.getDifficultyId() * 8);
                            wearingArmor[0].setItemDamage(wearingArmor[0].getItemDamage() + armorDmg);
                            wearingArmor[1].setItemDamage(wearingArmor[1].getItemDamage() + armorDmg);
                            wearingArmor[2].setItemDamage(wearingArmor[2].getItemDamage() + armorDmg);
                            wearingArmor[3].setItemDamage(wearingArmor[3].getItemDamage() + armorDmg);
                        }
                    }
                }
            }

            if (Reference.antiWitherAutoRepair && tick == 100) {
                Random random = new Random();
                if (random.nextInt(10) == 0) {
                    int r = random.nextInt(4);
                    if (wearingArmor[r].getItem() instanceof ItemAntiWitherArmor)
                        wearingArmor[r].setItemDamage(wearingArmor[r].getItemDamage() - 1);
                    else {
                        int r2 = random.nextInt(4);
                        while (r2 != r) {
                            r2 = random.nextInt(4);
                        }
                        if (wearingArmor[r2].getItem() instanceof ItemAntiWitherArmor)
                            wearingArmor[r2].setItemDamage(wearingArmor[r2].getItemDamage() - 1);
                        else {
                            int r3 = random.nextInt(4);
                            while (r3 != r2 && r3 != r) {
                                r3 = random.nextInt(4);
                            }
                            if (wearingArmor[r3].getItem() instanceof ItemAntiWitherArmor)
                                wearingArmor[r3].setItemDamage(wearingArmor[r3].getItemDamage() - 1);
                            else {
                                int r4 = random.nextInt(4);
                                while (r4 != r3 && r4 != r2 && r4 != r) {
                                    r4 = random.nextInt(4);
                                }
                                if (wearingArmor[r4].getItem() instanceof ItemAntiWitherArmor)
                                    wearingArmor[r4].setItemDamage(wearingArmor[r4].getItemDamage() - 1);
                            }
                        }
                    }
                }
                tick = 0;
            }
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
