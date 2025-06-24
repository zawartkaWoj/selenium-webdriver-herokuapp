package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//h1[@class='heading']")
    private WebElement mainHeading;

    @FindBy(xpath = "//a[@href='/add_remove_elements/']")
    private WebElement addRemoveElementsLink;

    @FindBy(xpath = "//a[@href='/checkboxes']")
    private WebElement checkboxesLink;

    @FindBy(xpath = "//a[@href='/dropdown']")
    private WebElement dropdownLink;

    @FindBy(xpath = "//a[@href='/dynamic_loading']")
    private WebElement dynamicLoadingLink;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@href='/hovers']")
    private WebElement hoverLink;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Returns header text as String
    public String getHeadingText() {
        logger.info("Returning headings text from homepage.");
        String headingsText = mainHeading.getText();
        logger.info("Returning headings text from homepage done.");
        return headingsText;
    }

    //Opens 'Add/Remove Elements' page
    public AddRemoveElementsPage openAddRemoveElementsPage() {
        logger.info("Opening 'Add/Remove Elements' page.");
        addRemoveElementsLink.click();
        logger.info("Opening 'Add/Remove Elements' page done.");
        return new AddRemoveElementsPage(driver);
    }

    //Opens 'Checkboxes' page
    public CheckboxesPage openCheckboxesPage() {
        logger.info("Opening 'Checkboxes' page");
        checkboxesLink.click();
        logger.info("Opening 'Checkboxes' page done.");
        return new CheckboxesPage(driver);
    }

    //Opens 'Dropdown' page
    public DropdownListPage openDropdownListPage() {
        logger.info("Opening 'Dropdown' page.");
        dropdownLink.click();
        logger.info("Opening 'Dropdown' page done.");
        return new DropdownListPage(driver);
    }

    //Opens 'Dynamic Loading' page
    public DynamicLoadingPage openDynamicLoadingPage() {
        logger.info("Opening 'Dynamic Loading' page.");
        dynamicLoadingLink.click();
        logger.info("Opening 'Dynamic Loading' page done.");
        return new DynamicLoadingPage(driver);
    }

    //Opens 'Form Authentication' page
    public LoginPage openLoginPage() {
        logger.info("Opening 'Login' page.");
        loginLink.click();
        logger.info("Opening 'Login' page done.");
        return new LoginPage(driver);
    }

    //Opens 'Hovers' page
    public HoverPage openHoverLink() {
        logger.info("Opening 'Hover' page.");
        hoverLink.click();
        logger.info("Opening 'Hover' page done.");
        return new HoverPage(driver);
    }

}
