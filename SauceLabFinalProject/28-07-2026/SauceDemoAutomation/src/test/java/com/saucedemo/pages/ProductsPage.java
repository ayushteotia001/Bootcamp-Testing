package com.saucedemo.pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addToCart;

    @FindBy(className="shopping_cart_link")
    WebElement cart;

    @FindBy(id="react-burger-menu-btn")
    WebElement menu;

    @FindBy(id="logout_sidebar_link")
    WebElement logout;

    public void addProductToCart() {
        addToCart.click();
    }

    public void openCart() {
        cart.click();
    }

    public void logout() {
        menu.click();
        WebDriverWait wait =
                new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(logout));

        logout.click();
    }
}
+