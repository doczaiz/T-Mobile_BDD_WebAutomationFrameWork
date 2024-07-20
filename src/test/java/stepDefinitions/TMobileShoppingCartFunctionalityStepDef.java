package stepDefinitions;

import configuration.common.WebTestBase;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.TMobileShoppingCartFunctionality;

//import static configuration.common.GlobalReUsableMethods.*;

import static configuration.common.GlobalReUsableMethods.*;
import static pages.TMobileShoppingCartFunctionality.*;
import static webelements.TMobileShoppingCartPageWebElements.*;

public class TMobileShoppingCartFunctionalityStepDef extends WebTestBase {
    TMobileShoppingCartFunctionality tMobileShoppingCartFunctionality;

    public void getInit() {
        PageFactory.initElements(driver, TMobileShoppingCartFunctionality.class);
        tMobileShoppingCartFunctionality = new TMobileShoppingCartFunctionality(driver);
    }

    @And("^user clicks on the desire product(.+)$")
    public void user_clicks_on_the_desire_product(String product) {
        System.out.println(">>> user_clicks_on_the_desire_product");
        getInit();
        selectItemFromList(searchResultListWebEl, product);
        waitFor(3);
    }

    @Then("user selects the color {string}")
    public void user_selects_the_color(String color) {
        getInit();
        System.out.println(">>>> user_selects_the_color");
        selectFeature(colorListWebEl,color);
    }

    @Then("user selects the storage size {string}")
    public void user_selects_the_storage_size(String StorageSize) {
        getInit();
        System.out.println(">>>> user_selects_the_storage_size");
        selectFeature(storageSizesListWebEl, StorageSize);
    }

    @Then("user selects if existing or new customer")
    public void user_selects_if_existing_or_new_customer() {
        getInit();
        System.out.println(">>>> user_selects_if_existing_or_new_customer");
        fluentWaitUntilConditionMeet(newCustomerButton).click();
    }

    @Then("user selects to keep number or get a new number")
    public void user_selects_to_keep_number_or_get_a_new_number() {
        getInit();
        System.out.println(">>>> user_selects_to_keep_number_or_get_a_new_number");
        fluentWaitUntilConditionMeet(newNumberButton).click();
    }

    @Then("user selects to trade in or no trade in")
    public void user_selects_to_trade_in_or_no_trade_in() {
        getInit();
        System.out.println(">>>> user_selects_to_trade_in_or_no_trade_in");
        fluentWaitUntilConditionMeet(skipTradeInButton).click();
    }

    @And("user selects payment option")
    public void user_selects_payment_option() {
        getInit();
        System.out.println(">>>> user_selects_payment_option");
        selectItemFromListNew(paymentOptionWebEl, "Pay in full");
//        waitFor(5);
    }

    @Then("user adds the the product to cart")
    public void user_adds_the_the_product_to_cart() {
        System.out.println(">>>> user_adds_the_the_product_to_cart");
        getInit();
        fluentWaitUntilConditionMeet(addToCartButton).click();
        System.out.println("The Number Of Items In Cart : " + getTextOfHiddenElement());
        Assert.assertEquals(getTextOfHiddenElement(), getTextOfHiddenElement(), "the number of items in cart does not match");
    }

    @Then("user selects a phone plan {string}")
    public void user_selects_a_phone_plan(String planName) {
       getInit();
       waitFor(3);
        System.out.println(">>>> user_selects_a_phone_plan");
        menuIterator(planNamesListWebEl);
//        selectPhonePlan(planName);
        Assert.assertTrue(selectPhonePlan(planName),"The phone plan did not selected");
        waitFor(5);
        fluentWaitUntilConditionMeet(zipCodeInput).isDisplayed();
        zipCodeInput.clear();
        zipCodeInput.sendKeys("11226");
        waitFor(3);
        javaExecuterClickOnElement(submitButton);
        waitFor(3);
        javaExecuterClickOnElement(noDeviceProtection);
        javaExecuterClickOnElement(continueButton);
        javaExecuterClickOnElement(yesDeclineProtection);
        javaExecuterClickOnElement(skipAccessoriesButton);
        waitFor(3);
        beginCheckoutButton.click();
    }


}
