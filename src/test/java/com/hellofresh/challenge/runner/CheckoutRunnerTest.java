package com.hellofresh.challenge.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/java/com/hellofresh/challenge/features/CheckOut.feature",
        glue = {"com.hellofresh.challenge.steps", "com.hellofresh.challenge.commons"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
        }
)

public class CheckoutRunnerTest {
}
