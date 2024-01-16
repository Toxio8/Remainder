package fr.toxio.uhc.core.game.config.diamond;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.game.config.diamond.IConfigDiamondLimitManager;
import fr.toxio.uhc.api.player.IUHCProfile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ConfigDiamonLimitManager implements IConfigDiamondLimitManager,Listener {

    @EventHandler
    public void onBreakDiamondBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        IUHCProfile profile = UHCAPI.get().getPlayerManager().getProfile(player.getUniqueId());
        if (event.getBlock().getType() == Material.DIAMOND_BLOCK) {
            if (profile.getMinedDiamonds() > UHCAPI.get().getGameManager().getGameManager().getConfigDiamondLimit().getDiamondLimit()) {
                event.setCancelled(true);
                ItemStack stack = new ItemStack(Material.GOLD_INGOT);
                player.getWorld().dropItemNaturally(event.getBlock().getLocation(), stack);
            } else {
                profile.setMinedDiamonds(profile.getMinedDiamonds() + 1);
            }
        }
    }
}
