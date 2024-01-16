package fr.toxio.uhc.core.menu;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.menu.AbstractMenu;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MenuRunnable extends BukkitRunnable {

    public MenuRunnable(UHCAPI uhcapi) {
        this.runTaskTimer(uhcapi.getPlugin(),20L,20L);
    }

    @Override
    public void run() {
        for (AbstractMenu abstractMenu : UHCAPI.get().getMenuManager().getMenus()) {
            if (!abstractMenu.isAutoUpdate()) {
                continue;
            }
            for (HumanEntity humanEntity : abstractMenu.getInventory().getViewers()) {
                Player player = (Player) humanEntity;
                player.openInventory(abstractMenu.getInventory());
            }
        }
    }
}
