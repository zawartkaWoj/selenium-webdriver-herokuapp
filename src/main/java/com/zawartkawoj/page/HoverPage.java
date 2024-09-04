package com.zawartkawoj.page;

import io.qameta.allure.Step;
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

    public HoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Returning list of usernames...")
    public List<WebElement> getUsernames() {
        return usernames;
    }

    @Step("Hovering on avatar no. {0}...")
    public HoverPage hoverOnAvatar(int avatarId) {
        WebElement avatar = usersAvatars.get(avatarId - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(avatar).perform();
        return this;
    }

}
