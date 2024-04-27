import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumLocators {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver","C:/Users/pneeh/Drivers/ChromeDriver/chrome-win64/chrome.exe");

        WebDriver driver= new ChromeDriver();
        String name= "Neeha";
        //locators
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("Neeha");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        SeleniumLocators Ob= new SeleniumLocators();
        String password=Ob.getPassword(driver);
        /*driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Neeha");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("pneeharika2000@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("6300556262");
        driver.findElement(By.className("reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());*/
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Neeha");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+ name +",");
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        driver.findElement(By.className("logout-btn")).click();
        driver.close();
    }
    public String getPassword(WebDriver driver) throws InterruptedException {
       //driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("reset-pwd-btn")).click();
        String passwordText=driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray=passwordText.split("'");
        String password=passwordArray[1].split("'")[0];
        return password;

    }
}
