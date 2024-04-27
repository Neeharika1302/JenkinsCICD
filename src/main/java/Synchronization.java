import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        String[] itemsNeeded={"Brocolli","Cucumber"};
        addItem(itemsNeeded,driver);
        driver.findElement(By.className("cart-icon")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated((By.className("promoCode"))));
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated((By.className("promoInfo"))));
        Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(),"Code applied ..!");
    }
    public static void addItem(String[] itemsNeeded, WebDriver driver) {
        List<WebElement> product = driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int j = 0; j < itemsNeeded.length; j++) {
            for (int i = 0; i < product.size(); i++) {
                String[] actualName = product.get(i).getText().split("-");
                String trimName = actualName[0].trim();

                List itemNeeded = Arrays.asList(itemsNeeded);
                if (itemNeeded.contains(trimName)) {
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    //h4[@class='product-name']"//h4[@class='product-name']"
                }
            }
        }
    }
}
