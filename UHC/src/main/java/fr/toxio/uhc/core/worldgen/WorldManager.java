package fr.toxio.uhc.core.worldgen;



import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.worldgen.BlockParameters;
import fr.toxio.uhc.api.worldgen.IWorldManager;
import fr.toxio.uhc.api.worldgen.biome.BiomeState;
import fr.toxio.uhc.core.worldgen.cave.CaveGenerator;
import net.minecraft.server.v1_8_R3.WorldChunkManager;
import net.minecraft.server.v1_8_R3.WorldProvider;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

import java.lang.reflect.Field;
import java.nio.Buffer;

public class WorldManager implements IWorldManager,Listener {

    public World world;
    private UHCAPI uhcapi;

    public WorldManager(UHCAPI uhcapi) {
        this.uhcapi = uhcapi;
        WorldCreator uhcWorld = new WorldCreator("game");
        this.world = uhcWorld.createWorld();
    }

    @EventHandler
    public void onWorldInit(WorldInitEvent event) {
        World world = event.getWorld();
        if (!world.getName().equalsIgnoreCase("game")) {
            return;
        }

        // Cave Boost
        CaveGenerator generator = new CaveGenerator();
        for (BlockParameters block : uhcapi.get().getCaveManager().getOresCave()) {
            generator.registerBlocks(block);
        }
        world.getPopulators().add(generator);
        System.out.println("Ores is Boost");

        // World Biome generator
        net.minecraft.server.v1_8_R3.World craftworld = ((CraftWorld) world).getHandle();
        WorldProvider worldProvider = craftworld.worldProvider;

        try {
            Field field = WorldProvider.class.getDeclaredField("c");
            field.setAccessible(true);
            field.set(worldProvider,new WorldChunkManagerPatched((WorldChunkManager) field.get(worldProvider),0,0, BiomeState.ROOFED_FOREST));
            System.out.println("0 0 Biome has been successfully changed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUhcWorld() {
        WorldCreator worldCreator = new WorldCreator("game");
        this.world = worldCreator.createWorld();
    }

    @Override
    public void startPregen() {
        ChunkLoader chunkLoader = new ChunkLoader(uhcapi.get(),UHCAPI.get().getGameManager().getConfigBorder().getInitialBorder());
        chunkLoader.runTaskTimer(uhcapi.getPlugin(),0,5L);
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
