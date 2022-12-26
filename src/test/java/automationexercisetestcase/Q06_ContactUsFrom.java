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

public class Q06_ContactUsFrom {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
     */

    static WebDriver driver;

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
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void Test01() {
        //3. Verify that home page is visible successfully
        WebElement img = driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue("Resim Görüntülenemedi !", img.isDisplayed());
    }

    @Test
    public void Test02(){
        // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
    }

    @Test
    public void Test03(){
        // 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());
    }

    @Test
    public void Test04(){
        // 6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("team06");
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("testteam06@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("Test");
        driver.findElement(By.name("message")).sendKeys("Java ile Selenium testi");
    }

    @Test
    public void Test05(){
        //7. Upload file
        String resim= "/Users/feyzabasaran/Desktop/Testler/src/main/java";
        WebElement uploadFile=driver.findElement(By.xpath("//input[@type='file']"));
        uploadFile.sendKeys(resim);
    }

    @Test
    public void Test06(){
        // 8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
    }

    @Test
    public void Test07() throws InterruptedException {
        //  9. Click OK button
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @Test
    public void Test08() throws InterruptedException {
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement Success=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(Success.isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void Test09(){
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
    }
}
