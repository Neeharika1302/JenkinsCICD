import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SeleniumDropDowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //auto suggestive drop down
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);
        List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option: options)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }
        //Checkboxes
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());


        //static dropdown
        WebElement staticdropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown= new Select(staticdropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for(int i=0;i<4;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //dynamic dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //Handling Calender
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        Thread.sleep(1000);
        /*Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        Thread.sleep(2000);
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());*/
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertFalse(true);
        }
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
        driver.close();
    }
    }
