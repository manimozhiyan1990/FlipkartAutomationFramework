package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ReusableMethods {
    protected WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions action;
    Select select;

    public ReusableMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        this.js = (JavascriptExecutor)driver;
        this.action = new Actions(driver);
    }

    //====================================WaitMethod=============================================
    public WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));

    }
    public boolean waitForUrlContains(String name){
        return wait.until(ExpectedConditions.urlContains(name));
    }

    public void waitForVisibleSendKeys(By locator, String value) {
        waitForVisible(locator).sendKeys(value);
    }

    public void waitForClickAction(By locator) {
        waitForClickable(locator).click();
    }

    public WebElement fluentWaitVisible(By locator){

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //    =================================JavaScript Method ====================================
    public void jsScroll(By locator) {
        js.executeScript("arguments[0].scrollIntoView();", waitForVisible(locator));
    }
    public void jsScroll(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", waitForVisible(element));
    }

    public void jsClick(By locator) {
        js.executeScript("arguments[0].click();", waitForVisible(locator));
    }
    public void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }
    public void jsRefreshPage() {
        js.executeScript("location.reload();");
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollByPixel(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public void scrollCenter(WebElement element){
        js.executeScript("arguments[0].scrollIntoView({block:'center'});" , element);
    }

    //    ==============================Action===========================
    public void mouseHover(WebElement element) {
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void mouseHoverClick(WebElement element) {
        action.moveToElement(element).click().perform();
    }

    public void doubleClick(WebElement element) {
        action.doubleClick(element).click().perform();
    }

    public void rightClick(WebElement element) {
        action.contextClick(element).perform();
    }

    public void delayclick(WebElement element) {
        action.moveToElement(element).pause(Duration.ofSeconds(2000)).click().perform();
    }

    //    ===============Action method By locator
    public void hover(By locator) {
        action.moveToElement(waitForVisible(locator)).perform();
    }

    public void actionClick(By locator) {
        action.moveToElement(waitForVisible(locator)).click().perform();
    }

    public void delayClick(WebElement element) {
        action.moveToElement(element)
                .pause(Duration.ofSeconds(2))
                .click()
                .perform();
    }

    //    ============================ Frame Handling ==============================================
    public void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
    //===================Drop Down======================================

    public void selectByText(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public void takeScreenshot(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File dest = new File("C:\\Users\\user\\Documents\\GitHub\\CucumberFrameWork\\target\\screenshot\\yatra\\" + imageName + ".png");
        FileHandler.copy(src, dest);
    }
    public void logWhereAmI(String step) {
        System.out.println("=== " + step + " ===");
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Handles: " + driver.getWindowHandles().size());
    }

}

