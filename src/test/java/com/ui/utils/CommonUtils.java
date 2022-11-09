package com.ui.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CommonUtils
{

   private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);

   private final static int DEFAULT_TIME_OUT = 3;
   private final static int DEFAULT_POLL_TIME = 50;

   public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
      wait.until(ExpectedConditions.visibilityOf(element));
   }

   public static void waitUntilIsClickable(WebDriver driver, WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT), Duration.ofMillis(DEFAULT_POLL_TIME));
      wait.until(ExpectedConditions.elementToBeClickable(element));
   }

   public static Boolean isElementDisplayed(WebDriver driver, WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT), Duration.ofMillis(DEFAULT_POLL_TIME));
      try {
         WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
         return webElement.isDisplayed();
      }
      catch (Exception ex) {
         return false;
      }
   }
}
