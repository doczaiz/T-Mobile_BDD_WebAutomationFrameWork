package pages;

import configuration.common.WebTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static configuration.common.GlobalReUsableMethods.SelectItemFromListWithAssertion;
import static configuration.common.GlobalReUsableMethods.menuIterator;
import static webelements.TMobileShoppingCartPageWebElements.*;

public class TMobileShoppingCartFunctionality extends WebTestBase {

    public TMobileShoppingCartFunctionality(WebDriver driver) {
        PageFactory.initElements(WebTestBase.driver, this);
    }

    @FindBy(xpath = searchResultListWebEl)
    public static WebElement searchResultList;
    @FindBy(xpath = newCustomerButtonWebEl)
    public static WebElement newCustomerButton;
    @FindBy(xpath = productNotForSaleWebEl)
    public static WebElement productNotForSale;
    @FindBy(xpath = newNumberButtonWebEl)
    public static WebElement newNumberButton;
    @FindBy(xpath = skipTradeInButtonWebEl)
    public static WebElement skipTradeInButton;
    @FindBy(xpath = addToCartButtonWebEl)
    public static WebElement addToCartButton;
    @FindBy(xpath = cartButtonWebEl)
    public static WebElement cartButton;
    @FindBy(xpath = numberOfItemInCartWebEl)
    public static WebElement numberOfItemInCart;
    @FindBy(id = zipCodeInputWebEl)
    public static WebElement zipCodeInput;
    @FindBy(xpath = submitButtonWebEl)
    public static WebElement submitButton;
    @FindBy(xpath = noDeviceProtectionWebEl)
    public static WebElement noDeviceProtection;
    @FindBy(xpath = continueButtonWebEl)
    public static WebElement continueButton;
    @FindBy(xpath = popWindowsForProtectionWebEl)
    public static WebElement popWindowsForProtection;
    @FindBy(id = yesDeclineProtectionWebEl)
    public static WebElement yesDeclineProtection;
    @FindBy(xpath = skipAccessoriesWebEl)
    public static WebElement skipAccessoriesButton;
    @FindBy(xpath = nextButtonAccessoriesWebEl)
    public static WebElement nextButtonAccessories;
    @FindBy(xpath = beginCheckoutWebEl)
    public static WebElement beginCheckoutButton;


    public static void verifySearchResultList(String locator, String product) {
        List<WebElement> webList = driver.findElements(By.xpath(locator));
        for (WebElement element : webList) {

            System.out.println("Actual Product Name :" + element.getText());
            System.out.println("Expected Product Name :" + product.substring(1));

            if (element.getText().equalsIgnoreCase(product.substring(1))) {

                System.out.println(element.getText() + " : The Item Is Exist In The Page");
                break;
            } else {
                System.out.println(element.getText() + " : The Item Does Not Exist In The Page");
            }
        }
    }

    public static void selectItemFromListNew(String locator, String product) {
        List<WebElement> webList = driver.findElements(By.xpath(locator));
        for (WebElement element : webList) {
            System.out.println("Expected Product Name : " + product);
            String elementText = element.getText();
            if (elementText.toLowerCase().contains(product.toLowerCase())) {
                System.out.println("Actual Product : " + elementText);
//                element.click();
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click()", element);
                break;
            } else {
                System.out.println("The product does not match");
            }
        }
    }

    private static int getButtonIndex(String planName) {
        switch (planName.toLowerCase()) {
            case "go5g next":
                return 0;
            case "go5g":
                return 2;
            case "essentials":
                return 4;
            case "essentials saver":
                return 8;
            default:
                throw new IllegalArgumentException("Invalid plan name: " + planName);
        }
    }

    public static boolean selectPhonePlan(String planName) {
        boolean isphonePlanSelected = false;
        List<WebElement> planNamesList = driver.findElements(By.xpath("//h3[@class='upf-planCard__plan-name']"));
        List<WebElement> planButtonList = driver.findElements(By.xpath("//div[@class='upf-planCard__footer']//button"));

        for (int i = 0; i < planButtonList.size(); i++) {
            System.out.println("Button NB :" + i + " : " + planButtonList.get(i).getText());
        }

        for (WebElement planNameElement : planNamesList) {
            String planNameText = planNameElement.getText();

            System.out.println("Plan Name : " + planNameText);

            if (planName.equals(planNameText)) {
                int buttonIndex = getButtonIndex(planName);
                WebElement submitButton = planButtonList.get(buttonIndex);
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click()", submitButton);
                isphonePlanSelected = true;
//
                break;
            }
        }
        return isphonePlanSelected;
    }


