package fr.toxio.uhc.api.worldgen;

import org.bukkit.World;

public interface IWorldManager {
    void startPregen(World world, int radius);

    boolean isFinished();
}
