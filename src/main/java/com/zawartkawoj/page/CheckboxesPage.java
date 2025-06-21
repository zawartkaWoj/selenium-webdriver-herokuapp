package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {

    @FindBy(xpath = "//input[1]")
    private WebElement checkboxOne;

    @FindBy(xpath = "//input[2]")
    private WebElement checkboxTwo;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Clicks on a checkbox specified by its ID
    public CheckboxesPage clickCheckbox(int checkboxId) {
        logger.info("Clicking on checkbox no. " + checkboxId + ".");
        getCheckboxById(checkboxId).click();
        logger.info("Clicking on checkbox no. " + checkboxId + " finished.");
        return this;
    }

    //Checks if a specified checkbox is currently checked
    public boolean isCheckboxChecked(int checkboxId) {
        logger.info("Checking if checkbox " + checkboxId + " is checked.");
        boolean isChecked = getCheckboxById(checkboxId).isSelected();
        logger.info("Checking if checkbox " + checkboxId + " is checked finished.");
        return isChecked;
    }

    //Returns a checkbox by its ID as a WebElement
    private WebElement getCheckboxById(int checkboxId) {
        logger.info("Returning checkbox " + checkboxId + ".");
        WebElement checkBox =  checkboxId == 1 ? checkboxOne : checkboxTwo;
        logger.info("Returning checkbox " + checkboxId + " finished.");
        return checkBox;
    }

}
