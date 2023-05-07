package cwtest.tests.Day14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_DependsOn {

    @Test(dependsOnMethods ={"test02"} )
    public void test01(){
        System.out.println("1");
    }

    @Test
    public void test02(){
        System.out.println("2");
        Assert.fail();
    }

    @Test
    public void test03(){
        System.out.println("3");
    }
}
