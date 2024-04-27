import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ajax {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Actions a= new Actions(driver);
        a.moveToElement(driver.findElement(By.id("name"))).click().keyDown(Keys.SHIFT).sendKeys("Neeha").build().perform();
        driver.findElement(By.cssSelector("#alertbtn")).click();
        w.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("mousehover"))));
        a.moveToElement(driver.findElement(By.id("mousehover"))).contextClick().build().perform();
    }
}
