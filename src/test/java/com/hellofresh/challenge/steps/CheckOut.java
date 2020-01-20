package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.Configuration;
import com.hellofresh.challenge.pages.*;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.apache.log4j.Logger.getLogger;

public class CheckOut {

  private static Logger logger = getLogger(CheckOut.class.getName());

  private AuthenticationPage authenticationPage = PageFactory.getInstance(AuthenticationPage.class);
  private MyAccountPage myAccountPage = PageFactory.getInstance(MyAccountPage.class);
  private WomenPage womenPage = PageFactory.getInstance(WomenPage.class);
  private ShoppingCartSummary shoppingCartSummary =
      PageFactory.getInstance(ShoppingCartSummary.class);
  private OrderSummary orderSummary = PageFactory.getInstance(OrderSummary.class);
  private String currentBrowser = Configuration.BROWSER.getValue();

  @When("^user logs in with valid username \"([^\"]*)\" and password$")
  public void userLogsInWithValidUsernameAndPassword(String username) {
    logger.info("User logs in with valid username and password");
    authenticationPage.getUserId().sendKeys(username);
    authenticationPage.getPassword().sendKeys(Configuration.PASSWORD.getValue());
    authenticationPage.getSignInButton().click();
  }

  @And("^user selects the product \"([^\"]*)\"$")
  public void userSelectsTheProductAndAddToCard(String text) {
    logger.info("User clicks on Women Button");
    myAccountPage.getWomen().click();
    logger.info("User clicks on Faded T Shirts");
    womenPage.getDressName(text).click();
  }

  @And("^user proceeds to checkout by agreeing terms of service and confirms the order$")
  public void userProceedsToCheckoutByAgreeingTermsOfService() {
    logger.info("User Process to Checkout the product");
    shoppingCartSummary.getProcessToCheckout1().click();
    shoppingCartSummary.getProcessAddress().click();
    logger.info("User clicks Terms of Service");
    shoppingCartSummary.getTermsOfService().click();
    shoppingCartSummary.getProcessCarrier().click();
    logger.info("User clicks Bank Wire Payment");
    shoppingCartSummary.getBankwirePayment().click();
  }

  @Then("^user should land on order confirmation page with order complete status$")
  public void userShouldLandOnOrderConfirmationPageWithOrderCompleteStatus() {
    assertThat(orderSummary.getHeaderText()).contains("ORDER SUMMARY");
    logger.info("Order Summary page loaded");
    assertThat(orderSummary.getStepFour().isDisplayed()).isTrue();
    assertThat(orderSummary.getStepEnd().isDisplayed()).isTrue();
    logger.info("The order is complete");
  }

  @And("^user adds to card$")
  public void userAddsToCard(DataTable table) {
    List<Map<String, String>> list = table.asMaps(String.class, String.class);
    womenPage.setQuantity(list.get(0).get("Quantity"));
    womenPage.selectSize(list.get(0).get("Size"));
    logger.info("User Adds product to Cart");
    womenPage.getAddToCart().click();
    womenPage.getProceedToCheckout().click();
  }
}
