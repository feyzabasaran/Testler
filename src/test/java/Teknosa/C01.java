package Teknosa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        // 1- https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        // 2- Arama cubuguna "oppo" yazin
        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);

        // 3- Cikan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.className("plp-info"));
        System.out.println("sonuc sayisi : " + sonucSayisi.getText());

        // 4- Cikan ilk urune tiklayin
        driver.findElement(By.xpath("//a[@class='prd-link']")).click();

        // 5- Sepete ekleyiniz
        WebElement sepeteEkle = driver.findElement(By.xpath("(//button[@data-product-id='125078080'])[1]"));
        sepeteEkle.sendKeys(Keys.PAGE_DOWN);
        sepeteEkle.click();

        // 6- Sepetime git'e tiklayin
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']  ")).click();

        // 7- Alisverisi tamamlayin'a tikla
        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();

    }
}
