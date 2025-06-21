package com.zawartkawoj.utils;

import com.zawartkawoj.driver.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {

    protected WebDriver driver;

    //Setup method firing before every test
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriverFactory().getDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    //Teardown method firing after every test
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
