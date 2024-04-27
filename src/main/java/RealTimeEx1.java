import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class RealTimeEx1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int linksCountTotal=driver.findElements(By.tagName("a")).size();
        System.out.println(linksCountTotal);
        WebElement footer= driver.findElement(By.id("gf-BIG"));
        int footerLinksCount=footer.findElements(By.tagName("a")).size();
        System.out.println(footerLinksCount);
        WebElement footer1stSec=footer.findElement(By.xpath("//td[1]/ul"));
        int footer1stSecLinksCount=footer1stSec.findElements(By.tagName("a")).size();
        System.out.println(footer1stSecLinksCount);
        for(int i=1;i<footer1stSecLinksCount;i++){
           footer1stSec.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
        }
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
