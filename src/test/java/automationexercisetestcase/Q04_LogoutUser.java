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

public class Q04_LogoutUser {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Logout' button
    10. Verify that user is navigated to login page
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void Test01() {
        // 3. Verify that home page is visible successfully
        WebElement singup_Login = driver.findElement(By.cssSelector("a[href='/login']"));
        Assert.assertEquals("Signup/Login Button not found",singup_Login.getText(),"Signup / Login");
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
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("feyzabsr@gmail.com");
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
        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();
    }

    @Test
    public void Test08(){
        //10. Verify that user is navigated to login page
        WebElement loginYourAccount=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue("Login to your account yazısı görüntülenemedi!",loginYourAccount.isDisplayed());
    }



}
