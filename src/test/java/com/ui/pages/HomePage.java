/**
 * 
 */
package com.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ui.utils.CommonUtils;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;


public class HomePage extends PageObject
{
   @FindBy(css = "h1")
   private WebElement homePageHeader;

   @FindBy(id = "vrm-input")
   private WebElement vehicleRegInput;

   @FindBy(xpath = "//button[contains(text(),'Free Car Check')]")
   private WebElement freeCarCheckButton;

   @FindBy(css = "div[class*='modal-bg visible']")
   private WebElement vehicleNotFoundModalDialog;

   @FindBy(linkText = "Try Again")
   private WebElement tryAgainButton;

   public String getHomePageTitle() {
      return getDriver().getTitle();
   }

   public String getHomePageHeader() {
      CommonUtils.waitForElementToBeVisible(getDriver(), homePageHeader);
      return homePageHeader.getText();
   }

   public void enterCarRegNumber(String carReg) {
      CommonUtils.waitForElementToBeVisible(getDriver(), vehicleRegInput);
      vehicleRegInput.clear();
      vehicleRegInput.sendKeys(carReg);
   }

   public void clickFreeCarCheckButton() {
      CommonUtils.waitUntilIsClickable(getDriver(), freeCarCheckButton);
      freeCarCheckButton.click();
   }

   public boolean isVehicleNotFoundModalDialogVisible() {
      return CommonUtils.isElementDisplayed(getDriver(), vehicleNotFoundModalDialog);
   }

   public void clickTryAgainButton(){
      JavascriptExecutor executor = (JavascriptExecutor)getDriver();
      executor.executeScript("arguments[0].click();", tryAgainButton);
   }
}
