package cwtest.tests.Day15;

import org.testng.annotations.Test;

public class C01_Groups {

    @Test(groups = {"smoke"})
    public void smokeTest(){
        System.out.println("smoke");
    }

    @Test (groups = {"regression"})
    public void  regressionTest(){
        System.out.println("regression");
    }


    @Test(groups = {"smoke","regression"})
    public void smokeRegressionTest(){
        System.out.println("smoke and regression");

    }
}
