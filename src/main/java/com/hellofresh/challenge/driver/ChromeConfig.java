package com.hellofresh.challenge.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeConfig implements BrowserConfig {

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver(getCapabilities());
    }

    @Override
    public ChromeOptions getCapabilities() {
        ChromeOptions cap = new ChromeOptions();
        cap.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return cap;
    }
}
