package cwtest.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public abstract class BaseClass {
    protected WebDriver driver;
    protected  Actions actions;
    @BeforeMethod
    public void settings(){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            actions = new Actions(driver);


    }
}
