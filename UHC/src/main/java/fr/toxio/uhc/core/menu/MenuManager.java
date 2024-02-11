package fr.toxio.uhc.core.menu;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.menu.AbstractMenu;
import fr.toxio.uhc.api.menu.IMenuManager;
import fr.toxio.uhc.core.game.inventoryconfig.BiomeMenu;
import fr.toxio.uhc.core.game.inventoryconfig.MainMenu;
import fr.toxio.uhc.core.game.inventoryconfig.WorldMenu;
import org.bukkit.entity.Player;

import java.util.List;

public class MenuManager implements IMenuManager {


    public MenuManager() {
        menus.add(new MainMenu());
        menus.add(new WorldMenu());
        menus.add(new BiomeMenu());
    }

    @Override
    public List<AbstractMenu> getMenus() {
        return menus;
    }

    @Override
    public void addMenus(AbstractMenu abstractMenu) {
        menus.add(abstractMenu);
    }

    @Override
    public void removeMenus(AbstractMenu abstractMenu) {
        menus.remove(abstractMenu);
    }

    @Override
    public void openMenu(Player player, AbstractMenu abstractMenu) {
        player.openInventory(abstractMenu.getInventory());
    }

    @Override
    public void closeMenu(Player player) {
        player.closeInventory();
    }

    @Override
    public AbstractMenu getMenu(String name) {
        for (AbstractMenu abstractMenu : menus) {
            if (abstractMenu.getName().equals(name)) {
                return abstractMenu;
            }
        }
        return null;
    }


}
