import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Negative_LoginSourceDemo {
    WebDriver driver;
    WebDriverWait wait;

    //----------Locators----------
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test='error']");

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void testPositiveLoginSauceDemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);

        //Create WebElement Objects
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
        WebElement password = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce"); // Fixed to the correct default password for Sauce Demo
        Thread.sleep(1000);
        loginBtn.click();

        wait.until(ExpectedConditions.urlContains("inventory.html"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed. URL: " + currentUrl);
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void testNegativeLoginSauceDemo() throws InterruptedException {
        driver.get("https://saucedemo.com");
        Thread.sleep(1000);

        //Locate Elements
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
        WebElement password = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        //Provide incorrect credentials
        username.sendKeys("invalid_user");
        password.sendKeys("wrong_password");
        Thread.sleep(1000);
        loginBtn.click();

        //Wait for error message to appear
        WebElement errorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );
        String actualErrorText = errorElement.getText();

        // FORCING A FAILURE: Expecting an impossible error text so the test fails
        String expectedWrongText = "This text will not match, causing the test case to fail!";

        Assert.assertEquals(actualErrorText, expectedWrongText,
                "Failing on purpose to display red color in the HTML report.");

        Thread.sleep(1000);
    }


    @AfterMethod
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
