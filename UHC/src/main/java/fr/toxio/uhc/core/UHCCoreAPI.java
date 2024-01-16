package fr.toxio.uhc.core;


import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.event.IEventManager;
import fr.toxio.uhc.api.game.IGameManager;
import fr.toxio.uhc.api.game.config.biomecenter.IBiomeCenterManager;
import fr.toxio.uhc.api.menu.IMenuManager;
import fr.toxio.uhc.api.module.IModuleManager;
import fr.toxio.uhc.api.player.IUHCProfileManager;
import fr.toxio.uhc.api.power.IPowerManager;
import fr.toxio.uhc.api.role.IRoleManager;
import fr.toxio.uhc.api.team.ITeamManager;
import fr.toxio.uhc.core.event.EventManager;
import fr.toxio.uhc.core.game.GameManager;
import fr.toxio.uhc.core.game.config.biomecenter.BiomeCenterManager;
import fr.toxio.uhc.core.menu.MenuManager;
import fr.toxio.uhc.core.menu.MenuRunnable;
import fr.toxio.uhc.core.module.ModuleManager;
import fr.toxio.uhc.core.player.UHCProfileManager;
import fr.toxio.uhc.core.power.PowerManager;
import fr.toxio.uhc.core.role.RoleManager;
import fr.toxio.uhc.core.team.TeamManager;
import org.bukkit.plugin.java.JavaPlugin;

public class UHCCoreAPI extends UHCAPI {



    private UHCProfileManager uhcProfileManager;
    private RoleManager roleManager;
    private MenuManager menuManager;
    private PowerManager powerManager;
    private GameManager gameManager;
    private TeamManager teamManager;
    private MenuRunnable menuRunnable;
    private ModuleManager moduleManager;
    private EventManager eventManager;
    private BiomeCenterManager biomeCenterManager;

    public UHCCoreAPI(JavaPlugin plugin) {
        super(plugin);
    }


    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        this.uhcProfileManager = new UHCProfileManager();
        this.moduleManager = new ModuleManager();
        this.roleManager = new RoleManager();
        this.menuManager = new MenuManager();
        this.teamManager = new TeamManager();
        this.powerManager = new PowerManager();
        this.gameManager = new GameManager();
        this.eventManager = new EventManager(UHCAPI.get());
        this.menuRunnable = new MenuRunnable(UHCAPI.get());
        this.biomeCenterManager = new BiomeCenterManager();
    }

    @Override
    public void onDisable() {
    }

    @Override
    public IBiomeCenterManager getBiomeCenterManager() {
        return biomeCenterManager;
    }

    @Override
    public ITeamManager getTeamManager() {
        return teamManager;
    }

    @Override
    public IUHCProfileManager getPlayerManager() {
        return uhcProfileManager;
    }

    @Override
    public IGameManager getGameManager() {
        return this.gameManager;
    }

    @Override
    public IRoleManager getRoleManager() {
        return this.roleManager;
    }

    @Override
    public IMenuManager getMenuManager() {
        return this.menuManager;
    }


    @Override
    public IPowerManager getPowerManager() {
        return this.powerManager;
    }

    @Override
    public IEventManager getEventManager() {
        return eventManager;
    }

    @Override
    public IModuleManager getModuleManager() {
        return moduleManager;
    }
}
