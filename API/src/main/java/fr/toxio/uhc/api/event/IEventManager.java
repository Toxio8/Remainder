package fr.toxio.uhc.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public abstract class IEventManager {

    protected abstract void loadEvents();

    public abstract void callEvent(Event event);

    public abstract void registerEvent(Listener listener);
}
