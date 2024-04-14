package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener implements ITestListener {

    private static ExtentReports extentReports = new ExtentReports();
    private static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext result) {
        try {
            extentReports = ExtentReportManager.InitReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.log(Status.FAIL, "Test case " + result.getMethod().getMethodName() + "has failed");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test case " + result.getMethod().getMethodName() + " has passed");
    }

    @Override
    public void onFinish(ITestContext result) {
        extentReports.flush();
    }

}
