package com.zawartkawoj.driver;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory {

    //Put desired Chrome Options in this class
    public static ChromeOptions build() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.addArguments("start-maximized");

        return chromeOptions;
    }

}
