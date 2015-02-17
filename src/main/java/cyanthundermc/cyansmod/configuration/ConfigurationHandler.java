package cyanthundermc.cyansmod.configuration;

import cyanthundermc.cyansmod.lib.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static void init (File configFile)
    {
        //Create the configuration object from the given configuration file
        Configuration configuration = new Configuration(configFile);
        try
        {
            //load the configuration file
            configuration.load();

            //Read in properties from configuration file
            Reference.sugarBootDOT = configuration.get("Armor", "SugarBoots-DOT", false, "Should the boots lose damage over time? (true/false)").getBoolean();
            Reference.sugarBootDOTTime = configuration.get("Armor", "SugarBoots-DOT_Tick_Speed", 1200, "How many ticks before the boots take damage?").getInt();
            Reference.antiWitherAutoRepair = configuration.get("Armor", "AntiWither-AutoRepair", true, "Automatically Repair Wither Armor?").getBoolean();

            //No Longer Used
            //Reference.sugarBootSpeedValue = configuration.get("Armor", "SugarBoots-Speed", 3, "Speed Value (Example: 4, 4 would give you Speed 4 when worn)").getInt();
        }
        catch (Exception e) {
            //log the exception
        }
        finally {
            //save the configuration file
            configuration.save();
        }
        System.out.println(configFile);
    }
}
