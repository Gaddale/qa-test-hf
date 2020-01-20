package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.*;
import com.hellofresh.challenge.utils.CommonUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import static org.apache.log4j.Logger.getLogger;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterCustomer {
    private static Logger logger = getLogger(RegisterCustomer.class.getName());

    String fullName;
    private HomePage homePage = PageFactory.getInstance(HomePage.class);
    private AuthenticationPage authenticationPage = PageFactory.getInstance(AuthenticationPage.class);
    private MyAccountPage myAccountPage = PageFactory.getInstance(MyAccountPage.class);

    @Given("^user is on authentication page$")
    public void UserAuthenticationPage() {
        logger.info("Home Page launched");
        homePage.getSignInLink().click();
    }

    @When("^user sign in with valid email address$")
    public void userSignInWithValidEmailAddress() {
        logger.info("Authentication Page launched");
        authenticationPage.getAccountInput().sendKeys(CommonUtils.createRamdomString() + "@gmail.com");
        authenticationPage.getCreateAccountButton().click();
    }

    @And("^user enters all the mandatory fields and register$")
    public void userEntersAllTheMandatoryFieldsAndRegister() throws InterruptedException {
        logger.info("Create Account Page launched");
        fullName = authenticationPage.enterPersonalInformation();
        authenticationPage.enterAddress();
        logger.info("User Clicked on Register link");
        authenticationPage.getRegister().click();
    }

    @Then("^user should land on my account page with proper username as header$")
    public void userShouldLandOnMyAccountPageWithProperUsernameAsHeader() {
        logger.info("My Account Page launched");
        assertThat(myAccountPage.getHeaderText()).contains("MY ACCOUNT");
        assertThat(myAccountPage.getViewCustomerAccount().getText()).contains(fullName);
        logger.info("Proper username is shown in the header");
    }

    @And("^logout link is displayed for the user$")
    public void logoutLinkIsDisplayedForTheUser() {
        assertThat(myAccountPage.getSignOut().isDisplayed()).isTrue();
        logger.info("Log out action is available");
    }
}
