import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalenderUI {
    public static void main(String[] args){
        String date= "2";
        String month= "10";
        String year= "2025";
        String[] expectedValue={month,date,year};
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        List<WebElement> list=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getAttribute("value"));
            Assert.assertEquals(list.get(i).getAttribute("value"),expectedValue[i]);
        }
        driver.close();
    }
}
