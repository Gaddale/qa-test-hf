package com.hellofresh.challenge.commons;

import com.hellofresh.challenge.Configuration;
import com.hellofresh.challenge.driver.DriverFactory;
import com.hellofresh.challenge.pages.PageFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void initialiseTest() {

        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = System.getenv("browser");
            if (browser == null) {
                browser = Configuration.BROWSER.getValue();
            }
        }

        String url = System.getProperty("url");
        if (url == null) {
            url = System.getenv("url");
            if (url == null) {
                url = Configuration.TEST_ENV.getValue();
            }
        }

        driver = DriverFactory.getNewDriver(browser);
        driver.get(url);
        PageFactory.updateDriver(driver);

    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.cssSelector("[title=\"Log me out\"]")).click();
//        driver.close();
        driver.quit();
    }
}
