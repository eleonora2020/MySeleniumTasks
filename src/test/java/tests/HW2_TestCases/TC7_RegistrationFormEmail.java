package tests.HW2_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC7_RegistrationFormEmail {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        WebElement RegForm = driver.findElement(By.linkText("Registration Form")); RegForm.click();
        String Message1 = "email address is not a valid";
        String Message2 ="Email format is not correct";
        String ExpectedResult =Message1+"\n"+Message2;

        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("testers@email");
        WebElement warningMessageDisplay1 = driver.findElement(By.xpath("/html/body/div/div[2]//div[4]/div/small[2]"));

        String InvalidEmail = warningMessageDisplay1.getText();
        WebElement warningMessageDisplay2 = driver.findElement(By.xpath("/html/body/div/div[2]//div[4]/div/small[3]"));
        BrowserUtils.wait(2);
        String WrongFormat = warningMessageDisplay2.getText();

        String ActualResult=InvalidEmail+"\n"+WrongFormat;
        System.out.println(ActualResult);

        if(ExpectedResult.equals(ActualResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();

    }
}