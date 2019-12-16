package tests.HW3_12TC_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC9_12_TestNG {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
    }
    /*
    Test case #9
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “200”.
    Step 4. Verify that following message is displayed:“This page returned a 200 status code”
     */
    @Test (description = "Verify that following message is displayed: “This page returned a 200 status code")
    public void test9() {
        String ExpectedResult = "This page returned a 200 status code";
        WebElement Num1 = driver.findElement(By.xpath("//*[text()='200']")); Num1.click();
        BrowserUtils.wait(4);
        Boolean ActualResult =driver.findElement(By.xpath("//div[@class='example']")).isDisplayed();
        Assert.assertTrue(ActualResult, ExpectedResult);
        System.out.println(ActualResult); //true
    }
    /*
    Test case #10
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.//link
    Step 3. Then click on “301”.
    Step 4. Verify that following message is displayed:“This page returned a 301 status code”
     */
    @Test (description = "Verify that following message is displayed: “This page returned a 301 status code")
    public void test10() {
        String ExpectedResult = "This page returned a 301 status code";
        WebElement Num2 = driver.findElement(By.xpath("//*[text()='301']")); Num2.click();
        BrowserUtils.wait(4);
        Boolean ActualResult =driver.findElement(By.xpath("//div[@class='example']")).isDisplayed();
        Assert.assertTrue(ActualResult,ExpectedResult);
        System.out.println(ActualResult);
    }
    /*
   Test case #11
   Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
   Step 3. And click on “Status Codes”.
   Step 4. Then click on “404”.
   Step 5. Verify that following message is displayed: “This page returned a 404 status code”
    */
    @Test (description = "Verify that following message is displayed: “This page returned a 404 status code")
    public void test11() {
        String ExpectedResult = "This page returned a 404 status code";
        WebElement Num2 = driver.findElement(By.xpath("//*[text()='404']")); Num2.click();
        BrowserUtils.wait(4);
        Boolean ActualResult =driver.findElement(By.xpath("//div[@class='example']")).isDisplayed();
        Assert.assertTrue(ActualResult,ExpectedResult);
        System.out.println(ActualResult);
    }
    /*
    Test case #12
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 3. And click on “Status Codes”.
    Step 4. Then click on “500”.
    Step 5. Verify that following message is displayed: “This page returned a 500 status code”
     */
    @Test (description = "Verify that following message is displayed: “This page returned a 500 status code")
    public void test12() {
        String ExpectedResult = "This page returned a 500 status code";
        WebElement Num2 = driver.findElement(By.xpath("//*[text()='500']")); Num2.click();
        BrowserUtils.wait(4);
        Boolean ActualResult =driver.findElement(By.xpath("//div[@class='example']")).isDisplayed();
        Assert.assertTrue(ActualResult,ExpectedResult);
        System.out.println(ActualResult);
    }

        @AfterMethod
        public void teardown () {
        driver.quit();
        }
    }
