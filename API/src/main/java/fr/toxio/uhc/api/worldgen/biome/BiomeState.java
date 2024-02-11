package fr.toxio.uhc.api.worldgen.biome;

import net.minecraft.server.v1_8_R3.BiomeBase;
import org.bukkit.Material;

import java.util.Arrays;

public enum BiomeState {

    ROOFED_FOREST(BiomeBase.ROOFED_FOREST),
    FOREST(BiomeBase.FOREST),
    TAIGA(BiomeBase.TAIGA),
    PLAINS(BiomeBase.PLAINS),
    DESERT(BiomeBase.DESERT)
    ;

    private final BiomeBase biomeBase;


    BiomeState(BiomeBase biomeBase) {
        this.biomeBase = biomeBase;
    }

    public BiomeBase getBiomeBase() {
        return biomeBase;
    }

}
