package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownListPage {

    @FindBy(id = "dropdown")
    private WebElement dropdownElement;

    @FindBy(xpath = "//option[text()='Option 1']")
    private WebElement optionOne;

    @FindBy(xpath = "//option[text()='Option 2']")
    private WebElement optionTwo;

    private WebDriver driver;

    private Select dropdownList;

    private static final Logger logger = LogManager.getLogger();

    public DropdownListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.dropdownList = new Select(dropdownElement);
    }

    //Returns all options from the list as a WebElements List
    public List<WebElement> getListOptions() {
        logger.info("Returning list of available options as WebElements.");
        List<WebElement> elements = dropdownList.getOptions();
        logger.info("Returning list of available options as WebElements done.");
        return elements;
    }

    //Chooses an option by its int value
    public DropdownListPage chooseOption(int optionId) {
        logger.info("Choosing an option from the list.");
        dropdownList.selectByIndex(optionId);
        logger.info("Choosing an option from the list done.");
        return this;
    }

}
