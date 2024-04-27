import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ScrollAndTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        //js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        List<WebElement> values=driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"));
        int sum=0;
        for(int i=0;i<values.size();i++){
            sum +=Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        int expectedSum= Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum,expectedSum);
    }
}
