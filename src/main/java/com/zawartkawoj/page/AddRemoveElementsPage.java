package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage {

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Adding new element...")
    public AddRemoveElementsPage clickAddElementButton(int timesToClick) {
        logger.info("Adding " + timesToClick + " elements.");
        for (int i = 0; i < timesToClick; i++) {
            logger.info("Adding element " + (i + 1));
            addElementButton.click();
        }
        logger.info("Adding elements done.");
        return this;
    }

    @Step("Returning all visible elements count...")
    public int getAddedElementsCount() {
        logger.info("Returning number of added elements.");
        List<WebElement> addedElements = getAddedElements();
        logger.info("Returning number of added elements done, total elements: " + addedElements.size() + ".");
        return addedElements.size();
    }

    @Step("Removing {0} elements...")
    public AddRemoveElementsPage removeElements(int elementsToRemove) {
        logger.info("Removing " + elementsToRemove + " elements.");
        for (int i = 0; i < elementsToRemove; i++) {
            getAddedElements().getFirst().click();
        }
        logger.info("Removing elements done.");
        return this;
    }

    @Step("Returning a list of added elements...")
    private List<WebElement> getAddedElements() {
        List<WebElement> addedElements =  driver.findElements(By.xpath("//button[text()='Delete']"))
                .stream()
                .toList();
        return addedElements;
    }

}
