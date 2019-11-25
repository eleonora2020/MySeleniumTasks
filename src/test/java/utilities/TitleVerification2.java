package utilities;

//Tests: Title and URLtest 2
// 1.Create a new class TitleVerification2under utilities packageand create a main method.
// 2.Add this ArrayList declaration to the main method:
// List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",
// "https://walmart.com, "https://westelm.com/");
// 3.Visit all websites one by one.
// 4.Verify that URLof the website contains the title of the website.Ignore spaces and casein comparison.
// For example,title of in the first website title is Lulu and Giorgiaand the URLis https://lulugandgeorgia.com. So,this test case must pass.
// 5.Close the browser at the end of the test.

import utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com/", "https://wayfair.com/",
                "https://walmart.com", "https://westelm.com/");

            WebDriver driver = BrowserFactory.getDriver("chrome");

            for(String each : urls) {
                driver.get(each);
                BrowserUtils.wait(2);
                String nameTitle = driver.getTitle();
                String title = driver.getTitle().replace(" ", "");
                System.out.println("Title: " + nameTitle + "\nUrl: " + each + "\nURL contains the title: " + each.toLowerCase().contains(title.toLowerCase()));
                System.out.println("--------------------------------");
            }
            driver.close();
        }

    }

