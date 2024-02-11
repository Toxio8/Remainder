package fr.toxio.uhc.core.game.config.border;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.game.config.border.IConfigBorder;
import fr.toxio.uhc.api.game.config.border.IConfigBorderManager;
import fr.toxio.uhc.api.player.IUHCProfile;
import fr.toxio.uhc.api.utils.GlobalUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ConfigBorderManager implements IConfigBorderManager {



    public void handleBorder(UHCAPI uhcapi) {
        WorldBorder worldBorder = Bukkit.getWorld(UHCAPI.get().getWorldManager().getWorld().getUID()).getWorldBorder();
        worldBorder.setSize(UHCAPI.get().getGameManager().getConfigBorder().getInitialBorder());
        IConfigBorder configBorder = UHCAPI.get().getGameManager().getConfigBorder();

        BukkitRunnable runnable = (BukkitRunnable) new BukkitRunnable() {
            @Override
            public void run() {
                if (worldBorder.getSize() <= configBorder.getFinalBorder()) {
                    this.cancel();
                    return;
                }
                for (IUHCProfile profile : UHCAPI.get().getPlayerManager().getProfiles().values()) {
                    Player player = profile.getPlayer();
                    Location playerLocation = player.getLocation();

                    if (!GlobalUtils.isInsideBorder(playerLocation, worldBorder.getSize())) {
                        Location tpLocation = GlobalUtils.getRandomLocationInsideBorder(worldBorder.getSize());
                        player.teleport(tpLocation);
                    }
                }
                worldBorder.setSize(worldBorder.getSize() - configBorder.getBorderBlockPerSecond(),1/4);

            }

        }.runTaskTimer(UHCAPI.get().getPlugin(),0,20);
    }
}
