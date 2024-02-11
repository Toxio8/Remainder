package fr.toxio.uhc.api.power;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.utils.TimeUtils;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Cooldown {

    @Getter
    private final String name;
    private BukkitTask runnable;
    @Getter
    private int seconds;


    public Cooldown(String name,int seconds) {
        this.name = name;
        this.seconds = seconds;
    }


    public void startCooldown() {
        if (runnable != null) {
            runnable.cancel();
        }

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if (seconds > 0) {
                    seconds--;
                    return;
                }
                cancel();

            }
        }.runTaskTimer(UHCAPI.get().getPlugin(), 0, 20);
    }


    public String getCooldownMessage() {
        return "§cVous ne pouvez pas utiliser " + name +" sera disponible dans " + TimeUtils.beautifulTime(getSeconds());
    }


    public boolean isCooldown(Player player) {
        if (this.getSeconds() <= 0) {
            return false;
        }
        return true;
    }

}
