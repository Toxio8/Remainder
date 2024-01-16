package fr.toxio.uhc.core.menu;

import fr.toxio.uhc.api.menu.AbstractMenu;
import fr.toxio.uhc.api.menu.IMenuManager;
import org.bukkit.entity.Player;

import java.util.List;

public class MenuManager implements IMenuManager {

    public MenuManager() {

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
