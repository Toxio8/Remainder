package fr.toxio.uhc.api.module.scenario;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractScenario implements Listener {

    private ItemStack material;
    private boolean active;
    private String name;
    private String description;
    private boolean parameters;
    private boolean isEnabledAfterPvP;

    protected AbstractScenario(Material material, String name, String description, boolean parameters, boolean isEnabledAfterPvP) {
        this.material = new ItemStack(material);
        this.active = false;
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.isEnabledAfterPvP = isEnabledAfterPvP;
    }


    public abstract void onGameStart();

    public ItemStack getMaterial() {
        return material;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isParameters() {
        return parameters;
    }
}
