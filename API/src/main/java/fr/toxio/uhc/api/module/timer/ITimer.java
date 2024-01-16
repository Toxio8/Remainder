package fr.toxio.uhc.api.module.timer;

public interface ITimer {

    String getName();
    void setName(String name);

    int getMinValue();
    void setMinValue(int minValue);

    int getMaxValue();
    void setMaxValue(int maxValue);

    int getDuration();
    void setDuration(int duration);

    boolean getPositive();

    boolean setPositive(boolean positive);
}
