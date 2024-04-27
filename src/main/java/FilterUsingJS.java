import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class FilterUsingJS {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Mango");
        List<WebElement> webele=driver.findElements(By.cssSelector("tr td:nth-child(1)"));
        List<WebElement> filteredList=webele.stream().filter(veggie->veggie.getText().contains("Mango")).toList();
        Assert.assertEquals(webele.size(),filteredList.size());

    }
}
