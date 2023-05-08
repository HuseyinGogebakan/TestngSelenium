package cwtest.Tasks.Day5_6.Testaut;


import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class TasksAutomat18 extends BaseClass {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[@href='#Women']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
        Thread.sleep(2000);
       Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText().equalsIgnoreCase("WOMEN - DRESS PRODUCTS"));


    }
}
