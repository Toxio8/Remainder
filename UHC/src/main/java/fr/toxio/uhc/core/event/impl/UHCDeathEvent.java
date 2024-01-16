package fr.toxio.uhc.core.event.impl;

import fr.toxio.uhc.api.player.IUHCProfile;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UHCDeathEvent extends Event {

    public static HandlerList handlerList;

    private IUHCProfile profile;
    private IUHCProfile killer;

    public UHCDeathEvent(IUHCProfile profile, IUHCProfile killer) {
        this.profile = profile;
        this.killer = killer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    static {
        handlerList = new HandlerList();
    }

    public IUHCProfile getProfile() {
        return profile;
    }

    public IUHCProfile getKiller() {
        return killer;
    }
}
