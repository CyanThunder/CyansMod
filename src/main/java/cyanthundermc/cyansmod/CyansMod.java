package cyanthundermc.cyansmod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import cyanthundermc.cyansmod.configuration.ConfigurationHandler;
import cyanthundermc.cyansmod.eventhandler.CyansModEventHandler;
import cyanthundermc.cyansmod.gui.GuiHandler;
import cyanthundermc.cyansmod.items.ModItems;
import cyanthundermc.cyansmod.lib.Constants;
import cyanthundermc.cyansmod.material.ModArmorMaterial;
import cyanthundermc.cyansmod.material.ModToolMaterial;
import cyanthundermc.cyansmod.proxy.CommonProxy;
import cyanthundermc.cyansmod.recipes.ModRecipes;
import cyanthundermc.cyansmod.world.WorldGeneration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod.Instance;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)
public class CyansMod {
    @Instance(value = Constants.MODID)
    public static CyansMod instance;

    @SidedProxy(clientSide = Constants.CLIENT_PROXY_CLASS, serverSide = Constants.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("[Cyan's Mod] Loading Configurations");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        System.out.println("[Cyan's Mod] Registering Tool/Armor Materials");
        ModToolMaterial.register();
        ModArmorMaterial.register();
        System.out.println("[Cyan's Mod] Adding Blocks");
        ModBlocks.init();
        System.out.println("[Cyan's Mod] Adding Items");
        ModItems.init();
        System.out.println("[Cyan's Mod] Registering World Generation");
        WorldGeneration.init();
        System.out.println("[Cyan's Mod] Adding Recipes");
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void serverInit(FMLServerStartingEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new CyansModEventHandler());
        FMLCommonHandler.instance().bus().register(new CyansModEventHandler());
        System.out.println("[Cyan's Mod] Registering Tile Entities");
        proxy.registerTileEntities();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    //Add Creative Tab Item
    public static final CreativeTabs CreativeTab = new CreativeTabs(Constants.MODNAME) {
        @Override
        public Item getTabIconItem() {
            return ModItems.blueGreenIngotItem;
        }

        @Override
        public String getTranslatedTabLabel() {
            return "Cyan's Mod";
        }
    };
}
