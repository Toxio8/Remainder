package fr.toxio.uhc.core.module.scenario;

import com.google.common.collect.Lists;
import fr.toxio.uhc.api.module.scenario.AbstractScenario;
import fr.toxio.uhc.api.module.scenario.IScenarioManager;
import fr.toxio.uhc.core.module.scenario.impl.Timber;

import java.util.List;
import java.util.Map;

public class ScenarioManager implements IScenarioManager {

    public final List<AbstractScenario> scenarios;

    public ScenarioManager() {
        this.scenarios = Lists.newArrayList();
    }

    @Override
    public List<AbstractScenario> getScenarios() {
        return scenarios;
    }

    public AbstractScenario getScenario(AbstractScenario scenario) {
        for (AbstractScenario scenarios : scenarios) {
            if (scenarios.equals(scenario)) {
                return scenarios;
            }
        }
        return null;
    }

    @Override
    public List<AbstractScenario> getEnabledScenarios() {
        List<AbstractScenario> activeScenarios = Lists.newArrayList();
        for (AbstractScenario scenarios : scenarios) {
            if (scenarios.isActive()) {
                activeScenarios.add(scenarios);
            }
        }
        return activeScenarios;
    }

    @Override
    public void registerScenario(AbstractScenario abstractScenario) {
        if (scenarios.contains(abstractScenario)) {
            System.out.println(abstractScenario + "is already registered");
            return;
        }
        scenarios.add(abstractScenario);
    }


}
