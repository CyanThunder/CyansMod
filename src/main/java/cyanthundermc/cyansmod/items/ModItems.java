package cyanthundermc.cyansmod.items;

import cyanthundermc.cyansmod.material.ModArmorMaterial;
import cyanthundermc.cyansmod.material.ModToolMaterial;
import net.minecraft.item.Item;

public final class ModItems {

    public static Item blueGreenIngotItem;
    public static Item unpreparedCopyIngot;
    public static Item preparedCopyIngot;
    public static Item alloyCopyIngot;
    public static Item itemFries;
    public static Item itemKnife;
    public static Item itemFilter;
    public static Item itemSalt;
    public static Item blueGreenPickaxe;
    public static Item blueGreenSword;
    public static Item blueGreenShovel;
    public static Item blueGreenAxe;
    public static Item blueGreenHoe;
    public static Item sugarBoots;
    public static Item antiWitherHelm;
    public static Item antiWitherChest;
    public static Item antiWitherLeggings;
    public static Item antiWitherBoots;
    public static Item antiWitherEffectToggler;

    public static void init() {
        blueGreenIngotItem = new ItemBlueGreenIngot();
        unpreparedCopyIngot = new ItemUnpreparedCopyIngot();
        preparedCopyIngot = new ItemPreparedCopyIngot();
        alloyCopyIngot = new AlloyCopyIngot();
        itemFries = new ItemFries(4, 1.5f, false);
        itemKnife = new ItemKnife();
        itemFilter = new ItemFilter();
        itemSalt = new ItemSalt();
        blueGreenSword = new ItemBlueGreenSword(ModToolMaterial.blueGreen);
        blueGreenPickaxe = new ItemBlueGreenPickaxe(ModToolMaterial.blueGreen);
        blueGreenAxe = new ItemBlueGreenAxe(ModToolMaterial.blueGreen);
        blueGreenShovel = new ItemBlueGreenShovel(ModToolMaterial.blueGreen);
        blueGreenHoe = new ItemBlueGreenHoe(ModToolMaterial.blueGreen);
        sugarBoots = new ItemSugarArmor(ModArmorMaterial.sugar, 3, "SugarBoots");
        antiWitherHelm = new ItemAntiWitherArmor(ModArmorMaterial.wither, 0, "AntiWitherHelm");
        antiWitherChest = new ItemAntiWitherArmor(ModArmorMaterial.wither, 1, "AntiWitherChest");
        antiWitherLeggings = new ItemAntiWitherArmor(ModArmorMaterial.wither, 2, "AntiWitherLeggings");
        antiWitherBoots = new ItemAntiWitherArmor(ModArmorMaterial.wither, 3, "AntiWitherBoots");
        antiWitherEffectToggler = new ItemAntiWitherEffect();
    }
}
