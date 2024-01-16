package fr.toxio.uhc.core.game.config.biomecenter;

import fr.toxio.uhc.api.game.config.biomecenter.IBiomeCenterManager;
import org.bukkit.block.Biome;

public class BiomeCenterManager implements IBiomeCenterManager {

    private Biome biome;

    public BiomeCenterManager() {

    }

    @Override
    public void setBiome(Biome biome) {
        this.biome = biome;
    }
    @Override
    public Biome getBiome() {
        return biome;
    }
}
