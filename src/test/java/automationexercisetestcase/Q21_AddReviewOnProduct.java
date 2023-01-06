package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class Q21_AddReviewOnProduct {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Click on 'Products' button
    //4. Verify user is navigated to ALL PRODUCTS page successfully
    //5. Click on 'View Product' button
    //6. Verify 'Write Your Review' is visible
    //7. Enter name, email and review
    //8. Click 'Submit' button
    //9. Verify success message 'Thank you for your review.'


    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }



    @Test
    public void test02(){
        //3. Click on 'Products' button
        WebElement products = driver.findElement(By.xpath("//a[@href='/products']"));
        products.click();
        ReusableMethods.bekle(3);

    }


    @Test
    public void test03(){
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());
    }

    @Test
    public void test04(){
        //5. Click on 'View Product' button
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//*[text()='View Product']")).click();
    }

    @Test
    public void test05(){
        // 6. Verify 'Write Your Review' is visible
        WebElement writeYoruReview = driver.findElement(By.xpath("//*[text()='Write Your Review']"));
        Assert.assertTrue(writeYoruReview.isDisplayed());
    }

    @Test
    public void test06(){
        //7. Enter name, email and review
        driver.findElement(By.id("name")).sendKeys("Feyza");
        driver.findElement(By.id("email")).sendKeys("feyzabsr@gmail.com");
        driver.findElement(By.id("review")).sendKeys("Harika :)");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @Test
    public void test07(){
        //8. Click 'Submit' button
        driver.findElement(By.id("button-review")).click();
    }

    @Test
    public void test08(){
        //9. Verify success message 'Thank you for your review.'
        WebElement message =driver.findElement(By.xpath("//*[text()='Thank you for your review.']"));
        Assert.assertTrue(message.isDisplayed());

    }

}
