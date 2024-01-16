package fr.toxio.uhc.core;

import fr.toxio.uhc.api.UHCAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class UHC extends JavaPlugin {

    @Override
    public void onEnable() {
        UHCAPI.get().onEnable();
    }

    @Override
    public void onDisable() {
        UHCAPI.get().onDisable();
    }

    @Override
    public void onLoad() {
        UHCAPI.setApi(new UHCCoreAPI(this));
        UHCAPI.get().onLoad();
    }

}
