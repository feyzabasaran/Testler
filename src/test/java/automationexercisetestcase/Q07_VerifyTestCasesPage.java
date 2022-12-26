package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q07_VerifyTestCasesPage {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Test Cases' button
    5. Verify user is navigated to test cases page successfully
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown (){
        driver.quit();
    }

    @Test
    public void Test01(){
        // 3. Verify that home page is visible successfully
        WebElement verifyHomePage = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(verifyHomePage.isDisplayed());
    }

    @Test
    public void Test02() throws InterruptedException {
       // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void Test03(){
        //5. Verify user is navigated to test cases page successfully
        WebElement getinTouch=driver.findElement(By.xpath("//*[text()='Test Cases']"));
        Assert.assertTrue(getinTouch.isDisplayed());
    }
}
