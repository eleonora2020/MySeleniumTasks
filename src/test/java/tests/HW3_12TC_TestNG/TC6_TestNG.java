package tests.HW3_12TC_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TC6_TestNG {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Verify that email sign up message is displayed and a verification email is received")
    public void test6() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");

        String TempEmail = driver.findElement(By.id("email")).getText(); //Copy Temporary Email
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.name("full_name")).sendKeys("Elvira Uteuliyeva");
        driver.findElement(By.name("email")).sendKeys(TempEmail); //Paste Temp. Email
        driver.findElement(By.name("wooden_spoon")).click();

        WebElement SignUpText = driver.findElement(By.name("signup_message")); //Verify that Sign Up message is displayed
        Assert.assertTrue(SignUpText.isDisplayed(), "Sign Up Message is not displayed");
        BrowserUtils.wait(5);
        driver.get("https://www.tempmailaddress.com/");

        WebElement CopiedEmail = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]")); //Verify that sign up verification email is received
        String ActualEmail = CopiedEmail.getText();
        ActualEmail = ActualEmail.trim();
        String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(ActualEmail, ExpectedEmail);
        CopiedEmail.click();

        String fromEmail = driver.findElement(By.id("odesilatel")).getText();//Verify that Thank you message is displayed in the verification email from Cybertekschool
        String expectedFromEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(fromEmail, expectedFromEmail);

        String ActualSubject = driver.findElement(By.id("predmet")).getText();
        String ExpectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(ActualSubject, ExpectedSubject);
    }

    @AfterMethod
    public void teardown() {
       // driver.quit();
    }
}