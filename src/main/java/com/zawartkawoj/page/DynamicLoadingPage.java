package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger();

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Returns the hidden 'Hello World' WebElement
    public WebElement getHelloWorldHidden() {
        logger.info("Returning 'Hello World' element.");
        WebElement helloWorldTemp = helloWorldHidden;
        logger.info("Returning 'Hello World' element done.");
        return helloWorldTemp;
    }

    //Clicks on 'Example One' WebElement
    public DynamicLoadingPage clickOnExampleOne() {
        logger.info("Clicking on example one.");
        exampleOneLink.click();
        logger.info("Clicking on example one done.");
        return this;
    }

    //Clicks on a 'Start' button
    public DynamicLoadingPage clickStartButton() {
        logger.info("Clicking on start button.");
        startButton.click();
        logger.info("Clicking on start button done.");
        return this;
    }

}
