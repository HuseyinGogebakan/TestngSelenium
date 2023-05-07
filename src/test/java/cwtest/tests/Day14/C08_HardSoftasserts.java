package cwtest.tests.Day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C08_HardSoftasserts {

    @Test
    public void hard(){
        System.out.println("checking 1 = 1");
        Assert.assertEquals(1,1);
        System.out.println("checking 1 = 2");
        Assert.assertEquals(1,2);
        System.out.println("checking 2 = 3");
        Assert.assertEquals(2,3);
    }

    @Test
    public void soft(){

        SoftAssert softAssert = new SoftAssert();
        System.out.println("checking 1 = 1");
        softAssert.assertEquals(1,1);

        System.out.println("checking 1 = 2");
        softAssert.assertEquals(1,2);
        System.out.println("checking 2 = 3");
        softAssert.assertEquals(2,3);

        softAssert.assertAll();

    }
}
