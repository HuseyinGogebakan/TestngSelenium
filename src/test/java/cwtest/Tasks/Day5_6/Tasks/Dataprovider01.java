package cwtest.Tasks.Day5_6.Tasks;

import com.fasterxml.jackson.databind.JsonSerializable;
import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider01  extends BaseClass {



    @Test(dataProvider = "data")
    public void search(String searchkey){

        driver.get("https://www.amazon.com/");

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys(searchkey);
        element.submit();
        driver.quit();
    }

    @DataProvider
    public Object[][] data(){
        Object[][]  data = new Object[3][1];
        data[0] = new Object[]{"Python"};
        data[1] = new Object[]{"Java"};
        data[2] = new Object[]{"Javascript"};

        return data;
    }
}
