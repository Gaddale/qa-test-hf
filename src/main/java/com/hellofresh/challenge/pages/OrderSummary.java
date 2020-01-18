package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummary extends BasePage {

    private By stepFour = By.cssSelector(".step_done.step_done_last.four");
    private By stepEnd = By.cssSelector("[id=\"step_end\"].step_current.last");

    public OrderSummary(WebDriver driver) {
        super(driver);
    }

    public WebElement getStepFour() {
        return getElement(stepFour);
    }

    public WebElement getStepEnd() {
        return getElement(stepEnd);
    }
}
