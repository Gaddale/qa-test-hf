package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class PageFactory {

//    private static WebDriver currentDriver = null;
//
//    public static void updateDriver(WebDriver driver) {
//        currentDriver = driver;
//    }

    public static <TScreen extends BasePage> TScreen getInstance(Class<TScreen> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(DriverFactory.getCurrentDriver());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
