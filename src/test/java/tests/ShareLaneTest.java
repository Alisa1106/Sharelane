package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShareLaneTest {

    @Test
    public void fillAllRegistrationFieldsWithCorrectValuesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("22222");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("User");
        driver.findElement(By.name("email")).sendKeys("user@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.findElement(By.className("confirmation_message"));
        driver.quit();
    }

    @Test
    public void fillZipCodeFieldAndOtherRegistrationFieldsIsEmptyTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("22222");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.findElement(By.className("error_message"));
        driver.quit();
    }

    @Test
    public void fillEmailFieldWithCyrillicSymbolsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("22222");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("User");
        driver.findElement(By.name("email")).sendKeys("юзер@майл.ру");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.findElement(By.className("error_message"));
        driver.quit();
    }

    @Test
    public void fillPasswordAndConfirmPasswordDifferentValuesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("22222");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("User");
        driver.findElement(By.name("email")).sendKeys("user@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.findElement(By.className("error_message"));
        driver.quit();
    }

    @Test
    public void tryLoginWithEmptyPasswordFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys("olga_huang@387.43.sharelane.com");
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        driver.findElement(By.className("error_message"));
        driver.quit();
    }

    @Test
    public void tryLoginWithIncorrectPasswordTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys("olga_huang@387.43.sharelane.com");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        driver.findElement(By.className("error_message"));
        driver.quit();
    }

    @Test
    public void tryAddingBookToCartTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys("olga_huang@387.43.sharelane.com");
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.className("confirmation_message"));
        driver.quit();
    }
}
