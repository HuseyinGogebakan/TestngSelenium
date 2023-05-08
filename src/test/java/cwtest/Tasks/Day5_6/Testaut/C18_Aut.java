package cwtest.Tasks.Day5_6.Testaut;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class C18_Aut extends BaseClass {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://automationexercise.com");

        WebElement element = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        Thread.sleep(1000);
        element.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();

        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='cart_quantity_delete']"));

        for(WebElement element1 : elements){
            element1.click();
        }
    }
}
