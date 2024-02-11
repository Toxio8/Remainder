package fr.toxio.uhc.core.game;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.game.GameStates;
import fr.toxio.uhc.api.game.IGameConfiguration;
import fr.toxio.uhc.api.game.IGameManager;
import fr.toxio.uhc.api.game.config.border.IConfigBorder;
import fr.toxio.uhc.api.game.config.diamond.IConfigDiamondLimit;
import fr.toxio.uhc.api.game.config.enchant.IConfigEnchant;
import fr.toxio.uhc.api.game.config.inv.IConfigInv;
import fr.toxio.uhc.api.module.IModule;
import fr.toxio.uhc.api.module.death.IDeathManager;
import fr.toxio.uhc.api.module.timer.ITimerManager;
import fr.toxio.uhc.api.module.win.IWinManager;
import fr.toxio.uhc.core.game.config.border.ConfigBorder;
import fr.toxio.uhc.core.game.config.diamond.ConfigDiamondLimit;
import fr.toxio.uhc.core.game.config.enchant.ConfigEnchant;
import fr.toxio.uhc.core.game.config.inv.ConfigInv;
import fr.toxio.uhc.core.module.death.DeathManager;
import fr.toxio.uhc.core.module.timer.TimerManager;
import fr.toxio.uhc.core.module.win.WinManager;

public class GameManager implements IGameManager {

    private GameStates gameStates;
    private GameConfiguration gameConfiguration;
    private IGameManager gameManager;
    private IWinManager winManager;
    private ITimerManager timerManager;
    private IConfigEnchant configEnchant;
    private IConfigDiamondLimit configDiamondLimit;
    private IConfigBorder iConfigBorder;
    private IConfigInv configInv;
    private IDeathManager deathManager;



    public GameManager() {
        this.gameConfiguration = new GameConfiguration();
        this.timerManager = new TimerManager();
        this.configEnchant = new ConfigEnchant();
        this.configDiamondLimit = new ConfigDiamondLimit();
        this.iConfigBorder = new ConfigBorder();
        this.configInv = new ConfigInv();
        this.deathManager = new DeathManager();
        this.gameStates = GameStates.WAITING;
        IModule abstractModule = UHCAPI.get().getModuleManager().getModule();
        if (abstractModule == null) {
            this.winManager = new WinManager();
            this.deathManager = new DeathManager();
        } else {
            this.winManager = abstractModule.getWinManager();
            this.deathManager = abstractModule.getDeathManager();
        }
    }

    @Override
    public GameStates getGameStates() {
        return gameStates;
    }

    @Override
    public IWinManager getWinManager() {
        return this.winManager;
    }

    @Override
    public IConfigEnchant getConfigEnchant() {
        return this.configEnchant;
    }

    @Override
    public void setGameStates(GameStates gameStates) {
        this.gameStates = gameStates;
    }

    @Override
    public IGameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }


    @Override
    public void setGameManager(IGameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public ITimerManager getTimerManager() {
        return timerManager;
    }

    @Override
    public IConfigDiamondLimit getConfigDiamondLimit() {
        return this.configDiamondLimit;
    }

    @Override
    public IConfigBorder getConfigBorder() {
        return iConfigBorder;
    }

    @Override
    public void setConfigBorder(IConfigBorder iConfigBorder) {
        this.iConfigBorder = iConfigBorder;
    }
    @Override
    public IConfigInv getConfigInv() {
        return configInv;
    }
    @Override
    public IDeathManager getDeathManager() {
        return deathManager;
    }

    public void setDeathManager(IDeathManager deathManager) {
        this.deathManager = deathManager;
    }
}
