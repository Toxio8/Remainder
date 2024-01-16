package fr.toxio.uhc.core.game.config.inv;

import fr.toxio.uhc.api.game.config.inv.IConfigInv;
import org.bukkit.inventory.ItemStack;

public class ConfigInv implements IConfigInv {

    private ItemStack[] startArmor;
    private ItemStack[] startInventory;
    private ItemStack[] deathInventor;

    @Override
    public void setStartInventory(ItemStack[] startInventory) {
        this.startInventory = startInventory;
    }

    @Override
    public ItemStack[] getStartInventory() {
        return this.startInventory;
    }

    @Override
    public void setStartArmor(ItemStack[] startArmor) {
        this.startArmor = startArmor;
    }

    @Override
    public ItemStack[] getStartArmor() {
        return this.startArmor;
    }

    @Override
    public void setDeathInventory(ItemStack[] deathInventory) {
        this.deathInventor = deathInventory;
    }

    @Override
    public ItemStack[] getDeathInventory() {
        return this.deathInventor;
    }
}
