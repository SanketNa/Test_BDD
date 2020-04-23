package StepDefination;

import PageObjects.PageObjects;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefination extends PageObjects {

    @Given("^Open the Chrome and launch the application$")
    public void open_the_Chrome_and_launch_the_application() throws Throwable {

        browserInitialise();
            }

    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable {
        flipkartLogin();

    }

    @Then("^Search product and in cart$")
    public void Search_product_and_in_cart() throws Throwable {
        flipkartHomePage();
    }

    @And("^Verify the Product Page$")
    public void Verify_the_Product_Page() throws Throwable {
        flipkartProuctPage();
    }

    @And("^Verify the Cart$")
    public void Verify_the_Cart() throws Throwable {
        flipkartCart();
    }

    @And("^Verify the Order Page$")
    public void Verify_the_Order_Page() throws Throwable {
        flipkartOrderPage();
    }

}
