package com.zawartkawoj.page;

import io.qameta.allure.Step;
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

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking checkbox no. {0}...")
    public CheckboxesPage clickCheckbox(int checkboxId) {
        getCheckboxById(checkboxId).click();
        return this;
    }

    @Step("Checking if checkbox no. {0} is currently checked...")
    public boolean isCheckboxChecked(int checkboxId) {
        return getCheckboxById(checkboxId).isSelected();
    }

    @Step("Retrieving checkbox no. {0} id...")
    private WebElement getCheckboxById(int checkboxId) {
        return checkboxId == 1 ? checkboxOne : checkboxTwo;
    }

}
