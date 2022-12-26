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

public class Q05_RegisterUserandNameEmail {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and already registered email address
    7. Click 'Signup' button
    8. Verify error 'Email Address already exist!' is visible
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
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void Test01(){
        //3. Verify that home page is visible successfully
        WebElement img=driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue("Resim Görüntülenemedi !",img.isDisplayed());
    }
    @Test
    public void Test02(){
        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();
    }
    @Test
    public void Test03(){
        //5.Verify 'New User Signup!' is visible
        WebElement loginYourAccount=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue("Login to your account yazısı görüntülenemedi!",loginYourAccount.isDisplayed());
    }
    @Test
    public void Test04(){
        //6.Enter name and already registered email address
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("feyza");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("testteam06@gmail.com\"");
    }
    @Test
    public void Test05(){
        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
    }
    @Test
    public void Test06(){
        //Verify error 'Email Address already exist!' is visible
        WebElement EmailAddressalreadyexist=driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(EmailAddressalreadyexist.isDisplayed());
    }


}
