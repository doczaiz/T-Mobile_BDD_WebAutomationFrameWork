package pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

import static webelements.TMobileSearchFunctionalityWebElements.*;


public class TMobileSearchFunctionality extends WebTestBase {

    public TMobileSearchFunctionality(WebDriver driver){
        PageFactory.initElements(WebTestBase.driver, this);
    }

    @FindBy(xpath = searchButtonWebEl)
    public static WebElement searchButton;
    @FindBy(xpath = searchSubmitButtonWebEl)
    public static WebElement searchSubmitButton;
    @FindBy(xpath = searchInPutWebEl)
    public static WebElement searchInPut;
    @FindBy(xpath = searchResultHeaderWebEl)
    public static WebElement searchResultHeader;


    public static boolean verifySeeSearchResults(String locator,String brand, String model) {
        // Locate the list of search results
        List<WebElement> searchResults = driver.findElements(By.cssSelector(locator));

        boolean allResultsContainProduct = false;

        // Iterate through the list of search results and check for the presence of "nokia" and "g310"
        for (WebElement result : searchResults) {
            String resultText = result.getText();
//            WebElement brandNameElement = result.findElement(By.xpath("//a//div[@class=\"phx:col-fill\"]"));
//            WebElement productModelElement = result.findElement(By.className("class=\"phx:type-section-2 line-clamp clamp-count-2\""));
//            System.out.println("brand Name : "+brandNameElement);
//
            if (resultText.contains(brand) && resultText.contains(model)) {
                System.out.println("All search results contain the brand name "+brand+" and model "+model);
                allResultsContainProduct = true;
            }
        }
        if (!allResultsContainProduct) {
            System.out.println("Some search results do not contain the brand name "+brand+" and model "+model);
        }
        return allResultsContainProduct;
    }

    public static boolean verifySeeSearchResults(String locator,String keyWord) {
        // Locate the list of search results
        List<WebElement> searchResults = driver.findElements(By.cssSelector(locator));

        boolean allResultsContainProduct = false;

        // Iterate through the list of search results and check for the presence of "nokia" and "g310"
        for (WebElement result : searchResults) {
            String resultText = result.getText().toLowerCase();
//            WebElement brandNameElement = result.findElement(By.xpath("//a//div[@class=\"phx:col-fill\"]"));
//            WebElement productModelElement = result.findElement(By.className("class=\"phx:type-section-2 line-clamp clamp-count-2\""));
            System.out.println("keyWord Name : "+keyWord);
            System.out.println("keyWord Name : "+resultText);
//
            if (resultText.contains(keyWord.toLowerCase())) {
                System.out.println("All search results contain the keyWord name "+keyWord);
                allResultsContainProduct = true;
            }
        }
        if (!allResultsContainProduct) {
            System.out.println("Some search results do not contain the keyWord name "+keyWord);
        }
        return allResultsContainProduct;
    }
}
