package cwtest.tests.Day14;

import org.testng.annotations.Test;

public class C02_Priotriy {
    // alphabetic order!!! of the method
    // priority is one of the factors effects the order of the methods execution
    @Test(priority = 3)
    public void testA(){
        System.out.println("A is running ... ");
    }
    @Test // default priority = 0
    public void testC(){
        System.out.println("C  is running  .. ");


    }
    @Test(priority = 1)
    public void testB(){
        System.out.println("B is running ...");
    }
}
