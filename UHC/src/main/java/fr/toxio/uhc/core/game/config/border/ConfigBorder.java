package fr.toxio.uhc.core.game.config.border;

import fr.toxio.uhc.api.game.config.border.IConfigBorder;

public class ConfigBorder implements IConfigBorder {

    private int initalBorder = 1000;
    private int finalBorder = 500;
    private int blockPerSecond = 1;
    private int startTime = (60 * 60) + (60 * 10); // seconds

    @Override
    public int getInitialBorder() {
        return this.initalBorder;
    }

    
    @Override
    public void setInitialBorder(int initialBorder) {
        this.initalBorder = initialBorder;
    }

    @Override
    public int getFinalBorder() {
        return this.finalBorder;
    }

    @Override
    public void setFinalBorder(int finalBorder) {
        this.finalBorder = finalBorder;
    }

    @Override
    public double getBorderBlockPerSecond() {
        return this.blockPerSecond;
    }

    @Override
    public void setBorderBlockPerSecond(int blockPerSecond) {
        this.blockPerSecond = blockPerSecond;
    }

    @Override
    public int getStartTimeBorder() {
        return this.startTime;
    }

    @Override
    public void setStartTimeBorder(int startTimeBorder) {
        this.startTime = startTimeBorder;
    }

}
