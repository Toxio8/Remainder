package fr.toxio.uhc.core.game.config.enchant;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.game.config.enchant.IConfigEnchantManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.ItemStack;

public class ConfigEnchantManager implements IConfigEnchantManager, Listener {


    @EventHandler
    public void prepareItemEnchant(PrepareItemEnchantEvent event) {
        ItemStack item = event.getItem();
        if(item.getType() == Material.DIAMOND_LEGGINGS || item.getType() == Material.DIAMOND_HELMET || item.getType() == Material.DIAMOND_CHESTPLATE || item.getType() == Material.DIAMOND_BOOTS) {
            if (!hasProtectionGreaterThan(item, Enchantment.PROTECTION_ENVIRONMENTAL, UHCAPI.get().getGameManager().getConfigEnchant().getDiamondProtection())) {
                return;
            }
            event.setCancelled(true);
        }
        if(item.getType() == Material.IRON_LEGGINGS || item.getType() == Material.IRON_HELMET || item.getType() == Material.IRON_CHESTPLATE || item.getType() == Material.IRON_BOOTS) {
            if (!hasProtectionGreaterThan(item, Enchantment.PROTECTION_ENVIRONMENTAL, UHCAPI.get().getGameManager().getConfigEnchant().getIronProtection())) {
                return;
            }
            event.setCancelled(true);
        }
        if (item.getType() == Material.DIAMOND_SWORD) {
            if (!hasProtectionGreaterThan(item,Enchantment.DAMAGE_ALL,UHCAPI.get().getGameManager().getConfigEnchant().getDiamondSwordSharpness())) {
                return;
            }
            event.setCancelled(true);
        }
        if (item.getType() == Material.IRON_SWORD) {
            if (!hasProtectionGreaterThan(item,Enchantment.DAMAGE_ALL,UHCAPI.get().getGameManager().getConfigEnchant().getIronSwordSharpness())) {
               return;
            }
            event.setCancelled(true);
        }
    }

    private boolean hasProtectionGreaterThan(ItemStack item, Enchantment enchantment, int level) {
        return item.getEnchantments().containsKey(enchantment) &&
                item.getEnchantmentLevel(enchantment) > level;
    }
    //TODO ANVIL CANCELLER
}
