package com.jarhub.logger;

import com.aventstack.extentreports.MediaEntityBuilder;
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
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
        }
        else {
            pass(message);
        }

    }
    public static void fail(String message, boolean isScreenShotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenShotNeeded)
        {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
            //Allure.addAttachment(message, String.valueOf(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build()));
        }
        else {
            fail(message);
        }

    }
    public static void skip(String message, boolean isScreenShotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenShotNeeded)
        {
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
        }
        else {
            skip(message);
        }

    }
}
