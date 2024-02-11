package fr.toxio.uhc.core.event;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.event.IEventManager;
import fr.toxio.uhc.core.game.config.enchant.ConfigEnchantManager;
import fr.toxio.uhc.core.menu.MenuListener;
import fr.toxio.uhc.core.module.death.DeathListener;
import fr.toxio.uhc.core.power.PowerListener;
import fr.toxio.uhc.core.worldgen.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public class EventManager extends IEventManager {

    private final UHCAPI uhcapi;

    public EventManager(UHCAPI uhcapi) {
        this.uhcapi = uhcapi;
        this.loadEvents();
    }

    @Override
    protected void loadEvents() {
        this.registerEvent(new PowerListener(uhcapi));
        this.registerEvent(new MenuListener(uhcapi));
        this.registerEvent(new DeathListener());
        this.registerEvent(new ConfigEnchantManager());
        this.registerEvent(new WorldManager(uhcapi));

    }

    @Override
    public void callEvent(Event event) {
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    @Override
    public void registerEvent(Listener listener) {
        uhcapi.getPlugin().getServer().getPluginManager().registerEvents(listener,uhcapi.getPlugin());
    }
}
