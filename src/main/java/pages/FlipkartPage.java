package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CsvUtils;
import utils.ReusableUtils;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FlipkartPage extends ReusableUtils {
    By loginIgnore = By.xpath("//span[@role='button']");
    By searchButton = By.xpath("//input[contains(@placeholder,'Search for Products')]");
    By clicFirstProduct = By.xpath("(//a[contains(@href,'/p/') and @target='_blank'])[1]");
    By phoneColor = By.xpath("//div[contains(text(), 'Color')]/parent::div/following-sibling::div[1]//a");
    By phoneModel = By.xpath("//h1");
    By phonePrice = By.xpath("//div[contains(text(),'Total Amount')]/following-sibling::div//div");
    By cart = By.xpath("//*[local-name()='clipPath' and contains(@id,'AddToCart')]/ancestor::div[1]");
    By viewcart = By.xpath("//span[text()='Cart']");
    By placeOrderLocator = By.xpath("//div[text()='Buy this now'][1]");
    By userDetais = By.xpath("//input[@type='number']");
    By continueBtn = By.xpath("//button[text()='Continue']");
    By priceDetails = By.xpath("//div[contains(text(), 'Price Details')]/ancestor::div[contains(@style, 'box-shadow')][1]");

    public FlipkartPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginCross() {
        waitForVisible(loginIgnore).click();
    }

    public void searchProduct(String productName) throws IOException {
        waitForClickable(searchButton).click();
        WebElement search = driver.findElement(searchButton);
        search.sendKeys(productName);
        search.sendKeys(Keys.ENTER);

    }

    public void clickProduct() {
        waitForClickable(clicFirstProduct);
        jsClick(clicFirstProduct);
    }

    public void switchWindows() {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
        }
    }

    public void selectAvailableColor() {
        try {

            List<WebElement> colors = driver.findElements(phoneColor);

            for (WebElement color : colors) {

                String text = color.getAttribute("outerHTML").toLowerCase();

                if (!text.contains("out of stock")) {

                    jsClick(color);


                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("color variant is  not available for this mobile ");
        }

    }


    public void selectAvailableRam() {

        try {
            List<WebElement> ramOptions = driver.findElements(By.xpath("//div[contains(text(),'GB')]"));

            for (WebElement ram : ramOptions) {

                String text =
                        ram.getText().toLowerCase();

                if (!text.contains("out of stock")) {

                    jsScroll(ram);

                    WebElement model = driver.findElement(phoneModel);
                    System.out.println("Phone model :" + model.getText());


                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("This variant mobile is out of stock");
        }
    }

    public boolean isProductAvailable() {

        List<WebElement> outOfStock =
                driver.findElements(
                        By.xpath("//*[contains(text(),'Out of Stock')]"));

        return outOfStock.size() == 0;
    }

    public void addTocart() {
       waitForVisible(cart);
        jsClick(cart);
        jsClick(viewcart);
    }

    public void clickPlaceOrder() throws InterruptedException, IOException {
        WebElement details = driver.findElement(priceDetails);
        ScreenshotUtils.captureElementScreenshot(details,"Price details");
        WebElement price = driver.findElement(phonePrice);
        System.out.println("Phone price is :"+price.getText());
        try {
            Thread.sleep(3000);
            waitForVisible(placeOrderLocator);
            jsClick(placeOrderLocator);

        } catch (InterruptedException e) {
            System.out.println(" item not visible to click");
        }

    } public void enteruserDetails() throws InterruptedException {
        WebElement phoneNumber = driver.findElement(userDetais);
        waitForVisible(phoneNumber);
        phoneNumber.click();
        phoneNumber.sendKeys("7908119937");
        waitForClickable(continueBtn);
        jsClick(continueBtn);

    }
    //    public void clickVariant() throws InterruptedException, IOException {
//        jsClick(buyNow);
//
//        jsClick(phonecolor);
//        WebElement ramSize = driver.findElement(phoneRamsize);
//
//        jsClick(ramSize);
//
//        String variant = driver.findElement(phoneRamsize).getText();
//
//        String price = driver.findElement(phonePrice).getText();
//
//        System.out.println("Samsung Phone Variant : " + variant);
//        System.out.println("Samsung Phone Price : " + price);
//        // Thread.sleep(3000);
//    }

}
