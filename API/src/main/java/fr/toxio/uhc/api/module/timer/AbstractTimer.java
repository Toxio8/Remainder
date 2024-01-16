package fr.toxio.uhc.api.module.timer;

import fr.toxio.uhc.api.UHCAPI;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class AbstractTimer implements ITimer {

    boolean positive;
    private String name;
    private int duration;
    private int minValue;
    private int maxValue;
    private boolean running;

    public AbstractTimer(String name, int initialDuration, int minValue, int maxValue, boolean positive) {
        this.name = name;
        this.duration = initialDuration;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.positive = positive;
        this.running = false;
    }

    public void startTimer() {
        this.running = true;
        BukkitRunnable runnable = (BukkitRunnable) new BukkitRunnable() {
            @Override
            public void run() {
                if (positive) {
                    if (maxValue < duration) {
                        setDuration(getDuration() + 1);
                        return;
                    }
                    onReveal();
                    this.cancel();
                    running = false;
                    return;
                }
                if (minValue <= getDuration()) {
                    onReveal();
                    this.cancel();
                    running = false;
                    return;
                }
                setDuration(getDuration() - 1);

            }
        }.runTaskTimer(UHCAPI.get().getPlugin(), 0, 20);
    }

    public abstract void onReveal();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int getMinValue() {
        return this.minValue;
    }

    @Override
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public int getMaxValue() {
        return this.maxValue;
    }

    @Override
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean getPositive() {
        return this.positive;
    }

    @Override
    public boolean setPositive(boolean positive) {
        return this.positive = positive;
    }
}
