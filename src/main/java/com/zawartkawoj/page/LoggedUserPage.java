package com.zawartkawoj.page;

import io.qameta.allure.Step;
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

    public LoggedUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Returning main heading web element...")
    public WebElement getMainHeading() {
        return mainHeading;
    }

    @Step("Logging user out and returning to log in page...")
    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(driver);
    }

}
