package cwtest.Tasks.Day5_6.Testaut;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_Tasks extends BaseClass {

    @Test
    public void test02() throws InterruptedException {
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
         */

        driver.get("http://automationexercise.com");
        WebElement img = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(img.isDisplayed());
        TasksAutomationEx.signup(driver);

        TasksAutomationEx.addcart(driver);

        driver.findElement(By.tagName("textarea")).sendKeys(faker.superhero().descriptor());
        TasksAutomationEx.last(driver);

    }
}
