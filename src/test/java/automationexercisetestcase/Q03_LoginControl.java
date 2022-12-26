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

public class Q03_LoginControl {

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
    public void Test02(){
        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();
    }
    @Test
    public void Test03(){
        //5.Verify 'Login to your account' is visible
        WebElement loginYourAccount=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginYourAccount.isDisplayed());
    }
    @Test
    public void Test04(){
        //6.Enter correct email address and password
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
        //6.Verify error 'Your email or password is incorrect!' is visible
        WebElement logged=driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(logged.isDisplayed());
    }

}
