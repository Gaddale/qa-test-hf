package com.hellofresh.challenge.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        strict = true,
        features = "src/test/java/com/hellofresh/challenge/features/",
        glue = {"com.hellofresh.challenge.steps", "com.hellofresh.challenge.commons"},
        tags = {"@ParallelTestingWithCucumber"}
//        plugin = {
//                "pretty",
//                "html:target/cucumber-html-report",
//                "json:target/cucumber.json",
//                "junit:target/cucumber.xml",
//        }
)
class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }


}
