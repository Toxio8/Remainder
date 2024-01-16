package fr.toxio.uhc.api.module.win;

public interface IWinManager {


    boolean checkWin();

    void onWin();

    boolean isWin();

    void setWin(boolean win);
}
