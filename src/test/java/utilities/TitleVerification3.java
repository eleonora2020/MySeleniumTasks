package utilities;

//Tests: Title and URLtest 3
// 1.Create a new class TitleVerification3under utilities package and create a main method.
// 2.Do the same test case as in the previous exercise, except this time open and close a new browser for each web site.

import utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com/", "https://wayfair.com/",
                                          "https://walmart.com", "https://westelm.com/");

        for(String each : urls){
            WebDriver driver = BrowserFactory.getDriver("chrome");

            driver.get(each);
            BrowserUtils.wait(2);
            String nameTitle = driver.getTitle();
            String title = driver.getTitle().replace(" ", "");
            System.out.println("Title: "+nameTitle+ "\nUrl: "+ each + "\nURL contains the title: "+each.toLowerCase().contains(title.toLowerCase()));
            System.out.println("--------------------------------");

            driver.close();
        }

    }

}
