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

public class Q11_VerifySubscription {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Cart' button
    5. Scroll down to footer
    6. Verify text 'SUBSCRIPTION'
    7. Enter email address in input and click arrow button
    8. Verify success message 'You have been successfully subscribed!' is visible
     */

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        System.out.println("setUp Method'u Çalıştı...");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void Test01(){
        //3. Verify that home page is visible successfully
        WebElement img=driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue(img.isDisplayed());
    }

    @Test
    public void Test02(){
        //4. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart'] ")).click();
    }

    @Test
    public void Test03(){
        // 5. Scroll down to footer
        // 6. Verify text 'SUBSCRIPTION'
        WebElement subscription =driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
    }

    @Test
    public void Test04() throws InterruptedException {
        // 7. Enter email address in input and click arrow button
        Thread.sleep(3000);
        driver.findElement(By.id("susbscribe_email")).sendKeys("team06@gmail.com");
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void Test05(){
        // 8. Verify success message 'You have been successfully subscribed!' is visible
            WebElement subscription=driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
            Assert.assertTrue(subscription.isDisplayed());
        }
}
