package fr.toxio.uhc.core.module.timer;

import com.google.common.collect.Maps;
import fr.toxio.uhc.api.module.timer.ITimer;
import fr.toxio.uhc.api.module.timer.ITimerManager;

import java.util.Map;

public class TimerManager implements ITimerManager {

    Map<Class<? extends ITimer>,ITimer> timers;

    public TimerManager() {
        this.timers = Maps.newHashMap();
    }

    @Override
    public void registerTimer(Class<? extends ITimer> timerClass) throws InstantiationException, IllegalAccessException {
        ITimer timer = timerClass.newInstance();
        timers.put(timerClass, timer);
    }

    @Override
    public boolean isRegistered(Class<? extends ITimer> timerClass) {
        for (Class<? extends ITimer> timer : timers.keySet()) {
            if (timer.equals(timerClass)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<Class<? extends ITimer>,ITimer> getTimers() {
        return timers;
    }

}
