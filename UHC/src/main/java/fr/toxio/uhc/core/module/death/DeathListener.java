package fr.toxio.uhc.core.module.death;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.core.event.impl.UHCDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(UHCDeathEvent event) {
        Player player = event.getProfile().getPlayer();
        UHCAPI.get().getDeathManager().handle(player);
    }

}
