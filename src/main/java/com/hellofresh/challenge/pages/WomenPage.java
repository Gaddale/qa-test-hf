package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomenPage extends BasePage {

    private By fadedTShirts = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
    private By womenSection = By.cssSelector("[id=\"center_column\"]");
    private By addToCart = By.name("Submit");
    private By proceedToCheckout = By.cssSelector("[title=\"Proceed to checkout\"]");

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFadedTShirts() {
        waitForElementToLoad(womenSection);
        return getElement(fadedTShirts);
    }

    public WebElement getAddToCart() {
        return getElement(addToCart);
    }

    public WebElement getProceedToCheckout() {
        waitForElementToLoad(proceedToCheckout);
        return getElement(proceedToCheckout);
    }
}
