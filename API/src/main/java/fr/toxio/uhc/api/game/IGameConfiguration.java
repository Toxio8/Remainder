package fr.toxio.uhc.api.game;

public interface IGameConfiguration {

    String getName();

    int getSlots();

    int getAppleDropRate();

    void setName(String name);

    void setSlots(int slots);

    void setAppleDropRate(int appleDropRate);


}
