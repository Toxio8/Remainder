package fr.toxio.uhc.core.module.scenario.impl;

import fr.toxio.uhc.api.module.scenario.AbstractScenario;
import org.bukkit.Material;

public class Timber extends AbstractScenario {

    public Timber() {
        super(Material.WOOD, "§bTimber", "Timber est scénario qui casse les block de bois", false);
    }

    @Override
    public boolean isEnabledAfterPvP() {
        return false;
    }

    @Override
    public void onGameStart() {

    }
}
