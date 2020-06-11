package appline.stepdefs;

import appline.PropsSettings;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Properties;


public class Hooks {

    @Before
    public void start() {
        Properties properties = PropsSettings.getInstance().getProperties();
        BaseSteps.init();
        BaseSteps.getSite(properties.getProperty("url"));
    }

    @After
    public void quit() {
        BaseSteps.quit();
    }
}
