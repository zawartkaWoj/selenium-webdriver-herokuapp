package com.zawartkawoj.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage {

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;

    WebDriver driver;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddRemoveElementsPage clickAddElementButton(int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            addElementButton.click();
        }
        return this;
    }

    public int getAddedElementsCount() {
        List<WebElement> addedElements = getAddedElements();
        return addedElements.size();
    }

    public AddRemoveElementsPage removeElements(int elementsToRemove) {
        for (int i = 0; i < elementsToRemove; i++) {
            getAddedElements().getFirst().click();
        }
        return this;
    }

    private List<WebElement> getAddedElements() {
        return driver.findElements(By.xpath("//button[text()='Delete']"))
                .stream()
                .toList();
    }
}
