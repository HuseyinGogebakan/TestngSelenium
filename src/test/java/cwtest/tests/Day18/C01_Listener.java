package cwtest.tests.Day18;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class C01_Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getTestName() + "is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getTestName() + "is success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getTestName() + "is fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getTestName() + "is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(result.getTestName() + "is fail");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution starts ");
        System.out.println(context.getStartDate().toString());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName() + "is finished");
    }
}
