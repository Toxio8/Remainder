package fr.toxio.uhc.api.game.config.border;

public interface IConfigBorder {

    int getInitialBorder();

    void setInitialBorder(int initialBorder);

    int getFinalBorder();


    void setFinalBorder(int finalBorder);


    double getBorderBlockPerSecond();


    void setBorderBlockPerSecond(int borderBlockPerSecond);

    int getStartTimeBorder();

    void setStartTimeBorder(int startTimeBorder);

}
