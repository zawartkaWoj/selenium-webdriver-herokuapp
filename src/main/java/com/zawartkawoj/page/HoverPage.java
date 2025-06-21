package com.zawartkawoj.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoverPage {

    @FindBy(xpath = "//img[@alt='User Avatar']")
    private List<WebElement> usersAvatars;

    @FindBy(xpath = "//h5[contains(text(), 'user')]")
    private List<WebElement> usernames;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public HoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Returns users names as a List of WebElements
    public List<WebElement> getUsernames() {
        logger.info("Returning list of usernames as Web Elements.");
        List<WebElement> tempUsernames = usernames;
        logger.info("Returning list of usernames as Web Elements done.");
        return tempUsernames;
    }

    //Hovers mouse cursor over a specified avatar
    public HoverPage hoverOnAvatar(int avatarId) {
        logger.info("Hovering on avatar " + avatarId + ".");
        WebElement avatar = usersAvatars.get(avatarId - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(avatar).perform();
        logger.info("Hovering on avatar " + avatarId + " done.");
        return this;
    }

}
