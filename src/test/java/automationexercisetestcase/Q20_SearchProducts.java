package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q20_SearchProducts {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify user is navigated to ALL PRODUCTS page successfully
    5. Enter product name in search input and click search button
    6. Verify 'SEARCHED PRODUCTS' is visible
    7. Verify all the products related to search are visible
    8. Add those products to cart
    9. Click 'Cart' button and verify that products are visible in cart
    10. Click 'Signup / Login' button and submit login details
    11. Again, go to Cart page
    12. Verify that those products are visible in cart after login as well
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown(){
        // driver.quit();
    }

    @Test
    public void Test01(){
        // 3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
    }

    @Test
    public void Test02(){
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());

    }

    @Test
    public void Test03(){
        // 5. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("top");
        driver.findElement(By.id("submit_search")).click();
    }

    @Test
    public void Test04(){
        // 6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement arananUrun = driver.findElement(By.xpath("//*[text()='Searched Products']"));
        Assert.assertTrue(arananUrun.isDisplayed());
    }

    @Test
    public void Test05(){
        //7. Verify all the products related to search are visible
        List<WebElement> topListesi = driver.findElements(By.xpath("//div[@class='product-overlay']"));

        int expectedTop = topListesi.size();
        int actualTop = 14;
        Assert.assertEquals(expectedTop,actualTop);
    }
    @Test
    public void Test06(){
        //8. Add those products to cart
        List<WebElement> topListesi = driver.findElements(By.xpath("//div[@class='product-overlay']"));

    }

}
