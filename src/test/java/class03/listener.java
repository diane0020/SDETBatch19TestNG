package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The test case has passed " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The test case has failed " + result.getName());
    }
}
