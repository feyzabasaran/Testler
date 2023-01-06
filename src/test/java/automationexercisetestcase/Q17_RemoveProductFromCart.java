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

public class Q17_RemoveProductFromCart {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click 'X' button corresponding to particular product
    8. Verify that product is removed from the cart
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown(){
        // driver.quit();
    }

    @Test
    public void Test01() {
        //3. Verify that home page is visible successfully
        WebElement img = driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue(img.isDisplayed());
    }

    @Test
    public void Test03() throws InterruptedException {
        // 4. Add products to cart
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement procud1=driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]"));
        procud1.click();

        WebElement procud2=driver.findElement(By.xpath("(//*[text()='Add to cart'])[3]"));
        procud2.click();
        Thread.sleep(3000);
    }

    @Test
    public void Test04(){
        //Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
    }
    @Test
    public void Test05(){
        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
    }



    @Test
    public void Test06(){
        //6. Verify that cart page is displayed
        WebElement cartPage= driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
        Assert.assertTrue(cartPage.isDisplayed());
    }

    @Test
    public void Test07(){
        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("(//i[@class='fa fa-times'])[1]")).click();
    }

    @Test
    public void Test08(){
        //8. Verify that product is removed from the cart
    }







}
