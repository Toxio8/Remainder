package fr.toxio.uhc.api.module.scenario;


import java.util.List;

public interface IScenarioManager {

    List<AbstractScenario> getScenarios();

    List<AbstractScenario> getEnabledScenarios();

    void registerScenario(AbstractScenario abstractScenario);

}
