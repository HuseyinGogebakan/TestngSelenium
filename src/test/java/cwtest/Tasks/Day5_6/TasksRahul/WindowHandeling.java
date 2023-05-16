package cwtest.Tasks.Day5_6.TasksRahul;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WindowHandeling extends BaseClass {

    @Test
    public void  testwindow() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();



        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        List<String>  window = new ArrayList<>(windows);
        driver.switchTo().window(window.get(1));
        Assert.assertEquals("New Window",driver.findElement(By.tagName("h3")).getText());


    }

    @Test
    public void testiframe(){
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        driver.switchTo().frame(0);// from 0
        driver.switchTo().frame(1);
        String x = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("MIDDLE",x);
        driver.quit();
        

    }
}
