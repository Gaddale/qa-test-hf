package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage {

    private By viewCustomerAccount = By.cssSelector("[title=\"View my customer account\"]");
    private By signOut = By.cssSelector("[title=\"Log me out\"]");
    private By women = By.cssSelector("[title=\"Women\"]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getViewCustomerAccount() {
        waitForElementToLoad(viewCustomerAccount);
        return getElement(viewCustomerAccount);
    }

    public WebElement getSignOut() {
        return getElement(signOut);
    }

    public WebElement getWomen() {
        return getElement(women);
    }

}
