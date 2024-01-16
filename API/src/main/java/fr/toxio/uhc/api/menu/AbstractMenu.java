package fr.toxio.uhc.api.menu;

import com.google.common.collect.Lists;
import fr.toxio.uhc.api.menu.buttons.SimpleButton;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.List;

public abstract class AbstractMenu {

    private final Inventory inventory;
    private final int size;
    private final String name;
    private List<SimpleButton> buttons;

    public AbstractMenu(int size, String name) {
        this.buttons = Lists.newArrayList();
        this.name = name;
        this.size = size;
        this.inventory = Bukkit.createInventory(null,size,name);
        this.loadItems();
        for (SimpleButton simpleButton : buttons) {
            this.inventory.setItem(simpleButton.getSlot(), simpleButton.getItemStack());
        }
    }

    public abstract void loadItems();


    public boolean isAutoUpdate() {
        return false;
    }

    public boolean isUpdateOnClick() {
        return false;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<SimpleButton> getButtons() {
        return buttons;
    }
}
