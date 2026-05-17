package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() throws IOException {

        ConfigReader config = new ConfigReader();

        String browser = config.getBrowser().toLowerCase();

        switch (browser) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid Browser");
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(config.getImplicitWait()));

        driver.get(config.getUrl());

        return driver;
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
        }
    }
}