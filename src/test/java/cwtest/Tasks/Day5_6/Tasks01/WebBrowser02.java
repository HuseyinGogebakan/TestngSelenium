package cwtest.Tasks.Day5_6.Tasks01;

import cwtest.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class WebBrowser02 {
/*

    Go to URL: http://crossbrowsertesting.github.io/todoapp.html
Checking Box todo-4 and Checking Box todo-5
If both clicks worked, then the following List should be have length 2.
Assert that this is correct
Assert that the todo we added is present in the list
Archiving old todos
If our archive link worked, then the following list should have length 4.
Assert that this is true as well
Doing Cross Browser Testing
 */

    @Test
    @Parameters({"browser"})
    public void test01(@Optional String browser) throws InterruptedException {
        WebDriver driver = null;
        switch (browser){
//            case "firefox"->{
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();}
//            case "chrome"->{
//                WebDriverManager.chromedriver().setup();
//                  driver = new ChromeDriver();}
//            }
//            case  "edge"->{
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//            }
            default -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }



        driver.get("https://crossbrowsertesting.github.io/todo-app.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='todo-4']")).click();
        WebElement element_click = driver.findElement(By.xpath("//input[@name='todo-5']"));
        element_click.click();
        Thread.sleep(2000);
        List <WebElement> element_true = driver.findElements(By.xpath("//input[@class='ng-valid ng-dirty ng-valid-parse ng-touched']"));
        Assert.assertEquals(2,element_true.size());
        Assert.assertTrue(element_true.contains(element_click));
        driver.findElement(By.xpath("//a[text()='archive']")).click();
        List<WebElement> elements_left = driver.findElements(By.xpath("//li[@ng-repeat='todo in todoList.todos']"));
        Assert.assertEquals(3,elements_left.size());
        Driver.closerDriver();

    }
}
