package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.saucedemo.utility.BrowserFactory;
import com.saucedemo.utility.ConfigReader;
import org.testng.ITestResult;
import com.saucedemo.utility.Helper;

public class BaseClass {

    public WebDriver driver;
    public ConfigReader config;

    @BeforeMethod
    public void setup() {

        config = new ConfigReader();

        driver = BrowserFactory.launchBrowser(
                config.getBrowser(),
                config.getUrl());

    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {

            Helper.captureScreenshot(driver, result.getName());

        }

        BrowserFactory.quitBrowser(driver);

    }
}

