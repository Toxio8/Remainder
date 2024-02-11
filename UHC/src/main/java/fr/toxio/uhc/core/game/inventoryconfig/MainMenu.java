package fr.toxio.uhc.core.game.inventoryconfig;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.menu.AbstractMenu;
import fr.toxio.uhc.api.menu.buttons.SimpleButton;
import fr.toxio.uhc.core.event.impl.StartGameEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super(54,"Menu Principal");
    }

    @Override
    public void loadItems() {
        SimpleButton worldMenuButton = new SimpleButton(Material.PRISMARINE_CRYSTALS,"§lGérer les Mondes",37,(player, itemStack) -> {
            UHCAPI.get().getMenuManager().openMenu(player,new WorldMenu());
        });
        getButtons().add(worldMenuButton);
    }

    @Override
    public boolean isUpdateOnClick() {
        return true;
    }
}
