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

public class Q18_ViewCategoryProducts {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that categories are visible on left side bar
    4. Click on 'Women' category
    5. Click on any category link under 'Women' category, for example: Dress
    6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    7. On left side bar, click on any sub-category link of 'Men' category
    8. Verify that user is navigated to that category page
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void Test01(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        // 3. Verify that categories are visible on left side bar
        WebElement categories = driver.findElement(By.id("accordian"));
        Assert.assertTrue(categories.isDisplayed());
    }

    @Test
    public void Test02(){
        //4. Click on 'Women' category
        driver.findElement(By.xpath("//a[@href='#Women']")).click();
    }

    @Test
    public void Test03(){
        //5. Click on any category link under 'Women' category, for example: TOPS
        driver.findElement(By.xpath("//*[text()='Tops ']")).click();
    }

    @Test
    public void Test04(){
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement categoryPage = driver.findElement(By.xpath("//div[@id='Women']"));
        Assert.assertTrue(categoryPage.isDisplayed());
        WebElement topsProduct = driver.findElement(By.xpath("//*[text()='Women - Tops Products']"));
        Assert.assertTrue(topsProduct.isDisplayed());
    }

    @Test
    public void Test05(){
        // 7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[@href='#Men']")).click();
        driver.findElement(By.xpath("//a [@href='/category_products/3']")).click();
    }
}

