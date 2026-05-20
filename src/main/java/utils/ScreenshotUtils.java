package utils;

import driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    public static void captureScreenshot(String screenshotName)
            throws IOException {

        TakesScreenshot ts =(TakesScreenshot) DriverFactory.getDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = String.valueOf(System.currentTimeMillis());

        File destination = new File("target/screenshots/scenario/" + screenshotName + "_" + timeStamp + ".png");

        FileHandler.copy(source, destination);

    }
    public static void captureElementScreenshot(
            WebElement element,
            String screenshotName)
            throws IOException {

        File source = element.getScreenshotAs(OutputType.FILE);

        String timeStamp = String.valueOf(System.currentTimeMillis());

        File destination = new File("target/screenshots/elementscreenshot/" + screenshotName + "_" + timeStamp + ".png");

        FileHandler.copy(source, destination);

    }
}