package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q01_RegisterUser {

     static WebDriver driver;
     public boolean close = true;

     @BeforeClass
    public static void setup(){
         // 1. Launch browser
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     }

     @AfterClass
    public static void tearDown(){
         driver.quit();
     }

     @Test
    public void test01() throws InterruptedException {
         // 2. Navigate to url 'http://automationexercise.com'
         driver.navigate().to("http://automationexercise.com");
         // 3. Verify that home page is visible successfully
         WebElement singup_Login = driver.findElement(By.cssSelector("a[href='/login']"));
         Assert.assertEquals("Signup/Login Button not found",singup_Login.getText(),"Signup / Login");
         // 4. Click on 'Signup / Login' button
         singup_Login.click();
         //5. Verify 'New User Signup!' is visible
         WebElement newUserSignup=driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
         Assert.assertTrue("New User Signup! Text'i not found",newUserSignup.isDisplayed());
         newUserSignup.click();
         //6. Enter name and email address
         driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("TestTeam06");
         driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("testteam06@gmail.com");
         //7. Click 'Signup' button
         driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
         //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
         WebElement enterAccountInformation = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
         String ss = enterAccountInformation.getText();
         Assert.assertTrue("Enter Account Information Text'i not found", enterAccountInformation.isDisplayed());
         enterAccountInformation.click();
         //9. Fill details: Title, Name, Email, Password, Date of birth
         WebElement mr=driver.findElement(By.id("id_gender1"));
         mr.click();
         WebElement password=driver.findElement(By.id("password"));
         password.sendKeys("Bkjkj$5403");
         // sayafayı asagi kaydirmak icin
          WebElement genderRadioButton = driver.findElement(By.id("password"));
          genderRadioButton.click();
          genderRadioButton.sendKeys(Keys.PAGE_DOWN);
         WebElement day=driver.findElement(By.id("days"));
         Select days=new Select(day);
         days.selectByIndex(16);
         days.selectByValue("15");
         WebElement month=driver.findElement(By.id("months"));
         Select months=new Select(month);
         months.selectByValue("12");
         WebElement years=driver.findElement(By.id("years"));
         Select year=new Select(years);
         year.selectByValue("1995");
         //10. Select checkbox 'Sign up for our newsletter!'
         WebElement checbox1Click=driver.findElement(By.id("newsletter"));
         checbox1Click.click();
         //11. Select checkbox 'Receive special offers from our partners!'
         WebElement checbox2Click=driver.findElement(By.id("optin"));
         checbox2Click.click();
         //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
         WebElement firsname=driver.findElement(By.id("first_name"));
         firsname.sendKeys("Jonh");
         WebElement lastname=driver.findElement(By.id("last_name"));
         lastname.sendKeys("Mark");
         WebElement company=driver.findElement(By.name("company"));
         company.sendKeys("Company");
         WebElement address1=driver.findElement(By.name("address1"));
         address1.sendKeys("adressim1");
         WebElement address2=driver.findElement(By.name("address2"));
         address2.sendKeys("adressim2");
         WebElement country=driver.findElement(By.id("country"));
         Select countrys=new Select(country);
         countrys.selectByIndex(3);
         WebElement state=driver.findElement(By.id("state"));
         state.sendKeys("state");
         WebElement city=driver.findElement(By.id("city"));
         city.sendKeys("city");
         WebElement zipcode=driver.findElement(By.id("zipcode"));
         zipcode.sendKeys("64583");
         WebElement mobileNumber=driver.findElement(By.id("mobile_number"));
         mobileNumber.sendKeys("+905553335511");
         //13. Click 'Create Account button'
         driver.findElement(By.xpath("//button[text()='Create Account']")).click();
         //14. Verify that 'ACCOUNT CREATED!' is visible
         WebElement accountcreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));
         Assert.assertTrue(accountcreated.isDisplayed());
         //15. Click 'Continue' button
         WebElement continuex = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
         continuex.click();
         //16. Verify that 'Logged in as username' is visible
         WebElement verify=driver.findElement(By.xpath("//*[contains(text(),' Logged in as ')]"));
         Assert.assertTrue(verify.isDisplayed());
         //17. Click 'Delete Account' button
         WebElement deleteAccount=driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]"));
         deleteAccount.click();
        /*
        5 sn bekletme amacımız random reklam çıkartıyor.manuel olarak reklamı kapatmamız gerekiyor.
         */
         Thread.sleep(5000);
         //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         WebElement accountDeleted=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
         Assert.assertTrue(accountDeleted.isDisplayed());

         driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
         Thread.sleep(5000);
         System.out.println("Hepsi başarılı bir şekilde tamamlandı.");

         /*
        xpath alma
        //tagname [@Attribute='Attribute Value']
        cssSelector alma
        tagname[Attribute='Attribute Value']
        işaretleri kaldırdığımızda ccs selectör seçisiyle elementi buluyoruz.


        $x("//img[@alt='Website for automation practice']")[0];
        chrome'da incele kısmına bunu yazdigimizda dogru alip almadigimizi anlayabiliriz
         */




     }


}
