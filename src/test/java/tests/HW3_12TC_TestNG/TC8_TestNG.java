package tests.HW3_12TC_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC8_TestNG {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
    }

    @Test(description = "Verify that following message is displayed: “You selected: United States of America”")
    public void test8() {

        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[type='button']")).click();
        String ExpectedResult = "You selected: United States of America";
        String ActualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(ActualResult, ExpectedResult);
        System.out.println(ActualResult);
    }

    @AfterMethod
    public void teardown() {
        // driver.quit();
    }
}