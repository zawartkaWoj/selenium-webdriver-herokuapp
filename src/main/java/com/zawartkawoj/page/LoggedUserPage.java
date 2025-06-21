package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    @FindBy(xpath = "//h2[text() = ' Secure Area']")
    private WebElement mainHeading;

    @FindBy(css = "a[href = '/logout'")
    private WebElement logoutButton;

    WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public LoggedUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Returns main header as a WebElement
    public WebElement getMainHeading() {
        logger.info("Returning main heading web element.");
        WebElement mainHeadingTemp = mainHeading;
        logger.info("Returning main heading web element done.");
        return mainHeadingTemp;
    }

    //Logs user out
    public LoginPage logout() {
        logger.info("Logging user out.");
        logoutButton.click();
        logger.info("Logging user out done.");
        return new LoginPage(driver);
    }

}
