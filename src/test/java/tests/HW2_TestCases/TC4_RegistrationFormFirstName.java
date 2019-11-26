package tests.HW2_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC4_RegistrationFormFirstName {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        WebElement RegForm = driver.findElement(By.linkText("Registration Form")); RegForm.click();
        String ExpextedResult = "first name can only consist of alphabetical letters";

        WebElement inputBox = driver.findElement(By.name("firstname"));
        inputBox.sendKeys("123");
        WebElement nonValidName = driver.findElement(By.xpath("/html/body/div/div[2]//div[1]/div/small[3]"));
        BrowserUtils.wait(2);
        String ActualResult = nonValidName.getText();
        System.out.println(ActualResult);

        if(ExpextedResult.equals(ActualResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();

    }
}