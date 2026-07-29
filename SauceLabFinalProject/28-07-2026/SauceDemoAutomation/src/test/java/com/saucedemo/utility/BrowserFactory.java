package com.saucedemo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

    public static WebDriver launchBrowser(String browser, String url) {

        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-save-password-bubble");

            driver = new ChromeDriver(options);

        }

        driver.manage().window().maximize();

        driver.get(url);

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {

        if(driver!=null) {

            driver.quit();

        }

    }

}