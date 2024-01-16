package fr.toxio.uhc.api.game.config.inv;

import org.bukkit.inventory.ItemStack;

public interface IConfigInv {


    void setStartInventory(ItemStack[] startInventory);
    ItemStack[] getStartInventory();

    void setStartArmor(ItemStack[] deathInventory);
    ItemStack[] getStartArmor();

    void setDeathInventory(ItemStack[] deathInventory);
    ItemStack[] getDeathInventory();

}
