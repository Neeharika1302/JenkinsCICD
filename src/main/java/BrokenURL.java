import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenURL {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        //HttpURLConnection connect= (HttpURLConnection) new URL(url).openConnection();
        //connect.setRequestMethod("HEAD");
        // connect.connect();
        //int statusCode=connect.getResponseCode();
        //System.out.println(statusCode);

        List<WebElement> urlList = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a=new SoftAssert();
        for (WebElement link: urlList) {
            String url = link.getAttribute("href");
            HttpURLConnection connect = (HttpURLConnection) new URL(url).openConnection();
            connect.setRequestMethod("HEAD");
            connect.connect();
            int statusCode = connect.getResponseCode();
            System.out.println("The status code of "+ link.getText()+" is " +statusCode);
            a.assertTrue(statusCode<400,"The Broken Link is "+ link.getText());
        }
        a.assertAll();
    }
}
