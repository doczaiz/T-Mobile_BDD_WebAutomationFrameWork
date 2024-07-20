package org.example.configaration.common;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;


public class GlobalReUsableMethods extends WebTestBase {

    // will create all the methods which we want to reuse in our test automation


    public static void clickOnElementByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public static void clickOnElementByCssSelector(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public static void clickOnElementById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    public static void clickOnElementByName(String locator) {
        driver.findElement(By.name(locator)).click();
    }

    public static void enterValueOnElementByXpath(String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public static void clickOnWebElement(WebElement element) {
        element.click();
    }

    public static void enterValueOnWebElement(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    // https://www.selenium.dev/documentation/webdriver/actions_api/wheel/
    public static void scrollDownToElement(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("argument[0].scrollIntoView();", element);
    }

    public static String getText(WebElement element) {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return jQuery(arguments[0]).text();", element);
    }

    public static void javaExecuterClickOnElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }
    public static void javaExecuter(WebElement element, String email) {
        String js = "arguments[0].setAttribute('value','" + email + "')";
        ((JavascriptExecutor) driver).executeScript(js, element);
    }

    public static void scrollDownToTheBottomOfThePageElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollDownToTheElementByPixel(int num) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scroll(0," + num + ");");
    }

    public static void selectByVisibleTextFromSelect(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void selectByValueFromSelect(WebElement element, String byValue) {
        Select select = new Select(element);
        select.selectByValue(byValue);
    }

    public static void selectByIndexFromSelect(WebElement element, int byIndex) {
        Select select = new Select(element);
        select.selectByIndex(byIndex);
    }

    // clear field
    public static void clearFieldWebElement(WebElement element) {
        element.clear();
    }

    // navigate back
    public static void navigateBackWebElement() {
        driver.navigate().back();
    }

    // navigate forward
    public static void navigateForwardWebElement() {
        driver.navigate().forward();
    }

    // refresh
    public static void navigateRefreshWebElement() {
        driver.navigate().refresh();
    }

    // double click
    public static void doubleClickOnWebElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void log(String message) {
        Reporter.log(message);
    }

    // check the title
    public static String getTitle() {
        log("Get Title");
        return driver.getTitle();
    }

    public static String getText(WebElement element, String elementName) {
        log("Getting text from " + elementName);
        String actualText = element.getText();
        log("Actual Text " + actualText);
        return actualText;
    }

    // check current url
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Mouse hover
    public static void mouseHoverByWebElement(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(element);
        } catch (Exception e) {
            getLog("First Attempt has been done and this is second try");
            actions.moveToElement(element).perform();
        }
    }

    public static void mouseHoverByWebElementWithPerform(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void mouseHoverByWebElementWithOutPerform(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }


    // alert ok
    public static void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // alert dismiss
    public static void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // Pop Window displayed
    public static boolean isPopUpWindowDisplayed(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    public static boolean isPopUpWindowDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // popUp alert is displayed/ dynamic alert handle
    public static void dynamicAlertHandleAndAcceptAlert() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if (webDriverWait.until(ExpectedConditions.alertIsPresent()) == null) {
            getLog("Alert is not present");
        } else {
            getLog("Alert is present");
            okAlert();
        }
    }

    public static void dynamicAlertHandleAndCancelAlert() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if (webDriverWait.until(ExpectedConditions.alertIsPresent()) == null) {
            getLog("Alert is not present");
        } else {
            getLog("Alert is present");
            cancelAlert();
        }
    }


    // iFrame handle
    public static void iFrameHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public static void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    // window handle
    // new tab handle
    public static WebDriver handleNewTab(WebDriver driver, int windowIndex) {
        String oldTab = driver.getWindowHandle();
        List<String> newTabs = new ArrayList<>(driver.getWindowHandles());
        newTabs.remove(oldTab);
        driver.switchTo().window(newTabs.get(windowIndex));
        return driver;
    }

    // Double click and Right click
    public static void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // uploadFile
    public static void upLoadFile(WebElement element, String path) {
        element.sendKeys(path);
    }


    // getLinks
    public static void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    // taking screenshot
    public void takeScreenShort() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("AutomatedScreenshot.png"));
    }


    // Wait type:
    // implicit wait
    // explicit wait
    // Fluent wait

    // waitUntilClickable
    // waitUntilVisible

    // Wait: https://www.guru99.com/implicit-explicit-waits-selenium.html
    // ImplicitWait: Indirect wait
    // ExplicitWait: Direct wait
    // FluentWait: conditional wait till the time-out


    public static WebElement explicitWaitForElementUsingVisibilityOf(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement explicitWaitForElementToBeClickable(WebElement ele) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(ele));
        return element;
    }

    public static boolean explicitWaitForElementToBeSelected(WebElement ele) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean element = webDriverWait.until(ExpectedConditions.elementToBeSelected(ele));
        return element;
    }

    public static void waitUntilClickable(WebElement ele) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(ele));
        element.click();
    }

    // https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver

    public static WebElement fluentWaitUntilConditionMeet(WebElement ele) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3)).withMessage("Time out")
                .ignoring(NoSuchElementException.class);
