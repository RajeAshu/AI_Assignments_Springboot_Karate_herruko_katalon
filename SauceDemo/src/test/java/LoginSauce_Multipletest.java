import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginSauce_Multipletest {


    private WebDriver driver;

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    @BeforeMethod(groups = {"regression"})
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    // ================= POSITIVE TEST CASES =================

    @Test(priority = 1, groups = {"smoke"})
    public void testValidStandardUserLogin() {
        driver.findElement(usernameField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed for standard user!");
    }

    @Test(priority = 2, groups = {"regression"})
    public void testValidProblemUserLogin() {
        driver.findElement(usernameField).sendKeys("problem_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed for problem user!");
    }

    // ================= NEGATIVE TEST CASES =================

    @Test(priority = 3, groups = {"regression"})
    public void testInvalidUsernameLogin() {
        driver.findElement(usernameField).sendKeys("invalid_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        String errorText = driver.findElement(errorMessage).getText();
        Assert.assertFalse(errorText.contains("Username and password do not match"), "Error text mismatch!");
    }

    @Test(priority = 4, groups = {"smoke"})
    public void testInvalidPasswordLogin() {
        driver.findElement(usernameField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("wrong_password");
        driver.findElement(loginButton).click();

        String errorText = driver.findElement(errorMessage).getText();
        Assert.assertTrue(errorText.contains("Username and password do not match"), "Error text mismatch!");
    }

    @Test(priority = 5, groups = {"regression"})
    public void testEmptyCredentialsLogin() {
        driver.findElement(loginButton).click();

        String errorText = driver.findElement(errorMessage).getText();
        Assert.assertEquals(errorText, "Epic sadface: Username is required", "Empty fields error mismatch!");
    }

    @Test(priority = 6, groups = {"regression"})
    public void testLockedOutUserLogin() {
        driver.findElement(usernameField).sendKeys("locked_out_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        String errorText = driver.findElement(errorMessage).getText();
        Assert.assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.", "Locked out error mismatch!");
    }

    @AfterMethod(groups = {"regression"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
