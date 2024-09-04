package com.zawartkawoj.page;

import io.qameta.allure.Step;
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

    public DropdownListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.dropdownList = new Select(dropdownElement);
    }

    @Step("Returning list of options from the dropdown list...")
    public List<WebElement> getListOptions() {
        return dropdownList.getOptions();
    }

    @Step("Choosing option no. {0}...")
    public DropdownListPage clickOption(int optionId) {
        dropdownList.selectByIndex(optionId);
        return this;
    }

}
