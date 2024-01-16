package fr.toxio.uhc.api.module;


import fr.toxio.uhc.api.module.timer.ITimerManager;
import fr.toxio.uhc.api.module.win.IWinManager;

public interface IModule {

    String getName();

    IWinManager getWinManager();

    ITimerManager getTimerManager();

}
