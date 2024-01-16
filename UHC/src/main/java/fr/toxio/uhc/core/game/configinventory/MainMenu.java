package fr.toxio.uhc.core.game.configinventory;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.menu.AbstractMenu;
import fr.toxio.uhc.api.menu.buttons.SimpleButton;
import fr.toxio.uhc.core.event.impl.StartGameEvent;
import org.bukkit.Material;

public class MainMenu extends AbstractMenu {


    public MainMenu() {
        super(54,"Menu Principal");
    }

    @Override
    public void loadItems() {
        SimpleButton startButton = new SimpleButton(Material.SLIME_BALL,"Commencer",40,(player, itemStack) -> {
            itemStack.setType(Material.MAGMA_CREAM);
            UHCAPI.get().getEventManager().callEvent(new StartGameEvent());
        });
    }

}
