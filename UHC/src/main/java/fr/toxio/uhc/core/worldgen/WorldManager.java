package fr.toxio.uhc.core.worldgen;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.worldgen.IWorldManager;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WorldManager implements IWorldManager {


    @Override
    public void startPregen(World world, int radius) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
