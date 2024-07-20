package pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static configuration.common.GlobalReUsableMethods.getListOfElementsByXpath;
import static configuration.common.GlobalReUsableMethods.mouseHoverByWebElementWithPerform;
import static webelements.TMobileHomePageWebElements.*;


public class TMobileHomePage extends WebTestBase {


    @FindBy(xpath = tMobileLogoWebElement)
    public static WebElement tMobileLogoText;
    @FindBy(xpath = tMobileTopNavBarMenuWebElement)
    public static WebElement tMobileTopNavBarMenus;
    @FindBy(xpath = plansMenuListWebElement)
    public static WebElement plansMenuList;



    public TMobileHomePage(WebDriver driver) {
        PageFactory.initElements(WebTestBase.driver, this);
    }


    public static void mouseHoverOverMenu(String locator, String menuName){
        for (WebElement element : getListOfElementsByXpath(tMobileTopNavBarMenuWebElement)) {
            System.out.println("Actual Item : "+element.getText());
            if (element.getText().equalsIgnoreCase(menuName.substring(1))) {
                mouseHoverByWebElementWithPerform(element);
                break;
            } else {
                System.out.println("element does not match with : " + menuName);
            }
        }
        waitFor(3);
    }



}
