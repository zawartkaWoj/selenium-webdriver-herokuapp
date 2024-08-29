package com.zawartkawoj.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElement {

    public static WebElement waitForVisibilityOf(WebDriver driver, WebElement webElement) {
        int timeToWait = 10;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

}
