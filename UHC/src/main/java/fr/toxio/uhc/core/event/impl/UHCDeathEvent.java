package fr.toxio.uhc.core.event.impl;

import fr.toxio.uhc.api.player.IUHCProfile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UHCDeathEvent extends Event implements Cancellable {

    public static HandlerList handlers;

    private IUHCProfile profile;
    private IUHCProfile killer;

    public UHCDeathEvent(IUHCProfile profile, IUHCProfile killer) {
        this.profile = profile;
        this.killer = killer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }


    static {
        handlers = new HandlerList();
    }

    public IUHCProfile getProfile() {
        return profile;
    }

    public IUHCProfile getKiller() {
        return killer;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
