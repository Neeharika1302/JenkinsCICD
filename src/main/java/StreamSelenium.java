import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class StreamSelenium {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit name']")).click();
        List<WebElement> webele = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
        List<String> names = webele.stream().map(s -> s.getText()).toList();
        List<String> sortedNames=names.stream().sorted().toList();
        Assert.assertTrue(names.equals(sortedNames));
       WebElement next= driver.findElement(By.xpath("//a[@aria-label='Next']"));
        List<Integer> prices=new ArrayList<Integer>();
       do {
           List<WebElement> pageEle = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
           prices=pageEle.stream().filter(s->s.getText().contains("Mango")).map(s ->getVeggiePrice(s)).toList();
           prices.forEach(s->System.out.println(s));
           if(prices.size()<1)
           {
               next.click();
           }
       } while (prices.size()<1);
    }


    private static int getVeggiePrice(WebElement s) {

     return Integer.parseInt(s.findElement(By.xpath("following-sibling::td[1]")).getText());

    }
}
