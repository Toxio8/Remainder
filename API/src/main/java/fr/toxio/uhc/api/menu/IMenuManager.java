package fr.toxio.uhc.api.menu;

import com.google.common.collect.Lists;
import org.bukkit.entity.Player;

import java.util.List;

public interface IMenuManager {

    List<AbstractMenu> menus = Lists.newArrayList();

    List<AbstractMenu> getMenus();

    void addMenus(AbstractMenu abstractMenu);

    void removeMenus(AbstractMenu abstractMenu);

    void openMenu(Player player, AbstractMenu abstractMenu);

    void closeMenu(Player player);

    AbstractMenu getMenu(String name);
}
