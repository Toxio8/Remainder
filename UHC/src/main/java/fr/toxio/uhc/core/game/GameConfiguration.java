package fr.toxio.uhc.core.game;

import fr.toxio.uhc.api.game.IGameConfiguration;


public class GameConfiguration implements IGameConfiguration {
    private String name;
    private int slots;
    private int appleDropRate;



    public GameConfiguration() {
        this.name = "UHC";
        this.slots = 50 ;
        this.appleDropRate = 1;
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


}
