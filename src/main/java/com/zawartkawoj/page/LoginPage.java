package com.zawartkawoj.page;

import com.zawartkawoj.utils.WaitForElement;
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

    //Returns main header as a WebElement
    public WebElement getMainHeading() {
        logger.info("Returning main heading web element.");
        //WebElement mainHeadingTemp = mainHeading;
        logger.info("Returning main heading web element done.");
        return WaitForElement.waitForVisibilityOf(driver, mainHeading);
    }

    //Returns 'Invalid Password' error element as a WebElement
    public WebElement getInvalidPasswordError() {
        logger.info("Returning invalid password error web element.");
        WebElement invalidPasswordElement =
                driver.findElement(By.xpath("//div[contains(text(), 'Your password is invalid!')]"));
        logger.info("Returning invalid password error web element done.");
        return invalidPasswordElement;
    }

    //Attempts to log user in with provided valid credentials
    public LoggedUserPage logInWithValidCredentials(String username, String password) {
        logger.info("Entering credentials");
        enterCredentials(username, password);
        logger.info("Clicking on log in button");
        loginButton.click();
        logger.info("Clicked on log in button");
        return new LoggedUserPage(driver);
    }

    //Attempts to log user in with provided wrong credentials
    public LoginPage logInWithWrongCredentials(String username, String password) {
        logger.info("Entering credentials");
        enterCredentials(username, password);
        logger.info("Clicking on log in button");
        loginButton.click();
        logger.info("Clicked on log in button");
        return this;
    }

    //Helper method to abstract entering credentials
    private void enterCredentials(String username, String password) {
        logger.info("Entering username.");
        usernameField.sendKeys(username);
        logger.info("Entering username done.");
        logger.info("Entering password.");
        passwordField.sendKeys(password);
        logger.info("Entering password done.");
    }

}
