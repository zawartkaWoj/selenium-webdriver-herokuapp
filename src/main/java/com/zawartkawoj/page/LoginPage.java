package com.zawartkawoj.page;

import io.qameta.allure.Step;
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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Returning main heading web element...")
    public WebElement getMainHeading() {
        return mainHeading;
    }

    @Step("Returning invalid password error web element...")
    public WebElement getInvalidPasswordError() {
        return driver.findElement(By.xpath("//div[contains(text(), 'Your password is invalid!')]"));
    }

    @Step("Logging user in with valid credentials...")
    public LoggedUserPage loginWithValidCredentials(String username, String password) {
        enterCredentials(username, password);
        loginButton.click();
        return new LoggedUserPage(driver);
    }

    @Step("Logging user in with invalid credentials...")
    public LoginPage loginWithInvalidCredentials(String username, String password) {
        enterCredentials(username, password);
        loginButton.click();
        return this;
    }

    @Step("Entering username and password...")
    private void enterCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

}
