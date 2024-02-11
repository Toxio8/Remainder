package fr.toxio.uhc.core.game.config.biomecenter;

import fr.toxio.uhc.api.game.config.biomecenter.IBiomeCenterManager;
import fr.toxio.uhc.api.worldgen.biome.BiomeState;
import org.bukkit.block.Biome;

public class BiomeCenterManager implements IBiomeCenterManager {

    private BiomeState biome;

    public BiomeCenterManager() {
        this.biome = BiomeState.TAIGA;
    }

    @Override
    public void setBiome(BiomeState biome) {
        this.biome = biome;
    }
    @Override
    public BiomeState getBiome() {
        return biome;
    }
}
