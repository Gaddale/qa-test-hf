package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;
    private By header = By.cssSelector("h1");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageHeader(By locator) {
        return getElement(locator);
    }

    public String getHeaderText() {
        return getPageHeader(header).getText();
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            System.out.println("Some Error Occurred while creating Element" + locator.toString());
            e.printStackTrace();
        }
        return element;
    }

    public void waitForElementToLoad(final By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");

    }

    protected WebElement getXpath(String text, String searchText) {
        return driver.findElement(By.xpath("//" + text + "[contains(text(),'" + searchText + "')]"));
    }


}
