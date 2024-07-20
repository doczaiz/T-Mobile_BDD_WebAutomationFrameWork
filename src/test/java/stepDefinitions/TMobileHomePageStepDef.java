package stepDefinitions;


import configuration.common.WebTestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.TMobileHomePage;

import java.util.List;

import static configuration.common.GlobalReUsableMethods.*;
import static pages.TMobileHomePage.mouseHoverOverMenu;
import static pages.TMobileHomePage.tMobileLogoText;
import static pages.TMobileHomePage.*;
import static webelements.TMobileHomePageWebElements.*;


public class TMobileHomePageStepDef extends WebTestBase {
    TMobileHomePage tMobileHomePage;

    public void getInit() {
        PageFactory.initElements(driver, TMobileHomePage.class);
        tMobileHomePage = new TMobileHomePage(driver);
    }

    @Given("^user is on the T-Mobile homepage$")
    public void user_is_on_the_t_mobile_homepage() {
        System.out.println(getTitle());
    }

    @When("^user sees the T-Mobile logo$")
    public void user_sees_the_t_mobile_logo() {
        getInit();
        Assert.assertTrue(explicitWaitForElementUsingVisibilityOf(tMobileLogoText).isDisplayed());
        System.out.println(">>> The T-Mobile Logo is Displayed");
    }

    @And("user sees top navigate menus")
    public void user_sees_top_navigate_menus() {
        getInit();
        Assert.assertTrue(tMobileTopNavBarMenus.isDisplayed());
    }

    @Then("user validates menus name")
    public void user_validates_menus_name() {
        getInit();
        menuIterator(tMobileTopNavBarMenuWebElement);
        menuIterator(tMobileSideNavBarMenuWebElement);
    }

    @Then("^user validates menu items main menu(.+)$")
    public void user_validates_menu_items_main_menu(String mainMenu) {
        System.out.println(">>> user_validates_menu_items");
        getInit();
        System.out.println(" === Top left Menus === ");
        menuIterator(tMobileSideNavBarMenuWebElement);
        System.out.println(" === Top Right Menus === ");

        waitFor(3);
        mouseHoverOverMenu(tMobileTopNavBarMenuWebElement, mainMenu);
        if (mainMenu.contains("Plans")) {
            for (WebElement element : getListOfElementsByXpath(plansMenuListWebElement)) {
                if (!element.getText().isEmpty()) {
                    System.out.println("Plans item: " + element.getText());
                }
            }
            waitFor(3);
            } else if (mainMenu.contains("Phones & devices")) {
            for (WebElement element : getListOfElementsByXpath(phonesAndDevicesMenuListWebElement)) {
                if (!element.getText().isEmpty()) {
                    System.out.println("Devices Item : " + element.getText());
                }
            }
            waitFor(3);
            } else if (mainMenu.contains("Deals")) {
            for (WebElement element : getListOfElementsByXpath(dealsMenuListWebElement)) {
                if (!element.getText().isEmpty()) {
                    System.out.println("Deals Item : " + element.getText());
                }
            }
            waitFor(3);
            } else if (mainMenu.contains("Coverage")) {
            for (WebElement element : getListOfElementsByXpath(coverageMenuListWebElement)) {
                if (!element.getText().isEmpty()) {
                    System.out.println("Coverage Item : " + element.getText());
                }
            }
            waitFor(3);
            } else if (mainMenu.contains("Join Us")) {
            for (WebElement element : getListOfElementsByXpath(joinUsMenuListWebElement)) {
                if (!element.getText().isEmpty()) {
                    System.out.println("Join Us Item : " + element.getText());
                }
            }
            waitFor(3);
            } else {
            System.out.println("the menu does not match");
        }


    }
//    @Then("user validates menu items side menu")
//    public void user_validates_menu_items_side_menu() {
//        System.out.println(">>> user_should_validate_menu_items");
//        getInit();
////        selectItemFromList(tMobileSideNavBarMenuWebElement,sideMenu);
//
//    }

}
