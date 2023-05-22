package cwtest.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {



    private static WebDriver driver;
    public  static  WebDriver getDriver(){
        if (driver == null){
            WebDriverManager.chromiumdriver().setup();
            driver  = new ChromeDriver();
            driver.manage().window().maximize();
        }


        return driver;
    }

    public static WebDriver getSelectedDriver(String browser){
        if (driver != null) return driver;
        switch (browser){
            case "firefox"->{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();}
            case "chrome"->{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case  "edge"->{
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
        }



        return driver;
    }


    public static void closerDriver(){

        if (driver != null){
            driver.quit();
        }

    }


    public  static boolean is_Valid(String link) throws IOException {
        HttpURLConnection url = (HttpURLConnection) new URL(link).openConnection();

        url.setRequestMethod("HEAD");
        url.connect();

        return url.getResponseCode() <= 400;


    }


    public static List<WebElement> validElements (List<WebElement> elements) throws IOException {

        List<String> links = elements.stream().map(Driver::getHref).toList();
        List<WebElement> valids = new ArrayList<>();
        for (int x = 0 ; x <links.size();x++){
            if (!is_Valid(links.get(x))) continue;
            valids.add(elements.get(x));
        }
        return valids;
    }

    public static  String getHref(WebElement element){

        return element.getAttribute("href");

    }


}
