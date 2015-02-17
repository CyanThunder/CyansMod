package cyanthundermc.cyansmod.material;

import net.minecraft.item.Item.*;
import net.minecraft.item.ItemArmor.*;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    public static ToolMaterial blueGreen;
    public static void register()
    {
        blueGreen = EnumHelper.addToolMaterial("BlueGreen", 2, 500, 7.0F, 3.0F, 18);
    }
}
