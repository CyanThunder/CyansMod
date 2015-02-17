package cyanthundermc.cyansmod.material;

import net.minecraft.item.ItemArmor.*;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmorMaterial {
    public static ArmorMaterial sugar;
    public static ArmorMaterial wither;
    public static void register() {
        //Durability times 11, 16, 13, or 14 = real Durability
        //SugarArmor - Just having boots no armor for Helm, Chest, and Leggings
        sugar = EnumHelper.addArmorMaterial("SugarArmor", 15, new int[]{1, 1, 1, 2}, 10);
        wither = EnumHelper.addArmorMaterial("WitherArmor", 150, new int[]{3, 7, 6, 3}, 35);
    }
}
