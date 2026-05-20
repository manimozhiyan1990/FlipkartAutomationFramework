package stepdefinition;

import driver.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.FlipkartPage;
import utils.CsvUtils;

import java.io.IOException;

public class FlipkartSteps {
    WebDriver driver;
    FlipkartPage page;

    public FlipkartSteps() {
        driver = DriverFactory.getDriver();
        page = new FlipkartPage(driver);
    }

    @Given("user navigate flipkart home page")
    public void homePage() {
        System.out.println("Flipkart Home Page Opened");
    }

    @When("user search {string}")
    public void userSearch(String id) throws IOException {
        page.clickLoginCross();
        String productName = CsvUtils.getCsvData(id);
        page.searchProduct(productName);
        page.clickProduct();
        page.switchWindows();
        System.out.println(driver.getCurrentUrl());
    }

    @And("user select variant if available")
    public void userSelectVariantIfAvailable() throws IOException, InterruptedException {
        if (page.isProductAvailable()) {

            page.selectAvailableColor();

            page.selectAvailableRam();

        } else {

            driver.navigate().back();

            System.out.println("Product Out Of Stock");
        }
    }


    @And("user click add to cart")
    public void userClickAddToCart() {
        page.addTocart();
    }

    @And("user enter the customer details")
    public void userEnterTheCustomerDetails() throws InterruptedException, IOException {
        page.clickPlaceOrder();
        page.enteruserDetails();
    }
}


