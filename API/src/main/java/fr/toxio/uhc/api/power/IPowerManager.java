package fr.toxio.uhc.api.power;

import com.google.common.collect.Lists;

import java.util.List;

public interface IPowerManager {

    List<AbstractPower> registeredPowers = Lists.newArrayList();

    void registerPower(AbstractPower abstractPower);

    void unregisterPower(AbstractPower abstractPower);

    List<AbstractPower> getPowers();

    AbstractPower getPower(String name);
}
