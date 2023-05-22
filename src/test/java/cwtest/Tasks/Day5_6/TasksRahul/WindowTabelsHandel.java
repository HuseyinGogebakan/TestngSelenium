package cwtest.Tasks.Day5_6.TasksRahul;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class WindowTabelsHandel extends BaseClass {




    @Test
    public void __tabelhandel(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js =  (JavascriptExecutor)  driver;
        js.executeScript("window.scrollBy(0,400)");
        List<WebElement> clmns = driver.findElements(By.xpath("//table[@id='product'][@class='table-display']//tr"));

        System.out.println("columns amount is  " + clmns.size());
        WebElement second_clmns = clmns.get(2); // because theader is included!
        List<WebElement> cells = second_clmns.findElements(By.xpath(".//td"));

        System.out.println("cells amount is " + cells.size());

        for (WebElement cell : cells){
            System.out.print(cell.getText()+" : ");
        }

    }


    @Test
    public void  dropdown() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ta");
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.className("ui-menu-item"));
        WebElement element = null;

        for (int i  = 0; i<elements.size();i++){

            element = elements.get(i);
            if (element.getText().contains("Taiwan")){

                break;
            }
        }
       // actions.moveToElement(element).click().perform(); i did it because its asked on the task to move mouse and click it!

        element.click();
    }

    @Test
    public void baddssl() {

        ChromeOptions ch = new ChromeOptions();
        ch.setAcceptInsecureCerts(true);
        WebDriver driver1 = new ChromeDriver(ch);
        driver1.get("https://expired.badssl.com/");

    }

    @Test
    public void adblocker(){
        ChromeOptions ch = new ChromeOptions();
        ch.addExtensions(new File("C:\\Users\\830-G7\\Desktop\\TestNg\\Adblock-Plusgratis-adblocker.crx"));

        WebDriver driver1 = new ChromeDriver(ch);

    }

    @Test
    public void proxy(){
        ChromeOptions ch =  new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        ch.setCapability("proxy",proxy);
        WebDriver driver1 = new ChromeDriver();
        WebElement element;

    }

    @Test
    public void  brokenLink() throws IOException {
        // broken url
        // java methods  will call URL'S AND allow you to get the status code!
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
      String url =  driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
     HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();

    }



}
