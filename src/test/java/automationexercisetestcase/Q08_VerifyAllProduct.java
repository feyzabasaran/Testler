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

public class Q08_VerifyAllProduct {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. The products list is visible
    7. Click on 'View Product' of first product
    8. User is landed to product detail page
    9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */

    static WebDriver driver;
    public boolean close=true;

    @BeforeClass
    public static void setup(){
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown (){
        driver.quit();
    }

    @Test
    public void Test01() {
        // 3. Verify that home page is visible successfully
        WebElement verifyHomePage = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(verifyHomePage.isDisplayed());
    }

    @Test
    public void Test02(){
        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
    }

    // reklam alanı
    @Test
    public void Test03(){
        try {
            /*
            int toplam=0;
            int size = driver.findElements(By.tagName("iframe")).size();
            System.out.println(size);
            for(int i=0; i<=size; i++){
            driver.switchTo().frame(i);
            int total=driver.findElements(By.xpath("//div[@aria-label='Close ad']")).size();
            System.out.println(toplam);
            driver.switchTo().defaultContent();}
            */
            // driver.switchTo().frame("aswift_5");
            // driver.switchTo().frame("ad_iframe");
            // driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
            //Reklam alanını manuel kapatınız.
            Thread.sleep(5000);
        }catch (Exception e){
            //  driver.switchTo().defaultContent();
            //  close=false;
            //  System.out.println("İlk iframe bulunamadı");
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
    public void Test04(){
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(allProducts.isDisplayed());
    }

    @Test
    public void Test05(){
        // 6. The products list is visible
        List<WebElement> products=driver.findElements(By.cssSelector("div[class='productinfo text-center']"));
        System.out.println(products.size()+" Adet resim bulundu...");
        //scrol ile aşağı inme
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");
    }

    @Test
    public void Test06(){
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
    }

    @Test
    public void Test07(){
        //8. User is landed to product detail page
        WebElement getinTouch=driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(getinTouch.isDisplayed());
    }

    @Test
    public void Test08(){
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productname=driver.findElement(By.xpath("//div[@class='product-information']/h2"));
        System.out.println(productname.getText());
        WebElement category=driver.findElement(By.xpath("//div[@class='product-details']//p[1]"));
        System.out.println(category.getText());
        WebElement price=driver.findElement(By.xpath("//*[contains(text(),'Rs.')]"));
        System.out.println(price.getText());
        WebElement availability=driver.findElement(By.xpath("//div[@class='product-details']//p[2]"));
        System.out.println(availability.getText());
        WebElement condition=driver.findElement(By.xpath("//div[@class='product-details']//p[3]"));
        System.out.println(condition.getText());
        WebElement brand=driver.findElement(By.xpath("//div[@class='product-details']//p[4]"));
        System.out.println(brand.getText());
    }


}
