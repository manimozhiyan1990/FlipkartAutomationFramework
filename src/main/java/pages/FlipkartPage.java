package pages;

import base.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;

public class FlipkartPage extends ReusableMethods {
    By loginIgnore = By.xpath("//span[@role='button']");
    By searchButton = By.xpath("//input[contains(@placeholder,'Search for Products')]");
    By clickSamsungtProduct = By.xpath("//div[contains(text(),'Samsung Galaxy S25 FE 5G (Navy, 256 GB)')]");
    By phonecolor = By.xpath("//a[contains(@href,'white')]");
    By phoneRamsize = By.xpath("//div[contains(text(),'128 GB + 8 GB')]");
    By phonePrice = By.xpath("//div[text()='128 GB + 8 GB']/following-sibling::div[contains(text(),'₹')]");
    By cart = By.xpath("//*[local-name()='clipPath' and contains(@id,'AddToCart')]/ancestor::div[1]");
    By buyNow = By.xpath("//*[@dir='auto' and normalize-space()='Buy now']");
    By viewcart = By.xpath("//span[text()='Cart']");
    By placeOrder =By.xpath("//div[normalize-space()='Place order']");
    By userDetais = By.xpath("//input[@type='number']");
    By continueBtn = By.xpath("//button[text()='Continue']");

    public FlipkartPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginCross() {
        waitForVisible(loginIgnore).click();
    }

    public void searchProduct(String productName) {
        waitForClickable(searchButton).click();
        WebElement search = driver.findElement(searchButton);
        search.sendKeys(productName);
        search.sendKeys(Keys.ENTER);

    }

    public void clickProduct() {
        waitForClickable(clickSamsungtProduct);
        jsClick(clickSamsungtProduct);
    }

    public void switchWindows() {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
        }
    }

    public void clickVariant() throws InterruptedException {
        jsClick(buyNow);

        jsClick(phonecolor);
        WebElement ramSize = driver.findElement(phoneRamsize);

        jsClick(ramSize);

        String variant = driver.findElement(phoneRamsize).getText();

        String price = driver.findElement(phonePrice).getText();

        System.out.println("Samsung Phone Variant : " + variant);
        System.out.println("Samsung Phone Price : " + price);
        // Thread.sleep(3000);
    }

    public void addTocart() {
        waitForClickable(cart);
        jsClick(cart);
        jsClick(viewcart);
    }
    public void clickPlaceOrder(){
        waitForClickable(placeOrder);
        jsClick(placeOrder);
    }
    public void enteruserDetails() throws InterruptedException {
        WebElement phoneNumber = driver.findElement(userDetais);
        phoneNumber.click();
        phoneNumber.sendKeys("7299230515");
        waitForClickable(continueBtn);
        jsClick(continueBtn);

    }
}
