package stepdefinition;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.FlipkartPage;

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
    public void userSearch(String productName) {
        page.clickLoginCross();
        page.searchProduct(productName);
        page.clickProduct();
        page.switchWindows();
        System.out.println(driver.getCurrentUrl());
    }

    @And("user select variant of the product")
    public void userSelectVariantOfTheProduct() throws InterruptedException {

        page.clickVariant();
    }

    @And("user click add to cart")
    public void userClickAddToCart() {
        page.addTocart();
    }
    @And("user enter the customer details")
    public void userEnterTheCustomerDetails() throws InterruptedException {
        page.clickPlaceOrder();
        page.enteruserDetails();
    }
}

