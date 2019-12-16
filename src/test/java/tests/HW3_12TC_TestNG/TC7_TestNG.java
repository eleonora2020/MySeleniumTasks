package tests.HW3_12TC_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC7_TestNG {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
    }

    @Test(description = "Verify that uploaded file name is displayed.")
    public void test1() {
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/Maulen/Desktop/TEST1");
        BrowserUtils.wait(2);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String ExpectedResult = "TEST1";
        String ActualResult = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(ActualResult, ExpectedResult);
        System.out.println(ActualResult);

    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}