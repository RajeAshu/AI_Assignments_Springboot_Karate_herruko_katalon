import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.time.Duration;
import java.util.HashMap;

public class Login_SauceDemo_TestNG {

    WebDriver driver;
    WebDriverWait wait;

    public static final String USERNAME= "rajeashu_TDVkmZ";
    public static final String ACCESS_KEY= "qFPSbChKNexvALKtHzp3";
    public static final String BROWSERSTACK_URL= "https://"+USERNAME+":"+ACCESS_KEY+"@hub-cloud.browserstack.com/wd/hub";


    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test='error']");


    public void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String script = String.format(
                "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"%s\", \"reason\": \"%s\"}}",
                status, reason
        );

        jse.executeScript(script);
    }


    @Parameters({"os", "osVersion", "browserName", "browserVersion"})

    @BeforeMethod
    public void setUp(@Optional("") String os, @Optional("") String osVersion,
                      @Optional("") String browserName, @Optional("") String browserVersion )
            throws MalformedURLException {

        DesiredCapabilities obj_caps = new DesiredCapabilities();
        HashMap<String, Object> obj_stackOptions = new HashMap<>();

        obj_stackOptions.put("os", os);
        obj_stackOptions.put("osVersion", osVersion);
        obj_stackOptions.put("projectName", "CCST BrowserStack Demo");
        obj_stackOptions.put("buildName", "TestNG Build 1.0");
        obj_stackOptions.put("sessionName", "CCST BrowserStack Demo");


        obj_caps.setCapability("bStack:options", obj_stackOptions);


        obj_caps.setCapability("browserName", browserName);
        obj_caps.setCapability("browserVersion", browserVersion);


        driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), obj_caps);


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void testPositiveLoginSauceDemo() throws InterruptedException {
        try {
            driver.get("https://www.saucedemo.com");
            Thread.sleep(1000);

            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(usernameField)
            );
            WebElement password = driver.findElement(passwordField);
            WebElement loginBtn = driver.findElement(loginButton);

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            Thread.sleep(1000);

            loginBtn.click();

            wait.until(ExpectedConditions.urlContains("inventory.html"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed. URL: " + currentUrl);
            Thread.sleep(1000);


            markTestStatus("passed", "Login test executed successfully", driver);

        } catch (Exception e) {

            markTestStatus("failed", "Login test failed: " + e.getMessage(), driver);
            throw e;
        }
    }

    @Test(priority = 2)
    public void testAddMultipleProductsToCart() throws InterruptedException {
        try {

            driver.get("https://www.saucedemo.com");
            System.out.println("Opened page with title: " + driver.getTitle());

            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(usernameField)
            );
            WebElement password = driver.findElement(passwordField);
            WebElement loginBtn = driver.findElement(loginButton);

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            loginBtn.click();

            wait.until(ExpectedConditions.urlContains("inventory.html"));

            By onesieLocator = By.xpath("//button[@name='add-to-cart-sauce-labs-onesie']");
            WebElement onesieAddBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(onesieLocator)
            );

            Assert.assertEquals(onesieAddBtn.getText(), "Add to cart", "Onesie button text mismatch!");
            onesieAddBtn.click();
            System.out.println("PASSED: Onesie added to cart successfully.");


            By fleeceLocator = By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']");
            WebElement fleeceAddBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(fleeceLocator)
            );


            Assert.assertTrue(fleeceAddBtn.isDisplayed(), "Fleece jacket button is not visible!");
            fleeceAddBtn.click();
            System.out.println("PASSED: Fleece jacket is available and added to cart.");


            markTestStatus("passed", "Multiple products added to cart successfully", driver);

        } catch (Exception e) {

            markTestStatus("failed", "Product addition failed: " + e.getMessage(), driver);
            throw e;
        }
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







