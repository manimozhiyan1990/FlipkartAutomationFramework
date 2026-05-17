package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void setup() throws IOException {

        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}