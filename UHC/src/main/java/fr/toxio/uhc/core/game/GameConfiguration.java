package fr.toxio.uhc.core.game;

import fr.toxio.uhc.api.game.IGameConfiguration;


public class GameConfiguration implements IGameConfiguration {
    private String name;
    private int slots;
    private int appleDropRate;
    private boolean started;
    private boolean generating;

    public GameConfiguration() {
        this.name = "UHC";
        this.slots = 50 ;
        this.appleDropRate = 1;
        this.started = false;
        this.generating = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSlots() {
        return slots;
    }

    @Override
    public int getAppleDropRate() {
        return appleDropRate;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSlots(int slots) {
        this.slots = slots;
    }

    @Override
    public void setAppleDropRate(int appleDropRate) {
        this.appleDropRate = appleDropRate;
    }

    @Override
    public boolean isStarted() {
        return started;
    }
    @Override
    public void setStarted(boolean started) {
        this.started = started;
    }
    @Override
    public boolean isGenerating() {
        return generating;
    }
    @Override
    public void setGenerating(boolean generating) {
        this.generating = generating;
    }
}
