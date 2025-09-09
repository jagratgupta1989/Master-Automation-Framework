package UI.com.jarhub.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1;  // Number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("[INFO] Retrying test: " + result.getName() + " | Attempt: " + retryCount);
            return true;  // Retry the test
        }
        return false; // Do not retry after max retries
    }
}
