package fr.toxio.uhc.core.event.impl;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StartGameEvent extends Event implements Cancellable {

    private static final HandlerList handlers;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    static {
        handlers = new HandlerList();
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
