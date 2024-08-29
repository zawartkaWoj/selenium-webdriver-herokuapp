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

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriverFactory().getDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void generateAndOpenAllureReport() {
        try {
            // Uruchomienie Allure serwera w tle
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\path\\to\\allure", "serve", "allure-results");
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();

            // Poczekaj kilka sekund, aby serwer Allure się uruchomił
            Thread.sleep(5000); // Możesz dostosować czas w zależności od szybkości uruchamiania serwera

            // Otwórz raport w domyślnej przeglądarce
            Desktop.getDesktop().browse(new URI("http://localhost:8080")); // Domyślny port 8080, dostosuj, jeśli używasz innego

        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
