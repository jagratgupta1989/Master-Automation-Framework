package UI.com.jarhub.listeners;

import com.jarhub.logger.ExtentLogger;
import com.jarhub.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;


public class Listener implements ISuiteListener, ITestListener {

    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
        ExtentLogger.pass(result.getMethod().getMethodName()+" "+"is passed");
    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName()+" "+"is failed",true);
            ExtentLogger.fail(result.getThrowable().toString()); //Print Exception
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); //Print Stack Trace
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result)
    {
        ExtentLogger.pass(result.getMethod().getMethodName()+" "+"is skipped");
    }
    @Override
    public void onStart(ISuite suit)
    {
        try{
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ISuite suit)
    {
        try{
            ExtentReport.flushReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
