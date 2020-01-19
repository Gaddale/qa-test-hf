package com.hellofresh.challenge.driver;

import com.hellofresh.challenge.Configuration;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static BrowserConfig config;
    private static WebDriver driver;

    //    private static WebDriver currentDriver = null;
    private static Map<Long, WebDriver> driverMap = new HashMap();

//    public static void updateDriver(WebDriver driver) {
//        currentDriver = driver;
//    }

    public static WebDriver getCurrentDriver() {
        Thread curThread = Thread.currentThread();
        return driverMap.get(curThread.getId());
    }

    public static WebDriver getNewDriver(String browser) {
        setBrowserInfo(browser);
        setDriver();
        configureDriver();
        pushDriverToMap();
        return getCurrentDriver();
    }

    private static void pushDriverToMap() {
        Thread curThread = Thread.currentThread();
        driverMap.put(curThread.getId(), driver);
    }

    private static void configureDriver() {
        driver.manage().window().maximize();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(Long.parseLong(Configuration.IMPLICIT_WAIT.getValue()), TimeUnit.SECONDS);
    }

    private static void setDriver() {
        driver = config.getDriver();
    }

    private static void setBrowserInfo(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                config = new ChromeConfig();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                config = new FirefoxConfig();
                break;
            case "ie":
                config = new IEConfig();
                break;
        }
    }
}
