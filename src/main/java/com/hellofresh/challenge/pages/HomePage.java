package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private By signInLink = By.className("login");

    public HomePage(WebDriver driver) {
        super(driver);
        waitForElementToLoad(signInLink);

    }

    public WebElement getSignInLink(){
        return getElement(signInLink);
    }



}
