package cwtest.Tasks.Day5_6.Testaut;

import com.github.javafaker.Faker;
import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TasksAutomationEx extends BaseClass {

    @Test
    public void test01() throws InterruptedException {
        /*
        Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
         */
        driver.get("http://automationexercise.com");
        WebElement img = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(img.isDisplayed());
        signup(driver);

       addcart(driver);
       last(driver);
    }

    public static void signup(WebDriver driver) throws InterruptedException {
        Faker faker = new Faker();
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys(faker.internet().password());
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(faker.name().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        WebElement select01 = driver.findElement(By.id("country"));
        Select select = new Select(select01);
        select.selectByVisibleText("Singapore");
        driver.findElement(By.id("state")).sendKeys(faker.address().state());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().cellPhone());
        select01.submit();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        By seletor = RelativeLocator.with(By.xpath("//b")).toRightOf(By.xpath("//i[@class='fa fa-user']"));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(seletor).isDisplayed());
    }
    public static void addcart(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement hover  = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        WebElement click = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]"));
        actions.moveToElement(hover).click(click).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        Thread.sleep(2000);
    }
    public static void last(WebDriver driver){
        Faker faker = new Faker();
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys(faker.finance().creditCard());
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("321");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("01");
        WebElement element = driver.findElement(By.xpath("//input[@name='expiry_year']"));
        element.sendKeys("2025");
        element.submit();
        System.out.println(driver.findElement(By.xpath("//h2[@data-qa='order-placed']//b")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='order-placed']//b")).getText().equals("ORDER PLACED!"));
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
       WebElement img = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(img.isDisplayed());
    }
}
