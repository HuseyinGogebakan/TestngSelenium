package cwtest.tests.Day14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_Enabled {

    @Test(enabled = false )
    public void test01(){
        System.out.println("1");
    }

    @Test
    public void test02(){
        System.out.println("2");

    }
}
