package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.Configuration;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.hellofresh.challenge.utils.CommonUtils;
import org.openqa.selenium.support.ui.Select;
import static org.apache.log4j.Logger.getLogger;

public class AuthenticationPage extends BasePage {

    private static Logger logger = getLogger(AuthenticationPage.class.getName());

    private By accountInput = By.cssSelector("[id=email_create]");
    private By createAccountButton = By.cssSelector("[id=SubmitCreate]");
    private By userId = By.cssSelector("[id=email]");
    private By password = By.cssSelector("[id=passwd]");
    private By signInButton = By.cssSelector("[id=SubmitLogin]");
    private By firstName = By.cssSelector("[id=customer_firstname]");
    private By lastName = By.cssSelector("[id=customer_lastname]");
    private By address = By.cssSelector("[id=address1]");
    private By city = By.cssSelector("[id=city]");
    private By state = By.cssSelector("[id=id_state]");
    private By postalCode = By.cssSelector("[id=postcode]");
    private By mobile = By.cssSelector("[id=phone_mobile]");
    private By register = By.cssSelector("[id=submitAccount]");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAccountInput() {
        return getElement(accountInput);
    }

    public WebElement getCreateAccountButton() {
        return getElement(createAccountButton);
    }

    public WebElement getUserId() {
        return getElement(userId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getSignInButton() {
        return getElement(signInButton);
    }

    public WebElement getFirstName() {
        return getElement(firstName);
    }

    public WebElement getLastName() {
        return getElement(lastName);
    }

    public WebElement getAddress() {
        return getElement(address);
    }

    public WebElement getCity() {
        return getElement(city);
    }

    public WebElement getState() {
        return getElement(state);
    }

    public WebElement getPostalCode() {
        return getElement(postalCode);
    }

    public WebElement getMobile() {
        return getElement(mobile);
    }

    public WebElement getRegister() {
        return getElement(register);
    }

    public void selectState() {
        Select dropdown = new Select(getState());
        dropdown.selectByIndex(CommonUtils.createRandomNumber());
    }

    public String enterPersonalInformation() {
        logger.info("Entering Personal Information");
        String fName = CommonUtils.createRandomFirstLastName();
        String lName = CommonUtils.createRandomFirstLastName();
        String fullName = fName + " " + lName;
        getFirstName().sendKeys(fName);
        getLastName().sendKeys(lName);
        getPassword().sendKeys(Configuration.PASSWORD.getValue());
        return fullName;
    }

    public void enterAddress() {
        logger.info("Entering Address Details");
        getAddress().sendKeys("Address 123");
        getCity().sendKeys("Heilbornn");
        selectState();
        getPostalCode().sendKeys("12345");
        getMobile().sendKeys("9999999999");
    }
}
