package com.zawartkawoj.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {

    @FindBy(xpath = "//input[1]")
    private WebElement checkboxOne;

    @FindBy(xpath = "//input[2]")
    private WebElement checkboxTwo;

    WebDriver driver;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckboxesPage clickCheckbox(int checkboxId) {
        getCheckboxById(checkboxId).click();
        return this;
    }

    public boolean isCheckboxChecked(int checkboxId) {
        return getCheckboxById(checkboxId).isSelected();
    }

    private WebElement getCheckboxById(int checkboxId) {
        return checkboxId == 1 ? checkboxOne : checkboxTwo;
    }

}
