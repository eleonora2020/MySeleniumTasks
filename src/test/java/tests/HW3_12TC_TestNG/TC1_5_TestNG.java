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


public class TC1_5_TestNG {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test(description = "Verify that warning message is displayed: “The date of birth is not valid”")
    public void test1() {

        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        inputBox.sendKeys("wrong_dob");
        WebElement messageDisplay = driver.findElement(By.xpath("//*[contains(@data-bv-validator,'date')]"));
        BrowserUtils.wait(2);
        String ExpectedResult = "The date of birth is not valid";
        String ActualResult = messageDisplay.getText();
        System.out.println(ActualResult);
        Assert.assertEquals(ActualResult, ExpectedResult);
    }

    @Test(description = "Verify that following options for programming languages are displayed: C++, Java, JavaScript")
    public void test2() {

        WebElement ProgrLang1 = driver.findElement(By.xpath("//*[text()='C++']"));
        String C = ProgrLang1.getText();
        WebElement ProgrLang2 = driver.findElement(By.xpath("//*[text()='Java']"));
        String java = ProgrLang2.getText();
        WebElement ProgrLang3 = driver.findElement(By.xpath("//*[text()='JavaScript']"));
        String javaScript = ProgrLang3.getText();
        BrowserUtils.wait(2);
        String ExpectedResult = "C++, Java, JavaScript";
        String ActualResult = C + ", " + java + ", " + javaScript;
        System.out.println(ActualResult);
        Assert.assertEquals(ActualResult, ExpectedResult);
    }

    @Test(description = "Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long")
    public void test3() {

        driver.findElement(By.name("firstname")).sendKeys("E");
        BrowserUtils.wait(2);

        String ExpectedResult = "first name must be more than 2 and less than 64 characters long";
        String ActualResult = driver.findElement(By.xpath("/html/body/div/div[2]//div[1]/div/small[2]")).getText();
        System.out.println(ActualResult);
        Assert.assertEquals(ActualResult, ExpectedResult);
        }

    @Test(description = "Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long")
    public void test4() {
        driver.findElement(By.name("lastname")).sendKeys("U");
        BrowserUtils.wait(2);

        String ExpectedResult = "The last name must be more than 2 and less than 64 characters long";
        String ActualResult = driver.findElement(By.xpath("/html/body/div/div[2]//div[2]/div/small[2]")).getText();
        System.out.println(ActualResult);
        Assert.assertEquals(ActualResult, ExpectedResult);
    }

    @Test(description = "Verify that following success message is displayed: “You've successfully completed registration!”")
    public void test5() {

        driver.findElement(By.name("firstname")).sendKeys("Elvira");
        driver.findElement(By.name("lastname")).sendKeys("Uteuliyeva");
        driver.findElement(By.name("username")).sendKeys("eteuliyeva");
        driver.findElement(By.name("email")).sendKeys("eteuliyeva@email.com");
        driver.findElement(By.name("password")).sendKeys("eteuliyeva123");
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("07/23/1991");

        WebElement dept = driver.findElement(By.name("department"));
        Select select = new Select(dept);
        select.selectByValue("DE");
        BrowserUtils.wait(2);

        WebElement job = driver.findElement(By.name("job_title"));
        Select select1 = new Select(job);
        select1.selectByVisibleText("SDET");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//input[@value='java']")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        String ExpectedResult = "You've successfully completed registration!";
        String ActualResult = driver.findElement(By.xpath("/html/body/div/div[2]//div/p")).getText();
        System.out.println(ActualResult);
        BrowserUtils.wait(2);
        Assert.assertEquals(ActualResult, ExpectedResult);
    }

        @AfterMethod
        public void teardown() {

            //driver.quit();
        }
    }

