package fr.toxio.uhc.api.game.config.biomecenter;

import fr.toxio.uhc.api.worldgen.biome.BiomeState;
import org.bukkit.block.Biome;

public interface IBiomeCenterManager {
    void setBiome(BiomeState biome);

    BiomeState getBiome();
}
