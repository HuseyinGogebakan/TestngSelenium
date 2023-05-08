package cwtest.Tasks.Day5_6;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SkyScanner extends BaseClass {



    @Test
    public void endToEnd() throws InterruptedException {
        driver.get("https://www.skyscanner.nl/");
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.xpath("//div[@aria-label='Click and hold']//div[2]"));
        actions.clickAndHold(element).perform();
        driver.findElement(By.className("//div[@data-testid='user-prefs-content-container']//button[1]")).click();
    }
}
