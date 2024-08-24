package com.zawartkawoj.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage {

    @FindBy(xpath = "//h3[text='Add/Remove Elements']")
    private WebElement heading;

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;

    WebDriver driver;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public AddRemoveElementsPage clickAddElementButton(int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            addElementButton.click();
        }
        return this;
    }

    public int addedElementsCount() {
        List<WebElement> addedElements = driver.findElements(By.xpath("//button[text()='Delete']"))
                .stream()
                .toList();
        return addedElements.size();
    }
}
