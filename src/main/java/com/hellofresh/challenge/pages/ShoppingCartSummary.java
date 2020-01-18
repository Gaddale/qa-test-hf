package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartSummary extends BasePage{

    private By processToCheckout1 = By.cssSelector(".cart_navigation > [title=\"Proceed to checkout\"]");
    private By processAddress = By.name("processAddress");
    private By processCarrier = By.name("processCarrier");
    private By termsOfService = By.name("cgv");
    private By bankWirePayment = By.cssSelector(".bankwire");

    public ShoppingCartSummary(WebDriver driver) {
        super(driver);
    }

    public WebElement getProcessToCheckout1(){
        return getElement(processToCheckout1);
    }

    public WebElement getProcessAddress(){
        return getElement(processAddress);
    }

    public WebElement getProcessCarrier(){
        return getElement(processCarrier);
    }

    public WebElement getTermsOfService(){
        return getElement(termsOfService);
    }

    public WebElement getBankwirePayment(){
        return  getElement(bankWirePayment);
    }

}
