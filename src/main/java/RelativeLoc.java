import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        String text=driver.findElement(with(By.tagName("label")).above(name)).getText();
        System.out.println(text);
        WebElement dob=driver.findElement(By.xpath("//label[@for='dateofBirth']"));
        driver.findElement(with(By.className("form-control")).below(dob)).sendKeys("02102000");

        WebElement checkoxtext=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.cssSelector("input[type='checkbox']")).toLeftOf(checkoxtext)).click();

        WebElement radioButton=driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
    }
}
