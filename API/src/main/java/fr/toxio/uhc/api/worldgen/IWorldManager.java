package fr.toxio.uhc.api.worldgen;

import org.bukkit.World;

public interface IWorldManager {
    void createUhcWorld();

    void startPregen();


    void setWorld(World world);

    World getWorld();

    boolean isFinished();
}
