package tests.HW2_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC8_RegistrationFormPhNumb {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        WebElement RegForm = driver.findElement(By.linkText("Registration Form")); RegForm.click();
        String ExpextedResult = "Phone format is not correct";

        WebElement inputBox = driver.findElement(By.name("phone"));
        inputBox.sendKeys("5711234354");
        WebElement messageDisplay = driver.findElement(By.xpath("/html/body/div/div[2]//div[6]/div/small[2]"));
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