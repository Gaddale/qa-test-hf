package com.hellofresh.challenge.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class CommonUtils {

    private static WebDriver currentDriver = null;

    public static void updateDriver(WebDriver driver) {
        currentDriver = driver;
    }

    public static String createRamdomString() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

    public static String createRandomFirstLastName() {
        return RandomStringUtils.random(10, true, false);
    }

    public static Integer createRandomNumber(){
        return Integer.valueOf(RandomStringUtils.randomNumeric(1));
    }

    public static void deleteLogger() {
        try {
            File logdir = new File(System.getProperty("user.dir") + "/Logger/");
            for (File file : logdir.listFiles()) {
                if (!file.isDirectory()) {
                    if (file.getName().equals("logInfo.txt")) {
                        file.delete();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Logger.logTestInfo("logInfo File is not available");
        }
    }

    public static void createLogger() {
        Logger.initializeLogger("./Logger/", "logInfo.txt");
    }

}
