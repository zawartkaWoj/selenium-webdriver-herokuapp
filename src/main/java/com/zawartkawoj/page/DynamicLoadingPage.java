package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {

    @FindBy(css = "a[href = '/dynamic_loading/1']")
    private WebElement exampleOneLink;

    @FindBy(id = "finish")
    private WebElement helloWorldHidden;

    @FindBy(xpath = "//button[text() = 'Start']")
    private WebElement startButton;

    private WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Returning helloWorld web element...")
    public WebElement getHelloWorldHidden() {
        return helloWorldHidden;
    }

    @Step("Clicking on example one...")
    public DynamicLoadingPage clickOnExampleOne() {
        exampleOneLink.click();
        return this;
    }

    @Step("Clicking start button...")
    public DynamicLoadingPage clickStartButton() {
        startButton.click();
        return this;
    }

}
