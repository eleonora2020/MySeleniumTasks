package tests.HW2_8TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class TC2_List48 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);

        List count = driver.findElements(By.className("list-group-item"));

        for (int i = 0; i < count.size(); i++) {
            System.out.println(count.get(i));
        }
        int ExpectedResult = 48;
            System.out.println(ExpectedResult);
        int ActualResult = count.size();

            if (ExpectedResult==ActualResult) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
    driver.quit();
    }
    }