package fr.toxio.uhc.core.worldgen;

import fr.toxio.uhc.api.worldgen.IWorldManager;
import fr.toxio.uhc.core.UHCCoreAPI;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.*;

@Getter
@Setter
public class WorldManager implements IWorldManager {

    private final UHCCoreAPI uhc;
    private boolean finished;
    private World world;

    public WorldManager(UHCCoreAPI uhc) {
        this.uhc = uhc;
        this.finished = false;
        this.world = null;
    }

    @Override
    public void startGeneration() {
        WorldCreator creator = new WorldCreator("uhc")
                .type(WorldType.NORMAL)
                .environment(World.Environment.NORMAL)
                .generateStructures(false);

        this.world = creator.createWorld();
        world.getWorldBorder().setSize(uhc.getGameManager().getConfigBorder().getInitialBorder());
        world.getWorldBorder().setCenter(0, 0);
        Bukkit.broadcastMessage("DEBUG world is successfully generated");

        Bukkit.broadcastMessage("DEBUG loading chunks");
        int borderSize = uhc.getGameManager().getConfigBorder().getInitialBorder();
        for (int x = -borderSize; x <= borderSize; x++) {
            for (int z = -borderSize; z <= borderSize; z++) {
                Chunk chunk = world.getChunkAt(x, z);
                if (chunk.isLoaded()) {
                    continue;
                }

                chunk.load();
                Bukkit.broadcastMessage("DEBUG chunk " + x + " " + z + " is loaded");
            }
        }

        Bukkit.broadcastMessage("DEBUG chunks are successfully loaded");
    }
}
