package cwtest.Tasks.Day5_6.Tasks;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProvider02 extends BaseClass {


    @Test(dataProvider = "dataprovider")
    public void search(String username, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement element = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        Assert.assertEquals("Invalid credentials",element.getText());
        driver.quit();

    }

    @DataProvider
    public Object[][] dataprovider(){
        Object [][] data = new Object[3][2];
        data[0]= new Object[]{faker.name().username(),faker.internet().password()};
        data[1]= new Object[]{faker.name().username(),faker.internet().password()};
        data[2]= new Object[]{faker.name().username(),faker.internet().password()};

        return data;
    }
}