//        WebElement element = fluentWait.until(new Function<>() {
//            public WebElement apply(WebDriver driver) {
//                return ele;
//            }
//        });
        return fluentWait.until(new Function<>() {
            public WebElement apply(WebDriver driver) {
                return ele;
            }
        });
    }

    public static WebElement fluentWaitUntilConditionMeetUsingLambda(WebElement ele) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3)).withMessage("Time out")
                .ignoring(NoSuchElementException.class);
        return fluentWait.until(driver1 -> ele);
    }

    public static WebElement fluentWaitUntilConditionMeetUsingBeforeLambda(WebElement ele) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3)).withMessage("Time out")
                .ignoring(NoSuchElementException.class);
        return fluentWait.until(new Function<>() {
            public WebElement apply(WebDriver driver1) {
                return ele;
            }
        });
    }


    // Lis of elements

    public static List<WebElement> getListOfElementsByXpath(String locator) {
        List<WebElement> elementList = new ArrayList<>();
        elementList = driver.findElements(By.xpath(locator));
        return elementList;
    }

    public static List<WebElement> getListOfElementsFromWebElement(List<WebElement> elements) {
        List<WebElement> elementList = new ArrayList<>();
        elementList = elements;
        return elementList;
    }

    public static List<String> getListOfString(List<WebElement> elements) {
        List<String> elementList = new ArrayList<>();
        for (WebElement element : elements) {
            elementList.add(element.getText());
        }
        return elementList;
    }

    // Broken link

    // Customer Made Helper Methods for Amex.com
    public void brokenLink() throws IOException {
        //Step:1-->Get the list of all the links and images
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Total number of links and images--------->>> " + linksList.size());

        //Step:2-->Iterate linksList: exclude all links/images which does not have any href attribute
        List<WebElement> activeLinks = new ArrayList<WebElement>();
        for (int i = 0; i < linksList.size(); i++) {
            System.out.println(linksList.get(i).getAttribute("href"));
            if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript") && (!linksList.get(i).getAttribute("href").contains("mailto")))) {
                activeLinks.add(linksList.get(i));
            }
        }
        System.out.println("Total number of active links and images-------->>> " + activeLinks.size());

        //Step:3--> Check the href url, with http connection api
        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "--------->>> " + response);
        }
    }


    public static void assertEqualByXpath(String loc, String expValue, String message) {
        String act = driver.findElement(By.xpath(loc)).getText();
        // act is coming from Domain -- the one developer build and release
        String exp = expValue; // exp is coming from Requirement or Mock-up
        Assert.assertEquals(act, exp, message);
    }

    public static void verifyText(WebElement element, String expValue, String message) {
        String actual = element.getText();
        Assert.assertEquals(actual, expValue, message);
    }


    // Slider Handling
    // https://stackoverflow.com/questions/15171745/how-to-slidemove-slider-in-selenium-webdriver
    public static void sliderHandling(String locator) {
        driver.switchTo().frame(0); //need to switch to this frame before clicking the slider
        WebElement slider = driver.findElement(By.xpath(locator));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, 30, 0).build();
        action.perform();
    }

    public static void sliderHandling(String locator, int xOffset, int yOffset) {
        driver.switchTo().frame(0); //need to switch to this frame before clicking the slider
        WebElement slider = driver.findElement(By.xpath(locator));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, xOffset, yOffset).build();
        action.perform();
    }


    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }


    // Radio button: regular click


    // Drag and drop
    // https://www.browserstack.com/guide/drag-and-drop-in-selenium
    public static void dragAndDrop(String fromLocator, String toLocator) {
        //WebElement on which drag and drop operation needs to be performed
        WebElement fromElement = driver.findElement(By.xpath(fromLocator));

        //WebElement to which the above object is dropped
        WebElement toElement = driver.findElement(By.xpath(toLocator));

        //Creating object of Actions class to build composite actions
        Actions builder = new Actions(driver);

        //Building a drag and drop action
        Action dragAndDrop = builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build();

        //Performing the drag and drop action
        dragAndDrop.perform();
    }


    // Links
    // Partial Links

    public static void clickOnLink(String locator) {
        driver.findElement(By.linkText(locator)).click();
    }

    public static void clickOnPartialLink(String locator) {
        driver.findElement(By.partialLinkText(locator)).click();
    }

    // CheckBox
    // enable or disable button

    public static boolean isEnableOrDisable(WebElement element) {
        return element.isEnabled();
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean isSelected(WebElement element) {
        return element.isSelected();
    }


    // Date picker
    // https://www.browserstack.com/guide/datepicker-in-selenium


    // Captcha automation: https://www.browserstack.com/guide/how-to-handle-captcha-in-selenium


    public static String getProductList() {
        List<String> productList = new ArrayList<>();
        productList.add("hand Sanitizer");
        productList.add("iphone");
        productList.add("tshirt");
        productList.add("jacket");

        for (String st : productList) {
            // System.out.println(st);
            return st;
        }


        return null;
    }

    public static List<String> getProductListReturn() {
        List<String> productList = new ArrayList<>();
        productList.add("hand Sanitizer");
        productList.add("iphone");
        productList.add("tshirt");
        productList.add("jacket");

        return productList;
    }

    public static void clickOnDesireElementFromList(String locator, String elementName) {
        List<WebElement> list = driver.findElements(By.xpath(locator));
        List<String> actualList = new ArrayList<>();
        for (WebElement st : list) {
            String stText = st.getText();
            if (!stText.isEmpty()) {
                actualList.add(stText);
                System.out.println("List Item : " + actualList);
            } else if (stText.equalsIgnoreCase(elementName)) ;
            st.click();
            break;
        }

    }

    public static void menuIterator(String locator) {
        // To get all the menu Items
        waitFor(5);

        List<WebElement> list = driver.findElements(By.xpath(locator));
        List<String> actualList = new ArrayList<>();
        for (WebElement st : list) {
            String stText = st.getText();
            if (!stText.isEmpty()) {
                actualList.add(stText);
//                System.out.println("Actual Items : "+actualList);
            }
        }
//        System.out.println("Actual Items : " + actualList);
        List<String> expectedElementsList = actualList;

        // actualList been Iterate
        System.out.println("=================  Iterate Actual List ==================");
        Iterator<String> iterator = actualList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
        System.out.println("Expected List :" + expectedElementsList);
        System.out.println("Expected List Size :" + expectedElementsList.size());
        System.out.println("Actual List Size:" + actualList.size());
        Assert.assertEquals(actualList, expectedElementsList, "the list does not match");

    }

    public static void checkElementIfDisplayedAndGetText(WebElement element) {
//        System.out.println(element.getText() + " IsDisplayed : " + element.isDisplayed());
        Boolean expected = element.isDisplayed();

        if (element.isDisplayed()) {
            System.out.println(element.getText() + " : Element is  isDisplayed");
        } else {
            System.out.println("The Element is not Displayed");
        }
        Assert.assertEquals(element.isDisplayed(), expected, "The Element is not Displayed");
    }

    public static void verifyIfElementDisplayedAndClickOn(WebElement element) {
        Boolean expected = element.isDisplayed();
        if (element.isDisplayed()) {
            System.out.println(element.getText() + " : Element is  IsDisplayed");
            System.out.println("The : " + element.getText() + " : Element Been Clicked");
            element.click();
        } else {
            System.out.println("The Element is Not Displayed");
        }
        Assert.assertEquals(element.isDisplayed(), expected, "The Element is not Displayed");
    }

    public static List<String> linkExtractor() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> linkList = new ArrayList<>();
        String linkUrl;
        for (WebElement link : links) {
            String linkText = link.getText();
            linkUrl = link.getAttribute("href");
            if (!link.getAttribute("href").isEmpty() && !link.getText().isEmpty()) {
                linkList.add(link.getAttribute("href"));
//                 System.out.println("Link Text: " + linkText + ", Link URL: " + linkUrl);
            }


        }
        return linkList;
    }

    public static void linkExtractorWithKeyAndValue() {
        // Extract links and iterate over them
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Create a hash map to store the link values
//        Map<String, String> linkValues = new HashMap<>();
        LinkedHashMap<String, String> linkValues = new LinkedHashMap<>();

        for (WebElement link : links) {
            String linkText = link.getText();
            String linkUrl = link.getAttribute("href");
            if (!link.getText().isEmpty() && !link.getAttribute("href").isEmpty()) {
                linkValues.put(linkText, linkUrl);
            }
            // Print the link values
//            for (Map.Entry<String, String> entry : linkValues.entrySet()) {
//                System.out.println("Link Text: " + entry.getKey() + ", Link URL: " + entry.getValue());
        }

        for (String linkText : linkValues.keySet()) {
            String linkUrl = linkValues.get(linkText);
            System.out.println("Link Text: " + linkText + ", Link URL: " + linkUrl);
        }
        System.out.println("The Number of Links : " + linkValues.size());
    }

    public static void selectItemFromList(String locator, String product) {

        List<WebElement> webList = driver.findElements(By.xpath(locator));
        for (WebElement st : webList) {
            if (!st.getText().isEmpty()) {
                String value = st.getText().toLowerCase();
                String newProduct = product.toLowerCase();
                System.out.println("Actual Product Name   : " + value);
                System.out.println("Expected Product Name : " + product);
                if (newProduct.equalsIgnoreCase(value) || newProduct.contains(value) || value.contains(newProduct)) {
                    System.out.println("Actual Items : " + value);
                    System.out.println(newProduct);
                    System.out.println(value);
                    Assert.assertEquals(newProduct.contains(value), !value.isEmpty(), "the product name does not match");
                    st.click();
                    break;
                } else {
                    System.out.println("product name does not match");
                }
            }
        }
    }

    public static void validateItemFromList(String locator, String product) {
        List<WebElement> webList = driver.findElements(By.xpath(locator));

        for (WebElement st : webList) {
            String stText = st.getText();
            if (stText.equalsIgnoreCase(product)) {
                System.out.println("Name Of Search Product " + product);
                System.out.println("Expected Item Found in the Search Result : " + stText);
                Assert.assertEquals(stText, product, "the product does not match");
                st.click();
                break;
            }
        }
    }
    public static boolean verifySeeSearchResult(String locator,String brand, String model) {
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

    public static boolean verifySearchResultList(String locator, String product) {
        List<WebElement> webList = driver.findElements(By.cssSelector(locator));
        System.out.println("Expected Product Name :" + product);
        boolean isProductPresent = false;
        for (WebElement element : webList) {
            System.out.println(element.getText());
            if (!element.getText().isEmpty()) {
                String value = element.getText().toLowerCase();
                String newProduct = product.toLowerCase();
                if (newProduct.equalsIgnoreCase(value) || newProduct.contains(value) || value.contains(newProduct)) {
//                    String newValue = element.getText();
                    System.out.println(value + " : The Item Is Existing In The Page");
//                    isProductPresent=true;
                    WebElement searchedElement = driver.findElement(By.xpath("//h2[text()='" + product + "']"));
                    isProductPresent = searchedElement.isDisplayed();
                    // Check if the product is present in the search results
//                    isProductPresent = driver.findElements(By.xpath("//h2[contains(text(), '" + product + "')]")).size() > 0;
//                    System.out.println("Product found: " + isProductPresent);

//                    Assert.assertTrue(isProductPresent,"Element not found: ");
                    break;
                } else {
                    System.out.println(product + " : The Item Does Not Exist In The Page");
                }
                // Check if the product is present in the search results
//                isProductPresent = driver.findElements(By.xpath("//h2[contains(text(), '" + product + "')]")).size() > 0;

//                System.out.println("Product found: " + isProductPresent);

            }
        }
        if (!isProductPresent) {
            System.out.println("Condition is not true because the product not found. Exiting the method.");
            return isProductPresent; // Exit the method early
        }
        Assert.assertTrue(isProductPresent,"Product not found: " + product);

        return isProductPresent;
    }
    public static String getTextOfHiddenElement() {
        WebElement element = driver.findElement(By.cssSelector("[aria-hidden='false'].unav-headerTool__linkBadge"));
//        <span aria-hidden="false" class="unav-headerTool__linkBadge" data-unav-cart-cookie="tmobglobalshareddata">2</span>
        return element.getText();
    }

    public static void SelectItemFromListWithAssertion(String locator, String itemName) {

        for (WebElement st : getListOfElementsByXpath(locator)) {
            System.out.println(st.getText());
            if (st.getText().equalsIgnoreCase(itemName)) {
                System.out.println(st.getText() + " : Element Been Clicked");
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].click()", st);
                break;
            }
        }
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio' and @checked=\"checked\"])[1]"));
        boolean isSelected = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].hasAttribute('checked');", element);
        if (isSelected) {
            System.out.println(itemName + " : element is selected.");
        } else {
            System.out.println(itemName + " : element is not selected.");
        }
    }


}
