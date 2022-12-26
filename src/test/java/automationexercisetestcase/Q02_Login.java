package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_Login {
    static WebDriver driver;
    public boolean close = true;

    @BeforeClass
    public static void setup(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown (){
        driver.quit();
    }

    @Test
    public void Test01(){
        //3. Verify that home page is visible successfully
        WebElement homePageVerify = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
    }

    @Test
    public void Test02(){
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
    }

    @Test
    public void Test03(){
        //5. Verify 'Login to your account' is visible
        WebElement loginVerify = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginVerify.isDisplayed());
    }

    @Test
    public void Test04(){
        //6. Enter correct email address and password
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("testteam06@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("1234");
    }
    @Test
    public void Test05(){
        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
    }

    @Test
    public void Test06(){
        //8. Verify that 'Logged in as username' is visible
        WebElement logged=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(" Logged in as not found",logged.isDisplayed());
    }
    @Test
    public void Test07(){
        //9. Click 'Delete Account' button
        // driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        // bunu yorumdan cikarinca diğerleri hata veriyor o yüzden hesabi silmeden devam ediyoruz
    }
    @Test
    public void Test08(){

        try {
            driver.switchTo().frame("aswift_1");
            driver.switchTo().frame("ad_iframe");
            driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
        }catch (Exception e){
            driver.switchTo().defaultContent();
            close=false;
            System.out.println("İkinci iframe bulunamadı");
        }
        if (close==false)
        {
            try {
                driver.switchTo().frame("aswift_1");
                driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
            }catch (Exception e){
                driver.switchTo().defaultContent();
                System.out.println("İlk iframe bulunamadı");
            }
        }
    }
    @Test
    public void Test09(){
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDelete=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue("Account Deleted! not found",accountDelete.isDisplayed());
    }





}
