package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.MyAccountPage;
import com.hellofresh.challenge.pages.PageFactory;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.apache.log4j.Logger.getLogger;

public class ExistingCustomer {

    private static Logger logger = getLogger(ExistingCustomer.class.getName());
    private MyAccountPage myAccountPage = PageFactory.getInstance(MyAccountPage.class);

    @Then("^user should land on my account page with username \"([^\"]*)\" as header$")
    public void userShouldLandOnMyAccountPageWithUsernameAsHeader(String userFullName) {
        assertThat(myAccountPage.getHeaderText()).contains("MY ACCOUNT");
        assertThat(myAccountPage.getViewCustomerAccount().getText()).contains(userFullName);
        logger.info("Existing User: Proper username is shown in the header");
        logger.info("Existing User: Log out action is available");
    }
}
