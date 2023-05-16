package cwtest.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

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
}
