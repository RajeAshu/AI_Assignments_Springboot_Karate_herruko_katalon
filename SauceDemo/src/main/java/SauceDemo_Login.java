import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceDemo_Login {


        public static void main(String[] args) {

            //Step 1: Create Playwright Object
            try(Playwright obj_playwright=Playwright.create()){

                //Step 2: Launch the Browser
                Browser obj_browser=obj_playwright.chromium().launch(new BrowserType.
                        LaunchOptions().setHeadless(false));

                //Step 3: Create a browser context
                BrowserContext obj_context=obj_browser.newContext();

                //Step 4: Create a page object
                Page obj_page=obj_context.newPage();


                obj_page.navigate("https://saucedemo.com");
                obj_page.waitForTimeout(2000);
                System.out.println("Opened page with title: "+obj_page.title());

                Locator obj_username=obj_page.locator("#user-name");
                obj_username.fill("standard_user");
                obj_page.waitForTimeout(1000);

                Locator obj_password=obj_page.locator("#password");
                obj_password.fill("secret_sauce");
                obj_page.waitForTimeout(1000);

                Locator obj_submit=obj_page.locator("#login-button");
                obj_submit.click();


                obj_page.waitForTimeout(4000);

                assertThat(obj_page.locator("//div[@class='app_logo']")).hasText("Swag Labs");
                System.out.println("PASSED: Logged in to Swag Labs");


                obj_browser.close();


            }
        }

    }

