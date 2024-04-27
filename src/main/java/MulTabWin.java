import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MulTabWin {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String name = driver.findElements(By.cssSelector("[class*='courses-block'] a[href*='https://courses.rahulshettyacademy.com/']")).get(1).getText();
        driver.switchTo().window(parentWindow);
        WebElement nameele=driver.findElement(By.xpath("//input[@name='name']"));
        nameele.sendKeys(name);
        File file=nameele.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("name.png"));

        System.out.println(nameele.getRect().getDimension().getHeight());
        System.out.println(nameele.getRect().getDimension().getWidth());


    }
}
