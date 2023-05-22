package cwtest.Tasks.Day5_6.TasksRahul;

import cwtest.utilities.BaseClass;
import dev.failsafe.internal.util.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dropdownrahul extends BaseClass {


    @Test
    public void test01(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Select select =  new Select( driver.findElement(By.id("dropdown-class-example")));
        select.selectByIndex(1);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);
        System.out.println(Arrays.asList(driver.getWindowHandles()));


    }}

