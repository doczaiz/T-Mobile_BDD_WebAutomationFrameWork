package stepDefinitions;

import configuration.common.WebTestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.TMobileSearchFunctionality;

import static configuration.common.GlobalReUsableMethods.*;
import static configuration.common.GlobalReUsableMethods.verifyIfElementDisplayedAndClickOn;
import static pages.TMobileSearchFunctionality.searchButton;
import static pages.TMobileSearchFunctionality.*;
import static webelements.TMobileSearchFunctionalityWebElements.searchResultItemsWebEl;
import static webelements.TMobileSearchFunctionalityWebElements.searchResultKeyWordWebElCSS;
import static webelements.TMobileShoppingCartPageWebElements.searchResultListWebEl;

public class TMobileSearchFunctionalityStepDef extends WebTestBase {

    TMobileSearchFunctionality tMobileSearchFunctionality;
    public void getInit() {
        PageFactory.initElements(driver, TMobileSearchFunctionality.class);
        tMobileSearchFunctionality = new TMobileSearchFunctionality(driver);
    }

    @Then("user clicks on search button")
    public void user_clicks_on_search_button() {
        getInit();
        System.out.println(">>> user_clicks_on_search_button");
        verifyIfElementDisplayedAndClickOn(searchButton);
    }
    @And("user enters name of phone {string}")
    public void user_enters_name_of_phone(String product) {
        getInit();
        System.out.println(">>> user_enters_name_of_phone");
        searchInPut.sendKeys(product);
    }
    @And("user clicks on search submit button or clicks on enter")
    public void user_clicks_on_search_submit_button_or_clicks_on_enter() {
        getInit();
        System.out.println(">>>> user_clicks_on_search_submit_button");
        searchSubmitButton.click();
    }
    @Then("user should be able to see the correct result {string}")
    public void user_should_be_able_to_see_the_correct_result(String product) {
        getInit();
        System.out.println(">>>> user_sees_the_correct_result");
         String result = searchResultHeader.getText();
        System.out.println("the search header result : " + searchResultHeader.isDisplayed());
        Assert.assertTrue(verifySearchResultList(searchResultItemsWebEl,product));

    }
    @And("user enters name of phone {string} and model {string}")
    public void userEntersNameOfPhoneAndModule(String brand, String model) {
        getInit();
        System.out.println(">>> user_enters_name_of_phone");
        searchInPut.sendKeys(brand+" "+model);
    }

    @Then("user should sees the correct result containing the brand {string} and module {string}")
    public void userShouldSeesTheCorrectResultContainingTheBrandAndModule(String brand, String model) {
        getInit();
        System.out.println(">>>> user_sees_the_correct_result");
        Assert.assertTrue(verifySeeSearchResults(searchResultItemsWebEl,brand,model));
    }


    @Then("user should be able to see accurate result {string}")
    public void userShouldBeAbleToSeeAccurateResult(String product) {
        getInit();
        System.out.println(">>>> user_sees_the_correct_result");
        verifySearchResultList(searchResultKeyWordWebElCSS,product);
    }

    @Then("user should be able to see accurate result with keyword {string}")
    public void userShouldBeAbleToSeeAccurateResultWithKeyword(String keyWord) {
        getInit();
        System.out.println(">>>> user_sees_the_correct_result");
        String result = searchResultHeader.getText();
        System.out.println("the search header result : " + searchResultHeader.isDisplayed());
        Assert.assertTrue(verifySeeSearchResults(searchResultKeyWordWebElCSS,keyWord));

    }
}
