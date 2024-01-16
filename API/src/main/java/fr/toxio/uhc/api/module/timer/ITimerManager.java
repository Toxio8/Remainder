package fr.toxio.uhc.api.module.timer;

import java.util.Map;

public interface ITimerManager {

    void registerTimer(Class<? extends ITimer> timerClass) throws InstantiationException, IllegalAccessException;

    boolean isRegistered(Class<? extends ITimer> timerClass);

    Map<Class<? extends ITimer>,ITimer> getTimers();
}
