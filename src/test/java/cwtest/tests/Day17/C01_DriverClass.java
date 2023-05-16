package cwtest.tests.Day17;

import cwtest.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_DriverClass {

    @Test
    public  void  test01(){
        Driver.getDriver().get("https://www.amazon.de/");

        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("amazon"));

        Driver.closerDriver();

    }
}
