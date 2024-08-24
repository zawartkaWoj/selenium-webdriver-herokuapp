package com.zawartkawoj.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//h1[text()='Welcome to the-internet']")
    private WebElement mainHeading;

    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveElementsLink;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeadingText() {
        return mainHeading.getText();
    }

    public AddRemoveElementsPage openAddRemoveElementsPage() {
        addRemoveElementsLink.click();
        return new AddRemoveElementsPage(driver);
    }

}
