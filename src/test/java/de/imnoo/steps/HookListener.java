package de.imnoo.steps;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import de.imnoo.controls.driver.PageDriverController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HookListener implements En {

    private static final Logger LOG = LoggerFactory.getLogger(HookListener.class);

    public HookListener() {

        Before((Scenario scenario) ->
        {
            LOG.debug("onBeforeScenario [{}]", scenario.getName());
        });

        After((Scenario scenario) ->
        {
            LOG.debug("onAfterScenario [{}]", scenario.getName());
            PageDriverController.close();
        });
    }
}
