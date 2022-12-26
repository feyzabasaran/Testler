package automationexercisetestcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q14_Place_Order {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click Proceed To Checkout
    8. Click 'Register / Login' button
    9. Fill all details in Signup and create account
    10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    11. Verify ' Logged in as username' at top
    12. Click 'Cart' button
    13. Click 'Proceed To Checkout' button
    14. Verify Address Details and Review Your Order
    15. Enter description in comment text area and click 'Place Order'
    16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    17. Click 'Pay and Confirm Order' button
    - 18. Verify success message 'Your order has been placed successfully!'
    19. Click 'Delete Account' button
    20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
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
        System.out.println("tearDown Method'u Çalıştı...");
    }

    @Test
    public void Test01() {
        //3. Verify that home page is visible successfully
        WebElement img = driver.findElement(By.cssSelector("img[alt='Website for automation practice']"));
        Assert.assertTrue(img.isDisplayed());
    }

    @Test
    public void Test02() throws InterruptedException {
        // 4. Add products to cart
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement procud=driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]"));
        //Assert.assertTrue(procud.isDisplayed());
        procud.click();
    }

    @Test
    public void Test03() throws InterruptedException {
        //8. Click 'View Cart' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
    }

    @Test
    public void Test04(){
        // 6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.id("cart_info"));
        Assert.assertTrue(cartPage.isDisplayed());
    }
    @Test
    public void Test05(){
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
    }

    @Test
    public void Test06(){
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
    }

    @Test
    public void Test07() {
        //9. Fill all details in Signup and create account
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("TestTeam06");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("testteam06@gmail.com");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        WebElement mr = driver.findElement(By.id("id_gender1"));
        mr.click();
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Bkjkj$5403");
        WebElement genderRadioButton = driver.findElement(By.id("password"));
        genderRadioButton.click();
        genderRadioButton.sendKeys(Keys.PAGE_DOWN);
        WebElement day = driver.findElement(By.id("days"));
        Select days = new Select(day);
        days.selectByIndex(16);
        days.selectByValue("15");
        WebElement month = driver.findElement(By.id("months"));
        Select months = new Select(month);
        months.selectByValue("12");
        WebElement years = driver.findElement(By.id("years"));
        Select year = new Select(years);
        year.selectByValue("1995");
        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checbox1Click = driver.findElement(By.id("newsletter"));
        checbox1Click.click();
        WebElement checbox2Click = driver.findElement(By.id("optin"));
        checbox2Click.click();
        WebElement firsname = driver.findElement(By.id("first_name"));
        firsname.sendKeys("Jonh");
        WebElement lastname = driver.findElement(By.id("last_name"));
        lastname.sendKeys("Mark");
        WebElement company = driver.findElement(By.name("company"));
        company.sendKeys("Company");
        WebElement address1 = driver.findElement(By.name("address1"));
        address1.sendKeys("adressim1");
        WebElement address2 = driver.findElement(By.name("address2"));
        address2.sendKeys("adressim2");
        WebElement country = driver.findElement(By.id("country"));
        Select countrys = new Select(country);
        countrys.selectByIndex(3);
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("state");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("city");
        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("64583");
        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys("+905553335511");

        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
    }

        @Test
        public void Test08(){
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            WebElement accountcreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));
            Assert.assertTrue(accountcreated.isDisplayed());

            WebElement continuex = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
            continuex.click();
        }

       @Test
       public void Test09() {
           // 11. Verify ' Logged in as username' at top
           WebElement verify = driver.findElement(By.xpath("//*[contains(text(),' Logged in as ')]"));
           Assert.assertTrue(verify.isDisplayed());
       }
    @Test
    public void Test10(){
        // 12. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart'] ")).click();
    }

    @Test
    public void Test11(){
        //13. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
    }

    @Test
    public void Test12(){
        //14. Verify Address Details and Review Your Order
        WebElement adres = driver.findElement(By.xpath("//*[text()='Address Details']"));
        Assert.assertTrue(adres.isDisplayed());
        WebElement review = driver.findElement(By.xpath("//*[text()='Review Your Order']"));
        Assert.assertTrue(review.isDisplayed());
    }

    @Test
    public void Test13() {
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys("Teşekkürler");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out'] ")).click();
    }

    @Test
    public void Test14(){
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("Team06");
        driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("2024");
    }

    @Test
    public void Test15(){
        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[text()='Pay and Confirm Order']")).click();
    }

    @Test
    public void Test16(){
        //18. Verify success message 'Your order has been placed successfully!'
    }

    @Test
    public void Test17() {
        // 19. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
    }

    @Test
    public void Test18(){
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeleted.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }






}
