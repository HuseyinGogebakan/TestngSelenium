package cwtest.Tasks.Day5_6.Tasks;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DataProvider03 extends BaseClass {
/*
Open the site: http://opencart.abstracta.us/index.php?route=account/login
Login with that credentials
Email: clarusway@gmail.com
Password: 123456789
Using the Search function do it with Data Provider for Mac, iPad and Samsung.
 */
    @Test(dataProvider = "data")
    public void test(String search_Key ) throws InterruptedException {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login ");
       List<WebElement> elements =  driver.findElements(By.tagName("input"));
       elements.get(3).sendKeys("clarusway@gmail.com");
       elements.get(4).sendKeys("123456789");
       elements.get(5).click();
       driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(search_Key);
       driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
       Thread.sleep(1000);
       driver.quit();
    }
    @DataProvider
    public Object[][] data(){
        Object [][] data = new Object [3][1];
        data[0] = new Object[]{"Mac"};
        data[1] = new Object[]{"Samsung"};
        data[2] = new Object[]{"IPad"};


        return data;



    }
}
