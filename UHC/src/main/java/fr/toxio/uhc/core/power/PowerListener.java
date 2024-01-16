package fr.toxio.uhc.core.power;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.power.AbstractPower;
import fr.toxio.uhc.api.power.IPowerManager;
import lombok.SneakyThrows;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PowerListener implements Listener {

    private UHCAPI uhcapi;

    public PowerListener(UHCAPI uhcapi) {
        this.uhcapi = uhcapi;
    }

    @EventHandler
    @SneakyThrows
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) {
            return;
        }
        for (AbstractPower abstractPower : IPowerManager.registeredPowers) {
            if (abstractPower.getItem() == null) {
                return;
            }
            if (abstractPower.getCooldown().isCooldown(event.getPlayer())) {
                event.getPlayer().sendMessage(abstractPower.getCooldown().getCooldownMessage());
                return;
            }
            abstractPower.onClick(event.getPlayer(),event.getAction());
            abstractPower.getCooldown().startCooldown();
        }
    }
}
