package fr.toxio.uhc.core.power;

import fr.toxio.uhc.api.power.AbstractPower;
import fr.toxio.uhc.api.power.IPowerManager;

import java.util.List;

public class PowerManager implements IPowerManager {


    @Override
    public void registerPower(AbstractPower abstractPower) {
        registeredPowers.add(abstractPower);
    }

    @Override
    public void unregisterPower(AbstractPower abstractPower) {
        registeredPowers.remove(abstractPower);
    }

    @Override
    public List<AbstractPower> getPowers() {
        return registeredPowers;
    }

    @Override
    public AbstractPower getPower(String name) {
        for (AbstractPower abstractPower : registeredPowers) {
            abstractPower.getName().equals(name);
            return abstractPower;
        }
        return null;
    }
}
