package com.hellofresh.challenge.commons;

import com.hellofresh.challenge.driver.DriverFactory;
import com.hellofresh.challenge.pages.PageFactory;
import com.hellofresh.challenge.utils.CommonUtils;
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

//      if no browser is mentioned chrome will be the default
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = System.getenv("browser");
            if (browser == null) {
                browser = "chrome";
            }
        }

        String url = System.getProperty("url");
        if (url == null) {
            url = System.getenv("url");
            if (url == null) {
                url = "http://automationpractice.com/index.php";
            }
        }

        driver = DriverFactory.getNewDriver(browser);
        driver.get(url);
        PageFactory.updateDriver(driver);
        CommonUtils.updateDriver(driver);
//        CommonUtils.deleteLogger();
//        CommonUtils.createLogger();
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
        driver.close();
        driver.quit();
    }
}
