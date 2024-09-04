package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//h1[text()='Welcome to the-internet']")
    private WebElement mainHeading;

    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveElementsLink;

    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxesLink;

    @FindBy(linkText = "Dropdown")
    private WebElement dropdownLink;

    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoadingLink;

    @FindBy(linkText = "Form Authentication")
    private WebElement loginLink;

    @FindBy(linkText = "Hovers")
    private WebElement hoverLink;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Returning headings text from homepage...")
    public String getHeadingText() {
        return mainHeading.getText();
    }

    @Step("Opening 'Add/Remove Elements' page...")
    public AddRemoveElementsPage openAddRemoveElementsPage() {
        addRemoveElementsLink.click();
        return new AddRemoveElementsPage(driver);
    }

    @Step("Opening 'Checkboxes' page...")
    public CheckboxesPage openCheckboxesPage() {
        checkboxesLink.click();
        return new CheckboxesPage(driver);
    }

    @Step("Opening 'Dropdown' page...")
    public DropdownListPage openDropdownListPage() {
        dropdownLink.click();
        return new DropdownListPage(driver);
    }

    @Step("Opening 'Dynamic Loading' page...")
    public DynamicLoadingPage openDynamicLoadingPage() {
        dynamicLoadingLink.click();
        return new DynamicLoadingPage(driver);
    }

    @Step("Opening 'Login' page...")
    public LoginPage openLoginPage() {
        loginLink.click();
        return new LoginPage(driver);
    }

    @Step("Opening 'Hover' page...")
    public HoverPage openHoverLink() {
        hoverLink.click();
        return new HoverPage(driver);
    }

}
