package fr.toxio.uhc.core.commands;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.core.game.inventoryconfig.MainMenu;
import fr.toxio.uhc.core.power.PowerListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.sound.midi.MidiFileFormat;

public class ConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        UHCAPI.get().getMenuManager().openMenu(player,new MainMenu());
        Bukkit.broadcastMessage("Test");
        return true;
    }
}
