package cwtest.Tasks.Day5_6;

import cwtest.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

import static java.lang.Thread.sleep;
import static java.util.List.*;

public class C01_Tasks extends BaseClass {


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Apex Questions Bank");
        search.submit();
        sleep(1000);


        System.out.println(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]//span[1]")).getText());
        driver.close();

    }

    @Test
    public void test02() {
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.id("signin_button")).click();

        driver.findElement(By.id("user_login")).sendKeys("username");
        WebElement element = driver.findElement(By.id("user_password"));
        element.sendKeys("password");
        element.submit();

        driver.navigate().back();

        driver.findElement(By.id("online-banking")).click();

        driver.findElement(By.id("pay_bills_link")).click();

        driver.findElement(By.className("span1")).sendKeys("5000");
        WebElement date = driver.findElement(By.xpath("//input[@class='span4 hasDatepicker']"));
        date.sendKeys("2020-09-10");
        date.submit();

        String result = driver.findElement(By.xpath("//div[@id='alert_container']//span")).getText();
        Assert.assertEquals("The payment was successfully submitted.", result, "something went wrong!");
        driver.quit();
    }

    @Test
    public void test03() {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        login.sendKeys("secret_sauce");
        login.submit();
        String goalProduct = driver.findElement(By.className("inventory_item_name")).getText();
        System.out.println(goalProduct);
        driver.findElement(By.xpath("(//div[@class='inventory_item_label'])[1]//a")).click();
        WebElement addtoCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));

        if (!addtoCart.getText().equalsIgnoreCase("remove")) addtoCart.click();
        driver.findElement(By.className("shopping_cart_link")).click();

        List<WebElement> inventory = driver.findElements(By.className("inventory_item_name"));
        if (inventory.size() == 0) {
            Assert.fail();
        }
        Assert.assertEquals(goalProduct, inventory.get(0).getText());

        driver.quit();
    }

    @Test(timeOut = 20000)
    public void test04() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        driver.findElement(By.xpath("(//button[@class='dt-button buttons-create'])[1]")).click();

        List<WebElement> allinputs = driver.findElements(By.xpath("//div[@class='DTE_Form_Content']//input"));
        List<String> datasByorder = new ArrayList<>(List.of("Ibrahim", "kurban", "Retired", "home", "-", "2023-05-13", "2000"));
        for (int i = 0; i < datasByorder.size(); i++) allinputs.get(i).sendKeys(datasByorder.get(i));
        driver.findElement(By.className("btn")).click();
        Thread.sleep(1000);
        WebElement next = driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple']//a[text()='Next']"));
        System.out.println(driver.findElement(By.xpath("//tbody//tr[3]//td[2]")).getText());
        WebElement elementfound = null;

        while (true) {
           int current = driver.findElements(By.xpath("//tbody//tr")).size();
           boolean flag = false;
            for (int i = 1; i <= current; i++) {
                WebElement curentelement = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[@class='sorting_1']"));
                if (curentelement.getText().contains("kurban")) {
                    System.out.println(curentelement.getText());
                     elementfound = driver.findElement(By.xpath("//tbody//tr["+i+"]"));
                    flag =true;
                    break;
                }
                System.out.println(curentelement.getText());

            }
            if (flag) break;
            next.click();
            Thread.sleep(1000);
            next = driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple']//a[text()='Next']"));
        }
        elementfound.click();
        driver.findElement(By.xpath("//button[@class='dt-button buttons-selected buttons-remove']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='DTE_Form_Buttons']//button")).click();

        System.out.println("created deleted!");

        driver.quit();
    }

    @Test
    public void test05() throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       WebElement element =  driver.findElement(By.id("checkBoxOption1"));
       element.click();
       Thread.sleep(1000);
        Assert.assertTrue(element.isSelected());
        element.click();
        Assert.assertFalse(element.isSelected());// driver.switchto.aler.getext
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void test06(){
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Bahadir");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("Bahadir@example.com");
        driver.findElement(By.xpath("(//input)[3]")).sendKeys("secretpassword");
        driver.findElement(By.xpath("(//input)[4]")).click();
        WebElement elementsel = driver.findElement(By.id("exampleFormControlSelect1"));

        Select select = new Select(elementsel);
        System.out.println("is multiple: "+select.isMultiple());
        select.selectByVisibleText("Male");

        Random random = new Random();
        int x = random.nextInt(1,3);

        driver.findElement(By.xpath("//input[@value='option"+(x+1)+"']")).click();
        WebElement element = driver.findElement(By.xpath("//input[@type='date']"));
        element.sendKeys("15/05/2023");
        element.submit();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed());

        driver.quit();
    }


}
