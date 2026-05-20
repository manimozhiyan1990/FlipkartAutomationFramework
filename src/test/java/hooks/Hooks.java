package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;

import java.io.IOException;

public class Hooks {

    @Before
    public void setup() throws IOException {

        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {

            ScreenshotUtils.captureScreenshot(scenario.getName());
        }

            DriverFactory.quitDriver();
        }
    }