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
import java.util.List;

public class Q09_SearchProduct {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. Enter product name in search input and click search button
    7. Verify 'SEARCHED PRODUCTS' is visible
    8. Verify all the products related to search are visible
     */

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
        //3. Verify that home page is visible successfully
        WebElement img=driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue("Resim Görüntülenemedi !",img.isDisplayed());
    }
    @Test
    public void Test02(){
        //4. Click on 'Products' button
        driver.findElement(By.cssSelector("a[href='/products']")).click();
    }
    // reklam alanı
    @Test
    public void Test03(){
        try {
            /*
            driver.switchTo().frame("aswift_5");
            driver.switchTo().frame("ad_iframe");
            driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
             */
            //Reklam alanını manuel kapatınız.
            Thread.sleep(5000);
        }catch (Exception e){
            driver.switchTo().defaultContent();
            close=false;
            System.out.println("İlk iframe bulunamadı");
        }

        if (close==false)
        {
            try {
                driver.switchTo().frame("ad_iframe");
                driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
            }catch (Exception e){
                driver.switchTo().defaultContent();
                System.out.println("ikinci iframe bulunamadı");
            }
        }
    }

    @Test
    public void Test04() {
        //5.  Verify user is navigated to ALL PRODUCTS page successfully
        WebElement getinTouch = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(getinTouch.isDisplayed());
    }

    @Test
    public void Test05() {
        //6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("blue");
        driver.findElement(By.cssSelector(".fa.fa-search")).click();
    }

    @Test
    public void Test06(){
        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement getinTouch=driver.findElement(By.xpath("//*[text()='Searched Products']"));
        Assert.assertTrue(getinTouch.isDisplayed());
    }
    @Test
    public void Test07(){
        //8. Verify all the products related to search are visible
        List<WebElement> products=driver.findElements(By.cssSelector("div[class='productinfo text-center']"));
        System.out.println(products.size()+" Adet resim bulundu...");

    }


}
