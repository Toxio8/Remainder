package fr.toxio.uhc.api.game;

import fr.toxio.uhc.api.game.config.border.IConfigBorder;
import fr.toxio.uhc.api.game.config.diamond.IConfigDiamondLimit;
import fr.toxio.uhc.api.game.config.enchant.IConfigEnchant;
import fr.toxio.uhc.api.game.config.inv.IConfigInv;
import fr.toxio.uhc.api.module.death.IDeathManager;
import fr.toxio.uhc.api.module.timer.ITimerManager;
import fr.toxio.uhc.api.module.win.IWinManager;

public interface IGameManager {

    IWinManager getWinManager();

    IConfigEnchant getConfigEnchant();

    void setGameStates(GameStates gameStates);

    GameStates getGameStates();

    IGameConfiguration getGameConfiguration();


    IConfigBorder getConfigBorder();

    void setConfigBorder(IConfigBorder iConfigBorder);

    void setGameManager(IGameManager gameManager);

    ITimerManager getTimerManager();

    IConfigDiamondLimit getConfigDiamondLimit();

    IConfigInv getConfigInv();

    IDeathManager getDeathManager();

    void setDeathManager(IDeathManager deathManager);
}
