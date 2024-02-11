package fr.toxio.uhc.core.module.death;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.module.death.IDeathManager;
import fr.toxio.uhc.api.player.IUHCProfile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DeathManager implements IDeathManager {

    @Override
    public void handle(Player player) {
        IUHCProfile profile = UHCAPI.get().getPlayerManager().getProfile(player.getUniqueId());
        Bukkit.broadcastMessage("-----------------------------------");
        Bukkit.broadcastMessage( "§c" + profile.getName() + "§r est mort");
        if (profile.getRole() != null) {
            Bukkit.broadcastMessage("Sont role étais §9" + profile.getRole().getName());
        }
        Bukkit.broadcastMessage("-----------------------------------");
    }

}
