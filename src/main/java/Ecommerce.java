import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ecommerce {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        String[] itemsNeeded={"Brocolli","Cucumber"};
        List<WebElement> product=driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int j=0;j<itemsNeeded.length;j++){
            for(int i=0;i<product.size();i++){
                String[] actualName= product.get(i).getText().split("-");
                String trimName=actualName[0].trim();

                List itemNeeded= Arrays.asList(itemsNeeded);
                if(itemNeeded.contains(trimName))
                {
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    //h4[@class='product-name']"//h4[@class='product-name']"
                }
            }

        }
    }
}
