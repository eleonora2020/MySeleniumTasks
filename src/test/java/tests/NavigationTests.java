package tests;

import utilities.BrowserFactory;
import utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import java.lang.NullPointerException;

public class NavigationTests {

    public static void main(String[] args) {
        String OS = System.getProperty("os.name");
        String browser = "chrome";
        if(browser.equalsIgnoreCase("chrome")){
          //  testWithChrome();
        }else if(browser.equalsIgnoreCase("safari")){
          //  testWithSafari();
        }else if(browser.equalsIgnoreCase("firefox")){
         //   testWithFirefox();
        }

//Testing with Chrome browser
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("http://google.com");
            String titleGoogle = driver.getTitle();
            driver.navigate().to("https://etsy.com");
            String titleEatsy = driver.getTitle();
            driver.navigate().back();
            StringUtility.verifyEquals(titleGoogle, driver.getTitle());
            driver.navigate().forward();
            StringUtility.verifyEquals(titleEatsy, driver.getTitle());
            driver.quit();

//Testing with Firefox browser
            WebDriver driver1 = BrowserFactory.getDriver("firefox");
            driver1.get("http://google.com");
            String titleGoogle1 = driver1.getTitle();
            driver1.navigate().to("https://etsy.com");
            String titleEatsy1 = driver1.getTitle();
            driver1.navigate().back();
            StringUtility.verifyEquals(titleGoogle1, driver1.getTitle());
            driver1.navigate().forward();
            StringUtility.verifyEquals(titleEatsy1, driver1.getTitle());
            driver1.quit();

//Testing with Safari browser
            WebDriver driver2 = BrowserFactory.getDriver("safari");
            driver2.get("http://google.com");
            String titleGoogle2 = driver2.getTitle();
            driver2.navigate().to("https://etsy.com");
            String titleEatsy2 = driver2.getTitle();
            driver2.navigate().back();
            StringUtility.verifyEquals(titleGoogle2, driver2.getTitle());
            driver2.navigate().forward();
            StringUtility.verifyEquals(titleEatsy2, driver2.getTitle());
            driver2.quit();
        }
    }

