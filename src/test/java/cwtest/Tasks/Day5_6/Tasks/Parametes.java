package cwtest.Tasks.Day5_6.Tasks;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parametes extends BaseClass {


    @Test
    @Parameters({"Value"})
    public void test(String value) throws InterruptedException {

        driver.get("https://www.amazon.com");
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys(value);
        element.submit();
        WebElement element1 = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertEquals(value,element1.getText().replace("\"",""));

        driver.quit();


    }
}
