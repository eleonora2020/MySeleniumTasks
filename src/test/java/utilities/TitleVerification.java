package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Tests: Title and URLtest
// 1.Create a new class TitleVerification under utilitiespackageand create a main method.
// 2.Add this ArrayList declaration to the main method:
// List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
// "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
// 3.Open chrome browser
// 4.Visit all the websitesfrom step 3and verify that they all have the same title.
// 5.Verify that all URLsof all pages start with http://practice.cybertekschool.com.
// 6.Close the browser at the end of the test.

public class TitleVerification {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);
        System.out.println(driver.getTitle());
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        System.out.println(driver.getTitle());
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        System.out.println(driver.getTitle());

        for(int i = 0 ; i < urls.size(); i++){
            if (urls.get(i).startsWith("http://practice.cybertekschool.com")){
                System.out.println(urls.get(i) + " : Test Passed");
            }else {
                System.out.println(urls.get(i) + " : Test Failed");
            }
        }
        driver.quit();
    }
}