    public static void selectFeature(String locator, String color) {
        String notForSaleError = "Not for sale";
        String notForSaleErrorOption = "Not for sale, Sorry, this device is currently not for sale..";

        if (productNotForSale.getText().equals(notForSaleError) || productNotForSale.getText().equals(notForSaleErrorOption)){
            System.out.println("Not for sale, Sorry, this device is currently not for sale");
            driver.close();
           System.exit(0);

        }

//        if (!productNotForSale.getText().equals(notForSaleError) || !productNotForSale.getText().equals(notForSaleErrorOption)) {
            menuIterator(locator);
            boolean isProductPresent = !driver.findElements(By.xpath("//span[contains(text(), '" + color + "')]")).isEmpty();
                if (isProductPresent) {
                SelectItemFromListWithAssertion(locator, color);
//              selectItemFromListNew(colorListWebEl,color);
                } else {
                System.out.println("the color you chose is not available");
                }
//        }
//        else {System.out.println("Not for sale, Sorry, this device is currently not for sale");}
    }


//    private static WebElement waitForElementToBeClickable(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        return wait.until(ExpectedConditions.elementToBeClickable(element));
//    }

//    public static void selectPhonePlan2(String planName) {
//        List<WebElement> planNamesList = driver.findElements(By.xpath("//h3[@class='upf-planCard__plan-name']"));
//        List<WebElement> planButtonList = driver.findElements(By.xpath("//div[@class='upf-planCard__footer']//button"));
//        List<WebElement> buttonsList = new ArrayList<>();
//
//        for (WebElement element : planButtonList) {
//            String elementString = element.toString();
//            String locator = elementString.substring(elementString.indexOf(":") + 2, elementString.lastIndexOf("]"));
//            System.out.println("Locator: " + locator);
//        }
//
//    }

//    public static void selectPhonePlan(String planName) {
//
//        List<WebElement> planNamesList = driver.findElements(By.xpath("//h3[@class='upf-planCard__plan-name']"));
//        List<WebElement> planButtonList = driver.findElements(By.xpath("//div[@class='upf-planCard__footer']//button"));
//
//        for (WebElement planNameElement : planNamesList) {
//            String planNameText = planNameElement.getText();
//
//
//            System.out.println("Plan Name : " + planNameText);
//
//            if (planNameText.equalsIgnoreCase(planName)) {
//
//                waitFor(3);
//
////                    else if (planName.contains("Essentials Saver")) {
//                WebElement submitButton = planButtonList.getFirst();
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript("arguments[0].click()", submitButton);
//
//            } else if (planName.contains("Go5G Next")) {
//                WebElement submitButton = planButtonList.get(1);
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript("arguments[0].click()", submitButton);
//
//            } else if (planName.contains("Go5G Plus")) {
//                WebElement submitButton = planButtonList.get(2);
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript("arguments[0].click()", submitButton);
//
//            } else if (planName.equalsIgnoreCase("Essentials")) {
//                WebElement submitButton = planButtonList.get(3);
//                JavascriptExecutor jse = (JavascriptExecutor) driver;
//                jse.executeScript("arguments[0].click()", submitButton);
//            }
//            break;
//        }
//    }

    public static void validate(String productName) {
        try {
            // Attempt to find the product in the search results
            driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]"));
            System.out.println("Product found: " + productName);
            // Continue with additional steps if the product is found
        } catch (NoSuchElementException e) {
            // If the product is not found, stop the test
            System.out.println("Product not found: " + productName);
            return; // Exit the method
        }
    }

//        List<WebElement> planNamesList = driver.findElements(By.xpath("//h3[@class=\"upf-planCard__plan-name\"]"));
//        List<WebElement> planButtonList = driver.findElements(By.xpath("//div[@class=\"upf-planCard__footer\"]//button"));
//        List<WebElement> buttonsList = new ArrayList<>();
//
//
//        for (WebElement st : planNamesList ) {
//            String stText = st.getText();
//            if (stText.contains(planName)) {
//                System.out.println(stText);
//
//                for (WebElement element : planButtonList) {
//                    String elementText = element.getText();
//                    if (!elementText.isEmpty()) {
////                        buttonsList.add(element);
////                        System.out.println(buttonsList);
////
//                        JavascriptExecutor jse = (JavascriptExecutor) driver;
//                        jse.executeScript("arguments[0].click()", element);
//                    }
//                }
////                buttonsList.get(0).click();
//
//            }
//
//
//
//
//            if (!stText.isEmpty() && stText.equalsIgnoreCase(planName)) {
//                buttonsList.get(1).click();
//            }
//            if (!stText.isEmpty() && stText.equalsIgnoreCase(planName)) {
//                buttonsList.get(2).click();
//            }
//            if (!stText.isEmpty() && stText.equalsIgnoreCase(planName)) {
//                buttonsList.get(3).click();
//            } else {
//                System.out.println("the plan name does not exist");
//            }
//
//        }
//


}
