package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartSteps {

    WebDriver driver;

    @Given("User is logged into SauceDemo")
    public void user_is_logged_into_sauce_demo() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User clicks on Add to Cart button")
    public void user_clicks_on_add_to_cart_button() {

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Product should be added to the cart")
    public void product_should_be_added_to_the_cart() {

        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();

        if (cartCount.equals("1")) {
            System.out.println("Product Added Successfully");
        } else {
            System.out.println("Product Not Added");
        }

        driver.quit();
    }
}