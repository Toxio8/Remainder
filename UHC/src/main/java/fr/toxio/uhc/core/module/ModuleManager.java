package fr.toxio.uhc.core.module;


import fr.toxio.uhc.api.module.IModule;
import fr.toxio.uhc.api.module.IModuleManager;

public class ModuleManager implements IModuleManager {


    private IModule iModule;

    public ModuleManager() {
        this.iModule = null;
    }

    @Override
    public IModule getModule() {
        return iModule;
    }

    @Override
    public void setModule(IModule iModule) {
        this.iModule = iModule;
    }
}
