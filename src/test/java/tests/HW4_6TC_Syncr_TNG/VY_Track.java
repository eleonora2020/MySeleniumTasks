package tests.HW4_6TC_Syncr_TNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class VY_Track {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15); //explicit wait
        driver.manage().window().maximize();
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement loaderMask = null;
        if (driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }

    @Test(description = "Verify that page subtitle \"Options\" is displayed")
    public void test1() {
        WebElement OptionSubtitle = driver.findElement(By.cssSelector("[class='btn btn-link dropdown-toggle']"));
        Assert.assertTrue(OptionSubtitle.isDisplayed());
    }

    @Test(description = "Verify that page number is equals to \"1\"")
    public void test2() {
        String PageNum1 = driver.findElement(By.cssSelector("[type='number']")).getAttribute("value");
        Assert.assertEquals(PageNum1, "1", "wrong page number");
    }

    @Test(description = "Verify that view per page number is equals to \"25\"")
    public void test3() {
        String ViewPerPage = driver.findElement(By.cssSelector("[class='btn dropdown-toggle ']")).getText();
        Assert.assertTrue(ViewPerPage.equals("25"));
    }

    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4() {
    List<WebElement> NumbOfRows = driver.findElements(By.xpath("//tbody//tr"));
    int TotalOfRows = NumbOfRows.size();
    String NumbOfRecords = driver.findElement(By.cssSelector("[class='dib']:nth-of-type(3)")).getText();
    Assert.assertTrue(NumbOfRecords.contains(""+TotalOfRows));

    }
    @Test(description = "Verify that all calendar events were selected")
    public void test5() {
       List<WebElement> SelectAll= driver.findElements(By.cssSelector("[type='checkbox'][data-select]:nth-of-type(1)"));
       BrowserUtils.wait(3);
      //  SelectAll.click();
        for(WebElement Select: SelectAll) {
            if (!Select.isSelected()) {

            }
        }
    }
    @Test(description = "Verify that Testers Meeting data is displayed after clicking")
    public void test6() {
        WebElement TestersMeeting = driver.findElement(By.xpath("//tbody//tr[13]//td[2]"));
        TestersMeeting.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        String [] info = {"Title","Testers Meeting","Description", "Start","Nov 27, 2019, 9:30 PM","End","Nov 27, 2019, 10:30 PM",
                "All-day Event","No","Organizer","Stephan Haley","Guests","Tom Smith - Required","Recurrence",
                "Weekly every 1 week on Wednesday","Call Via Hangout","No","This is a a weekly testers meeting"};
        List<WebElement> data = driver.findElements(By.cssSelector("[class='control-label']"));
        int count=0;
        for(WebElement each: data){
            Assert.assertEquals(each.getText(),info[count],"Info does not match");
            Assert.assertTrue(each.isDisplayed());
            count++;
        }
        WebElement description = driver.findElement(By.cssSelector("[class='control-label html-property']"));
        String actualDescription = description.getText();
        String expectedDescription = info[17];
        Assert.assertEquals(actualDescription,expectedDescription,"Description is wrong");
    }

        @AfterMethod
        public void teardown() {
        driver.quit();
        }
    }


