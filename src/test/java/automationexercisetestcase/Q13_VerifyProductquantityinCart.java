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
import java.util.List;

public class Q13_VerifyProductquantityinCart {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    6. Increase quantity to 4
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page with exact quantity
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
    public void Test02() throws InterruptedException {
        //4. Click 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    @Test
    public void Test03(){
        //4. Click 'View Product' for any product on home page
        WebElement viewProduct=driver.findElement(By.xpath("(//*[text()='View Product'])[1]"));
        Assert.assertTrue(viewProduct.isDisplayed());
        viewProduct.click();
    }
    @Test
    public void Test04(){
        //5. Verify product detail is opened
        WebElement verifyProduct=driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(verifyProduct.isDisplayed());
    }
    @Test
    public void Test05(){
        //6. Increase quantity to 4
        WebElement quantity=driver.findElement(By.id("quantity"));
        quantity.clear();
        quantity.sendKeys("4");
    }
    @Test
    public void Test06(){
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
    }
    @Test
    public void Test07() throws InterruptedException {
        //8. Click 'View Cart' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
    }
    @Test
    public void Test08(){
        //9. Verify that product is displayed in cart page with exact quantity
        WebElement quantity=driver.findElement(By.xpath("//*[@class='cart_quantity']"));
        Assert.assertTrue(quantity.isDisplayed());
        System.out.println(quantity.getText());
        List<WebElement> urun1=driver.findElements(By.id("product-1"));
        System.out.println("Ürün 1");
        System.out.println("------------------------------------------------");
        for (WebElement each:urun1) {
            System.out.println(each.getText());
        }
    }





}
