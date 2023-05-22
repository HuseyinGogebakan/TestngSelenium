package Repeat;

import cwtest.utilities.BaseClass;
import cwtest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Httprequests extends BaseClass {



    @Test
    public void test01() throws IOException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
        String link = driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");

        driver.findElements(By.tagName("a")).stream().map(t-> t.getAttribute("href"));
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(link).openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.connect();
        System.out.println(httpURLConnection.getResponseCode());



        driver.quit();

    }

}
