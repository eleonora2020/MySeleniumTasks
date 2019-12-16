package tests.HW2_8TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC3_MultipleButtons {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        WebElement MultButton = driver.findElement(By.linkText("Multiple Buttons")); MultButton.click();
        BrowserUtils.wait(2);
        String expectedResult = "Clicked on button one!";
        driver.findElement(By.xpath("//*[text()='Button 1']")).click();
        System.out.println(expectedResult);
        String actualResult = driver.findElement(By.id("result")).getText();

        if (expectedResult.equals(actualResult)) {
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");

        }
        BrowserUtils.wait(2);
       // driver.close();
    }
}
