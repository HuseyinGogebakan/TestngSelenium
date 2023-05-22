package cwtest.tests.Day14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_DependsOn {

    @Test(dependsOnMethods ={"test02","test03"} )
    public void test01(){
        System.out.println("1");
    }


    @Test(dependsOnMethods = "test01")
    public void test05(){
        System.out.println("5");
    }

    @Test
    public void test02(){
        System.out.println("2");

    }

    @Test
    public void test03(){
        System.out.println("3");
    }
}
