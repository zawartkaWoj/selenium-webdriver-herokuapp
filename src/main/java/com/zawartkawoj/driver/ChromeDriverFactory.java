package com.zawartkawoj.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory {

    public WebDriver getDriver() {
        ChromeOptions chromeOptions = ChromeOptionsFactory.build();
        return new ChromeDriver(chromeOptions);
    }
}
