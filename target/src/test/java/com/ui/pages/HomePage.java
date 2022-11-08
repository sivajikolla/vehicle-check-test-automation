/**
 * 
 */
package com.ui.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
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

   @FindBy(css = "#m > div.jsx-fa15d114143bd5a4 > div.jsx-b88c7c020f51f4af.modal-bg.visible > div")
   private WebElement vehicleNotFoundError;

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

   public boolean isVehicleNotFoundMessageVisible() {
      return vehicleNotFoundError.isDisplayed();
   }

   public void clickTryAgainButton(){
      JavascriptExecutor executor = (JavascriptExecutor)getDriver();
      executor.executeScript("arguments[0].click();", tryAgainButton);
   }
}
