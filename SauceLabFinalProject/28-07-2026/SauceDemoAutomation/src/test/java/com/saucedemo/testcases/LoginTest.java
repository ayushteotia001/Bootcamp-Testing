package com.saucedemo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utility.ConfigReader;

public class LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {

        LoginPage login = new LoginPage(driver);
        ConfigReader config = new ConfigReader();

        login.loginToApplication(
                config.getUsername(),
                config.getPassword());

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

    }
}
