package com.saucedemo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utility.ConfigReader;
import com.saucedemo.utility.ExcelDataProvider;

public class LogoutTest extends BaseClass {

    @Test
    public void verifyLogout() {

        ConfigReader config = new ConfigReader();

        LoginPage login = new LoginPage(driver);

        ExcelDataProvider excel = new ExcelDataProvider();

        String username = excel.getStringData("Sheet1", 1, 0);
        String password = excel.getStringData("Sheet1", 1, 1);

        login.loginToApplication(username, password);

        ProductsPage product = new ProductsPage(driver);

        product.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));

    }

}

