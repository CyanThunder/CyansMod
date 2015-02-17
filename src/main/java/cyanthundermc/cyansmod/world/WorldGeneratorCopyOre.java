package cyanthundermc.cyansmod.world;

import cpw.mods.fml.common.IWorldGenerator;
import cyanthundermc.cyansmod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGeneratorCopyOre implements IWorldGenerator{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId)
        {
            case 0: GenerateOverworld(random, chunkX * 16, chunkZ * 16, world); break;
            case 1: GenerateEnd(random, chunkX * 16, chunkZ * 16, world); break;
            case 2: GenerateNether(random, chunkX * 16, chunkZ * 16, world); break;
        }
    }
    public final int veinSizeMin = 2;
    public final int veinSizeMax = 8;
    public final int attemptsToSpawn = 3;
    public final int yMin = 1;
    public final int yMax = 20;
    private void GenerateOverworld(Random random, int x, int z, World world) {
        this.addOres(ModBlocks.CopyOre, world, random, x, z, veinSizeMin, veinSizeMax, attemptsToSpawn, yMin, yMax);
    }

    private void GenerateNether(Random random, int x, int z, World world) {

    }

    private void GenerateEnd(Random random, int x, int z, World world) {

    }

    public void addOres(Block block, World world, Random random, int blockXPos, int blockZPos, int minVainSize, int maxVainSize,
                        int chanceToSpawn, int minY, int maxY) {
        WorldGenMinable minable = new WorldGenMinable(block, minVainSize + random.nextInt(maxVainSize - minVainSize), Blocks.stone);
        for (int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(15);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(15);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
}
