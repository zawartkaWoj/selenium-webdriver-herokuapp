package com.zawartkawoj.driver;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory {

    public static ChromeOptions build() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
