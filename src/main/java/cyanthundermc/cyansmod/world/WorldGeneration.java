package cyanthundermc.cyansmod.world;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGeneration {
    public static void init() {
        GameRegistry.registerWorldGenerator(new WorldGeneratorBlueGreenDottedOre(), 1);
        GameRegistry.registerWorldGenerator(new WorldGeneratorCopyOre(), 1);
    }
}
