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

public class Q12_AddProductsinCart {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Products' button
    5. Hover over first product and click 'Add to cart'
    6. Click 'Continue Shopping' button
    7. Hover over second product and click 'Add to cart'
    8. Click 'View Cart' button
    9. Verify both products are added to Cart
    10. Verify their prices, quantity and total price
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
        // 4. Click 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void Test03() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        //5. Hover over first product and click 'Add to cart'
        WebElement procud=driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]"));
        //Assert.assertTrue(procud.isDisplayed());
        procud.click();
    }

    @Test
    public void Test04(){
        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
    }

    @Test
    public void Test05(){
        //7. Hover over second product and click 'Add to cart'
        WebElement procud=driver.findElement(By.xpath("(//*[text()='Add to cart'])[3]"));
        //Assert.assertTrue(procud.isDisplayed());
        procud.click();
    }

    @Test
    public void Test06(){
        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
    }

    @Test
    public void Test07() {
        //9. Verify both products are added to Cart
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
    }

    @Test
    public void Test08(){
        //10. Verify their prices, quantity and total price
        List<WebElement> urun1=driver.findElements(By.id("product-1"));
        System.out.println("Ürün 1");
        System.out.println("------------------------------------------------");
        for (WebElement each:urun1) {
            System.out.println(each.getText());
        }
        System.out.println("Ürün 2");
        System.out.println("------------------------------------------------");
        List<WebElement> urun2=driver.findElements(By.id("product-2"));
        for (WebElement each:urun2) {
            System.out.println(each.getText());
        }
    }


}
