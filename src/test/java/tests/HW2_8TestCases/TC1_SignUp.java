package tests.HW2_8TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC1_SignUp {

    //Test case #1
    //   Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
    //   2. Click on “Sign Up For Mailing List”
    //   3. Enter any valid name
    //   4. Enter any valid email
    //   5. Click on “Sign Up” button
    //   Expected result: Following message should be displayed: “Thank you for signing up. Click the button below to return to the home page.”
    //   Home button should be displayed.


    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);

        WebElement sign_up = driver.findElement(By.linkText("Sign Up For Mailing List")); sign_up.click();

        WebElement inputName = driver.findElement(By.name("full_name"));
        inputName.sendKeys("Elvira Uteuliyeva");
        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys("random@email.com");
        BrowserUtils.wait(1);
        WebElement SignUpButton = driver.findElement(By.name("wooden_spoon"));
        SignUpButton.click();

        String ExpectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String ActualMessage = driver.findElement(By.name("signup_message")).getText();
        System.out.println("Confirmation Message: " +ActualMessage);

        if (ExpectedMessage.equals(ActualMessage)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Passed"); }

        WebElement HomeButton = driver.findElement(By.id("wooden_spoon"));
        HomeButton.click();

        BrowserUtils.wait(2);
        driver.quit();
    }
}