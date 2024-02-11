package fr.toxio.uhc.core.worldgen;

import fr.toxio.uhc.api.worldgen.biome.BiomeState;
import net.minecraft.server.v1_8_R3.BiomeBase;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.WorldChunkManager;

import java.lang.reflect.Field;

public class WorldChunkManagerPatched extends WorldChunkManager {

    private final int cx;
    private final int cz;
    private final BiomeState biomeChoosed;

    public WorldChunkManagerPatched(WorldChunkManager worldChunkManager, int x, int z, BiomeState biomeChoosed) {
        this.biomeChoosed = biomeChoosed;
        this.cx = x;
        this.cz = z;
        Field field;
        try {
            field = WorldChunkManager.class.getDeclaredField("b");
            field.setAccessible(true);
            field.set(this, field.get(worldChunkManager));

            field = WorldChunkManager.class.getDeclaredField("c");
            field.setAccessible(true);
            field.set(this, field.get(worldChunkManager));

            field = WorldChunkManager.class.getDeclaredField("d");
            field.setAccessible(true);
            field.set(this, field.get(worldChunkManager));

            field = WorldChunkManager.class.getDeclaredField("e");
            field.setAccessible(true);
            field.set(this, field.get(worldChunkManager));

            field = WorldChunkManager.class.getDeclaredField("f");
            field.setAccessible(true);
            field.set(this, field.get(worldChunkManager));


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public BiomeBase getBiome(BlockPosition blockPosition, BiomeBase biomeBase) {

        BiomeBase biome = super.getBiome(blockPosition, biomeBase);

        if ((blockPosition.getX()-cx) * (blockPosition.getX()-cx) + (blockPosition.getX()-cz) * (blockPosition.getZ()-cz) < 300 * 300) {
            if(BiomeBase.RIVER != biome)
                biome = biomeChoosed.getBiomeBase();
        }

        return biome;
    }


    @Override
    public BiomeBase[] getBiomeBlock(BiomeBase[] paramArrayOfBiomeBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {

        paramArrayOfBiomeBase = super.getBiomeBlock(paramArrayOfBiomeBase, paramInt1, paramInt2, paramInt3, paramInt4);

        for (int x = 0; x < paramInt3; x++) {
            for (int z = 0; z < paramInt4; z++) {
                if ((paramInt1 + x-cx) * (paramInt1 + x-cx) + (paramInt2 + z-cz) * (paramInt2 + z-cz) < 300 * 300) {
                    if(BiomeBase.RIVER != paramArrayOfBiomeBase[x + z * paramInt4])
                        paramArrayOfBiomeBase[x + z * paramInt4] = biomeChoosed.getBiomeBase();
                }
            }
        }

        return paramArrayOfBiomeBase;

    }
}

