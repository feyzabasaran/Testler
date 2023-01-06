package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class Q19_ViewCartBrand {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify that Brands are visible on left side bar
    5. Click on any brand name
    6. Verify that user is navigated to brand page and brand products are displayed
    7. On left side bar, click on any other brand link
    8. Verify that user is navigated to that brand page and can see products
     */

    static WebDriver driver;
    WebElement poloYazisi =  driver.findElement(By.xpath("//a[@href='/brand_products/Polo']"));
    JavascriptExecutor js=(JavascriptExecutor)driver;
    WebElement kookieKidsYazisi = driver.findElement(By.xpath("//a[@href='/brand_products/Kookie Kids']"));


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://www.automationexercise.com'
        driver.navigate().to("http://www.automationexercise.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void Test01() {
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
    }

    @Test
    public void Test02() {
        // 4. Verify that Brands are visible on left side bar
        WebElement sideBar = driver.findElement(By.xpath("//div[@class='brands_products']"));
        Assert.assertTrue(sideBar.isDisplayed());
    }

    @Test
    public void Test03() throws InterruptedException {
        //5. Click on any brand name
        //driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();
        js.executeScript("arguments[0].click();",poloYazisi);
        Thread.sleep(2000);
    }

    @Test
    public void Test04(){
        //6. Verify that user is navigated to brand page and brand products are displayed
        WebElement poloBrand = driver.findElement(By.className("active"));
        Assert.assertTrue(poloBrand.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//*[text()='Brand - Polo Products']"));
        Assert.assertTrue(brand.isDisplayed());
    }

    @Test
    public void Test05() throws InterruptedException {
        // 7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//*[text()='Madame']")).click();

    }

    @Test
    public void Test06(){
        // 8. Verify that user is navigated to that brand page and can see products
        WebElement mademe = driver.findElement(By.xpath("//*[text()='Brand - Madame Products']"));
        Assert.assertTrue(mademe.isDisplayed());
    }


}


