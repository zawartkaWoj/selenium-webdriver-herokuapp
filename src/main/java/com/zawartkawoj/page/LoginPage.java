package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//h2[text() = 'Login Page']")
    private WebElement mainHeading;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button/i[text() = ' Login']")
    private WebElement loginButton;

    WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Returning main heading web element...")
    public WebElement getMainHeading() {
        logger.info("Returning main heading web element.");
        WebElement mainHeadingTemp = mainHeading;
        logger.info("Returning main heading web element done.");
        return mainHeadingTemp;
    }

    @Step("Returning invalid password error web element...")
    public WebElement getInvalidPasswordError() {
        logger.info("Returning invalid password error web element.");
        WebElement invalidPasswordElement =
                driver.findElement(By.xpath("//div[contains(text(), 'Your password is invalid!')]"));
        logger.info("Returning invalid password error web element done.");
        return invalidPasswordElement;
    }

    @Step("Logging user in with valid credentials...")
    public LoggedUserPage loginWithValidCredentials(String username, String password) {
        logger.info("Logging user in with valid credentials.");
        enterCredentials(username, password);
        loginButton.click();
        logger.info("Logging user in with valid credentials done.");
        return new LoggedUserPage(driver);
    }

    @Step("Logging user in with invalid credentials...")
    public LoginPage loginWithInvalidCredentials(String username, String password) {
        logger.info("Logging user in with invalid credentials.");
        enterCredentials(username, password);
        loginButton.click();
        logger.info("Logging user in with invalid credentials done.");
        return this;
    }

    @Step("Entering username and password...")
    private void enterCredentials(String username, String password) {
        logger.info("Entering username.");
        usernameField.sendKeys(username);
        logger.info("Entering username done.");
        logger.info("Entering password.");
        passwordField.sendKeys(password);
        logger.info("Entering password done.");
    }

}
