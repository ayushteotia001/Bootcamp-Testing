package com.saucedemo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utility.ConfigReader;

public class AddToCartTest extends BaseClass {

    @Test
    public void verifyAddToCart() {

        ConfigReader config = new ConfigReader();

        LoginPage login = new LoginPage(driver);

        login.loginToApplication(
                config.getUsername(),
                config.getPassword());

        ProductsPage product = new ProductsPage(driver);

        product.addProductToCart();

        product.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

    }

}

