package com.jarhub.logger;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.jarhub.driver.APITestContext;
import com.jarhub.driver.DriverManager;
import com.jarhub.enums.ConfigProperties;
import com.jarhub.reports.ExtentManager;
import com.jarhub.utils.PropertyUtils;
import com.jarhub.utils.ScreenshotUtils;
import io.qameta.allure.Allure;

public final class ExtentLogger {
    private ExtentLogger()
    {

    }
    public static void pass(String message)
    {
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message)
    {
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message)
    {
        ExtentManager.getExtentTest().skip(message);
    }
    public static void pass(String message, boolean isScreenShotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenShotNeeded)
        {
            if (DriverManager.getDriver() != null) {
                ExtentManager.getExtentTest().pass(message,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
            } else {
                // For API tests, no WebDriver session is available
                ExtentManager.getExtentTest().pass(message + " [No Screenshot Available - API Test]");

                // Optionally: Add an Allure attachment manually
                Allure.addAttachment("Passing Reason", message);
                // Attach API Request Body to Allure
                Allure.addAttachment("API Request Body", "application/json",
                        APITestContext.getRequestBody() != null ? APITestContext.getRequestBody() : "Request body is empty", ".json");

                // Attach API Response Body to Allure
                Allure.addAttachment("API Response Body", "application/json",
                        APITestContext.getResponseBody() != null ? APITestContext.getResponseBody() : "Response body is empty", ".json");
            }
        }
        else {
            pass(message);
        }
    }
    public static void fail(String message, boolean isScreenShotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenShotNeeded)
        {
            if (DriverManager.getDriver() != null) {
                ExtentManager.getExtentTest().fail(message,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
            } else {
                // For API tests, no WebDriver session is available
                ExtentManager.getExtentTest().fail(message + " [No Screenshot Available - API Test]");

                // Optionally: Add an Allure attachment manually
                Allure.addAttachment("Failure Reason", message);
            }
        }
        else {
            fail(message);
        }

    }
    public static void skip(String message, boolean isScreenShotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenShotNeeded)
        {
            if (DriverManager.getDriver() != null) {
                ExtentManager.getExtentTest().skip(message,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
            } else {
                // For API tests, no WebDriver session is available
                ExtentManager.getExtentTest().skip(message + " [No Screenshot Available - API Test]");

                // Optionally: Add an Allure attachment manually
                Allure.addAttachment("Skipping Reason", message);
            }
        }
        else {
            skip(message);
        }

    }
}
