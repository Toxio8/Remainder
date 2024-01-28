package fr.toxio.uhc.api.worldgen;

import org.bukkit.World;

public interface IWorldManager {
    World getWorld();

    void startGeneration();

    boolean isFinished();
}
