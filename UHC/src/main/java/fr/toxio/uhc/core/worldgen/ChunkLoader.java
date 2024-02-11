package fr.toxio.uhc.core.worldgen;

import fr.toxio.uhc.api.UHCAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Date;

public class ChunkLoader extends BukkitRunnable {

    private final UHCAPI main;

    private double percent;

    private double currentChunkLoad;

    private final double totalChunkToLoad;

    private int cx;

    private int cz;

    private final int radius;

    private boolean finished;

    private final World world;

    public ChunkLoader(UHCAPI main, int radius) {
        this.main = main;

        radius += 150;
        this.percent = 0.0D;
        this.totalChunkToLoad = Math.pow(radius, 2.0D) / 64.0D;
        this.currentChunkLoad = 0.0D;
        this.cx = -radius;
        this.cz = -radius;

        this.world = Bukkit.getWorld("game");
        this.world.setGameRuleValue("doFireTick", "false");
        this.world.setGameRuleValue("naturalRegeneration", "false");

        this.radius = radius;
        this.finished = false;


    }

    public void run() {
        for (int i = 0; i < 30 && !this.finished; i++) {
            Location loc = new Location(this.world, this.cx, 0.0D, this.cz);
            loc.getChunk().load(true);
            this.cx = this.cx + 16;
            this.currentChunkLoad = this.currentChunkLoad + 1.0D;
            if (this.cx > this.radius) {
                this.cx = -this.radius;
                this.cz = this.cz + 16;
                if (this.cz > this.radius) {
                    this.currentChunkLoad = this.totalChunkToLoad;
                    this.finished = true;
                }
            }

        }
        this.percent = this.currentChunkLoad / this.totalChunkToLoad * 100.0D;
        Bukkit.broadcastMessage(String.valueOf((int) this.percent));
        main.get().getGameManager().getGameConfiguration().setGenerating(true);
        if(this.percent < 100) {
            Bukkit.broadcastMessage(String.valueOf(this.percent));
        }

        if (this.finished) {
            Bukkit.broadcastMessage("§aLa map a été entièrement pré-générée !");
            UHCAPI.get().getGameManager().getGameConfiguration().setGenerating(false);
            cancel();
        }
    }

}
