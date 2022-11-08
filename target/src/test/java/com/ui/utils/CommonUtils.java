package com.ui.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils
{

   private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);

   private final static int DEFAULT_TIME_OUT = 5;
   private final static int DEFAULT_POLL_TIME = 50;

   public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT);
      wait.until(ExpectedConditions.visibilityOf(element));
   }

   public static void waitUntilIsClickable(WebDriver driver, WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT, DEFAULT_POLL_TIME);
      wait.until(ExpectedConditions.elementToBeClickable(element));
   }
}
