package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q10_VerifySubscription {

    static WebDriver driver;
    public boolean close=true;
    @BeforeClass
    public static void setUp(){
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
        System.out.println("tearDown Method'u Çalıştı...");
    }

    @Test
    public void Test01(){
        //3.  Verify that home page is visible successfully
        WebElement img=driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue("Resim Görüntülenemedi !",img.isDisplayed());
    }
    @Test
    public void Test02() throws InterruptedException {
        //4. Scroll down to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)");
        Thread.sleep(5000);
    }
    @Test
    public void Test03() throws InterruptedException {
        //5. Verify text 'SUBSCRIPTION'
        WebElement subscription=driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        Thread.sleep(5000);
    }
    @Test
    public void Test04() throws InterruptedException {
        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("Team06@gmail.com");
        driver.findElement(By.id("subscribe")).click();
    }
    @Test
    public void Test05(){
        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement subscription=driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        Assert.assertTrue(subscription.isDisplayed());
    }
}
