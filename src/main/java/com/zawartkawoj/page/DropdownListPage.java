package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropdownListPage {

    @FindBy(id = "dropdown")
    private WebElement dropdownList;

    @FindBy(xpath = "//option[text()='Option 1']")
    private WebElement optionOne;

    @FindBy(xpath = "//option[text()='Option 2']")
    private WebElement optionTwo;

    @FindBy(xpath = "//option[@value > 0]")
    private List<WebElement> options;

    private WebDriver driver;

    public DropdownListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Returning list of options from the dropdown list...")
    public List<WebElement> getOptions() {
        return options;
    }

    @Step("Returning dropdown list as a WebElement...")
    public WebElement getDropdownList() {
        return dropdownList;
    }

    @Step("Clicking on dropdown list...")
    public DropdownListPage clickOnList() {
        dropdownList.click();
        return this;
    }

    @Step("Clicking on option no. {0}...")
    public DropdownListPage clickOption(int optionId) {
        options.get(optionId - 1).click();
        return this;
    }

}
