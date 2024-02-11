package fr.toxio.uhc.core.game.config.inv;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.player.IUHCProfile;
import fr.toxio.uhc.core.event.impl.StartGameEvent;
import fr.toxio.uhc.core.event.impl.UHCDeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class ConfigInvListener implements Listener {

    BukkitTask task;

    @EventHandler
    public void onStartGame(StartGameEvent event) {
        if (task != null) {
            task.cancel();
        }
        this.task = Bukkit.getScheduler().runTaskLater(UHCAPI.get().getPlugin(), () -> {
            for (IUHCProfile profiles : UHCAPI.get().getPlayerManager().getProfiles().values()) {
                Player player = profiles.getPlayer();
                for (ItemStack itemStack : UHCAPI.get().getGameManager().getConfigInv().getStartInventory()) {
                    player.getInventory().addItem(itemStack);
                }
                for (ItemStack itemStack : UHCAPI.get().getGameManager().getConfigInv().getStartArmor()) {
                    if (itemStack.getType().equals(Material.LEATHER_HELMET) || itemStack.getType().equals(Material.GOLD_HELMET) || itemStack.getType().equals(Material.CHAINMAIL_HELMET) || itemStack.getType().equals(Material.IRON_HELMET) || itemStack.getType().equals(Material.DIAMOND_HELMET)) {
                        player.getInventory().setHelmet(itemStack);
                    }
                    if (itemStack.getType().equals(Material.LEATHER_CHESTPLATE) || itemStack.getType().equals(Material.GOLD_CHESTPLATE) || itemStack.getType().equals(Material.CHAINMAIL_CHESTPLATE) || itemStack.getType().equals(Material.IRON_CHESTPLATE) || itemStack.getType().equals(Material.DIAMOND_CHESTPLATE)) {
                        player.getInventory().setChestplate(itemStack);
                    }
                    if (itemStack.getType().equals(Material.LEATHER_LEGGINGS) || itemStack.getType().equals(Material.GOLD_LEGGINGS) || itemStack.getType().equals(Material.CHAINMAIL_LEGGINGS) || itemStack.getType().equals(Material.IRON_LEGGINGS) || itemStack.getType().equals(Material.DIAMOND_LEGGINGS)) {
                        player.getInventory().setLeggings(itemStack);
                    }
                    if (itemStack.getType().equals(Material.LEATHER_BOOTS) || itemStack.getType().equals(Material.GOLD_BOOTS) || itemStack.getType().equals(Material.CHAINMAIL_BOOTS) || itemStack.getType().equals(Material.IRON_BOOTS) || itemStack.getType().equals(Material.DIAMOND_BOOTS)) {
                        player.getInventory().setBoots(itemStack);
                    }
                }

            }
        },4);
        event.isCancelled();
    }
    @EventHandler
    public void deathEvent(UHCDeathEvent event) {
        for (ItemStack stack : UHCAPI.get().getGameManager().getConfigInv().getDeathInventory()) {
            Bukkit.getWorld("world").dropItemNaturally(event.getProfile().getPlayer().getLocation(),stack);
        }
    }
}
