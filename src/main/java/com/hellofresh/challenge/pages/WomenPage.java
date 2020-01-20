package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WomenPage extends BasePage {

  private By womenSection = By.cssSelector("[id=\"center_column\"]");
  private By addToCart = By.name("Submit");
  private By proceedToCheckout = By.cssSelector("[title=\"Proceed to checkout\"]");
  private By quantity = By.cssSelector("[id=\"quantity_wanted\"]");
  private By size = By.cssSelector("[id=\"group_1\"]");

  public WomenPage(WebDriver driver) {
    super(driver);
  }

  public WebElement getDressName(String searchText) {
    waitForElementToLoad(womenSection);
    return getXpath("h5[@itemprop=\"name\"]/a", searchText);
  }

  public WebElement getAddToCart() {
    return getElement(addToCart);
  }

  public WebElement getProceedToCheckout() {
    waitForElementToLoad(proceedToCheckout);
    return getElement(proceedToCheckout);
  }

  public WebElement getQuantity(){
      return getElement(quantity);
  }

  public void setQuantity(String quantity){
      getQuantity().clear();
      getQuantity().sendKeys(quantity);
  }

  public WebElement getSize(){
      return getElement(size);
  }

  public void selectSize(String size){
      Select dropdown = new Select(getSize());
      dropdown.selectByVisibleText(size);

  }

}
