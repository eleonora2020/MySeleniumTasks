package tests.HW2_8TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC6_RegistrationFormUsername {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        WebElement RegForm = driver.findElement(By.linkText("Registration Form")); RegForm.click();
        String ExpextedResult = "The username must be more than 6 and less than 30 characters long";

        WebElement inputBox = driver.findElement(By.name("username"));
        inputBox.sendKeys("user");
        WebElement messageDisplay = driver.findElement(By.xpath("/html/body/div/div[2]//div[3]/div/small[2]"));
        BrowserUtils.wait(2);
        String ActualResult = messageDisplay.getText();
        System.out.println(ActualResult);

        if(ExpextedResult.equals(ActualResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();

    }
}