package fr.toxio.uhc.api.game.config.biomecenter;

import org.bukkit.block.Biome;

public interface IBiomeCenterManager {
    void setBiome(Biome biome);

    Biome getBiome();
}
