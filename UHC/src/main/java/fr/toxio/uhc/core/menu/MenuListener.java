package fr.toxio.uhc.core.menu;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.menu.AbstractMenu;
import fr.toxio.uhc.api.menu.buttons.SimpleButton;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {

    private UHCAPI uhcAPI;

    public MenuListener(UHCAPI uhcAPI) {
        this.uhcAPI = uhcAPI;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
    }

    @EventHandler
    public void onButtonClick(InventoryClickEvent event) {
        ItemStack itemStack = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        for (AbstractMenu abstractMenu : uhcAPI.getMenuManager().getMenus()) {
            if (event.getInventory().equals(abstractMenu.getInventory())) {
                event.setCancelled(true);
                if (abstractMenu.isUpdateOnClick()) {
                    abstractMenu.loadItems();
                }
            }

            for (SimpleButton simpleButton : abstractMenu.getButtons()) {
                if (!itemStack.isSimilar(simpleButton.getItemStack()) || player.getGameMode() == GameMode.CREATIVE) {
                    continue;
                }
                event.setCancelled(true);
                simpleButton.onClick(player, itemStack);
            }
        }
    }

}
