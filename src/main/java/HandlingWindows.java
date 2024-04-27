import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandlingWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.className("blinkingText")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it= windows.iterator();
        String parentID=it.next();
        String childID=it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String email=driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText();
        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}