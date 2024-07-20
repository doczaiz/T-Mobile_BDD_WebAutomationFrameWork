package org.example.configaration.common;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BDDHooks extends WebTestBase {
//Cucumber Hook:

    @Before
    public void setUpBrowser() {
        setUpBrowser(false, "browserStack", "windows", "10", "chrome", "120", envURL);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "screenShotForDefect");
        }
        tearDownAutomation();
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("***************** Automation Started *******************");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("***************** Automation End *******************");
    }




}
