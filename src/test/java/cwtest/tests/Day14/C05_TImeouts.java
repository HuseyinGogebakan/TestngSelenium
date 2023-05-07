package cwtest.tests.Day14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C05_TImeouts {


    @Test(timeOut = 1000 ) // as millisecond
    public void test01() throws InterruptedException {
        System.out.println("1");
        Thread.sleep(2000);
    }

    @Test
    public void test02(){
        System.out.println("2");

    }

    @Test(priority = 1 , enabled = true)
    public void test03(){
        System.out.println("3");

    }
}
