package fr.toxio.uhc.api;


import fr.toxio.uhc.api.event.IEventManager;
import fr.toxio.uhc.api.game.IGameManager;
import fr.toxio.uhc.api.game.config.biomecenter.IBiomeCenterManager;
import fr.toxio.uhc.api.menu.IMenuManager;
import fr.toxio.uhc.api.module.IModuleManager;
import fr.toxio.uhc.api.player.IUHCProfileManager;
import fr.toxio.uhc.api.power.IPowerManager;
import fr.toxio.uhc.api.role.IRoleManager;
import fr.toxio.uhc.api.team.ITeamManager;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class UHCAPI {

    private static UHCAPI instance1;
    private final JavaPlugin plugin;

    public UHCAPI(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setApi(UHCAPI instance) {
        if (instance1 != null) {
            throw new IllegalStateException("instance aldready set");
        }
        instance1 = instance;
    }

    public static UHCAPI get() {
        return instance1;
    }

    public abstract IPowerManager getPowerManager();


    public abstract IBiomeCenterManager getBiomeCenterManager();

    public abstract ITeamManager getTeamManager();

    public abstract IUHCProfileManager getPlayerManager();


    public abstract IGameManager getGameManager();

    public abstract IRoleManager getRoleManager();

    public abstract IMenuManager getMenuManager();



    public abstract void onLoad();
    public abstract void onEnable();
    public abstract void onDisable();

    public abstract IEventManager getEventManager();

    public abstract IModuleManager getModuleManager();
}

