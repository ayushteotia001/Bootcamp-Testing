package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutSteps {

    WebDriver driver;

    @Given("User is logged into the application")
    public void user_is_logged_into_the_application() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User clicks on the menu button")
    public void user_clicks_on_the_menu_button() {

        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @When("User clicks on Logout")
    public void user_clicks_on_logout() throws InterruptedException {

        Thread.sleep(1000); // Wait for menu to open
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User should be redirected to Login Page")
    public void user_should_be_redirected_to_login_page() {

        if (driver.getCurrentUrl().contains("saucedemo.com")) {
            System.out.println("Logout Successful");
        } else {
            System.out.println("Logout Failed");
        }

        driver.quit();
    }
}