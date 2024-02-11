package fr.toxio.uhc.core.game.inventoryconfig;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.menu.AbstractMenu;
import fr.toxio.uhc.api.menu.buttons.SimpleButton;
import fr.toxio.uhc.api.utils.GlobalUtils;
import fr.toxio.uhc.api.utils.ItemBuilder;
import fr.toxio.uhc.core.UHC;
import fr.toxio.uhc.core.worldgen.ChunkLoader;
import org.bukkit.*;
import org.bukkit.entity.Player;
import sun.java2d.pipe.SpanShapeRenderer;

public class WorldMenu extends AbstractMenu {


    public WorldMenu() {
        super(54, "Menu des Mondes");
    }

    @Override
    public void loadItems() {
        SimpleButton createWorldButton = new SimpleButton(Material.GRASS,"§lCréer le monde",20,(player, itemStack) -> {
            if (UHCAPI.get().getWorldManager().getWorld() != null && UHCAPI.get().getWorldManager().getWorld().getWorldFolder().exists()) {
                Bukkit.unloadWorld(UHCAPI.get().getWorldManager().getWorld(), false);
                GlobalUtils.deleteWorld(UHCAPI.get().getWorldManager().getWorld().getWorldFolder());
                player.sendMessage("Le monde a étais supprimer");
            }
            player.sendMessage("Un nouveau monde est entrain de ce créer, attendez une dizaine de seconde");
            player.closeInventory();
            World world = WorldCreator.name("game").createWorld();
            UHCAPI.get().getWorldManager().setWorld(world);
        });

        SimpleButton generateButton = new SimpleButton(Material.DIRT, "§lPrégénération du monde",24,(player, itemStack) -> {
            if (!UHCAPI.get().getGameManager().getGameConfiguration().isGenerating()) {
                UHCAPI.get().getWorldManager().startPregen();
            } else {
                player.sendMessage("Vous ne pouvez pas prégénérer lorsqu'il y'a deja une prégénération en cours");
            }
        });

        SimpleButton biomeChoiceButton = new SimpleButton(Material.SAPLING,"§lChoisir le biome au centre",31, (player, itemStack) ->  {
            UHCAPI.get().getMenuManager().openMenu(player,new BiomeMenu());
        });

        SimpleButton tpButton = new SimpleButton(Material.WOOD_SWORD,"Tp",6,(player, itemStack) -> {
           player.teleport(new Location(Bukkit.getWorld("game"), 0 ,100 ,0));
           player.sendMessage("Vous avez était téléporter");
        });

        getButtons().add(tpButton);
        getButtons().add(createWorldButton);
        getButtons().add(generateButton);
        getButtons().add(biomeChoiceButton);
    }

    @Override
    public boolean isUpdateOnClick() {
        return true;
    }
}
