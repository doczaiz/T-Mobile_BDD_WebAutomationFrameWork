package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions","common"},
        monochrome = true,
        publish = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "junit:target/cucumber-reports/cucumber-results.xml",
                "pretty:target/cucumber-reports/cucumber-pretty.txt",
                "rerun:target/cucumber-reports/rerun.txt",
                "rerun:target/cucumber-reports/cucumber-report.yml"
        },
//        tags = "@Rachid and not @pending"
        tags = "@SanityTest and not @pending"
//        Purpose: Subset of regression testing that checks specific functions.
//        Details: Ensures that specific functionality works as expected.
//        Example: Verifying a particular function after bug fixes in subsequent releases.

//        tags = "@SmokeTest and not @pending"
//        tags = "@WIP and not @pending"

)



public class SanityTestRunner extends AbstractTestNGCucumberTests {

//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//
//    @Before
//    public void beforeScenario(Scenario scenario) {
//
//    }
//
//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass()
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @Test(dataProvider = "features")
//    public void my_test(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
//
//
//    @DataProvider
//    public Object[][] features() {
//        return testNGCucumberRunner.provideFeatures();
//    }
//
//
//    @AfterClass
//    public void tearDown() {
//        testNGCucumberRunner.finish();
//    }
//









}
