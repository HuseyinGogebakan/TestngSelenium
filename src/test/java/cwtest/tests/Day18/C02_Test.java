package cwtest.tests.Day18;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(C01_Listener.class)
public final class C02_Test {

    @Test
    public void succes(ITestContext context){
        ExtentReports reports = new ExtentReports();
        ExtentTest extentTest = reports.createTest("Testname");

        Assert.assertTrue(true);
    }
    @Test
    public void fail(ITestContext context){

       // Assert.fail();
    }


}
