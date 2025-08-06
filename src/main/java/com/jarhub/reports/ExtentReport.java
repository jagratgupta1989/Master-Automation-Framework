package com.jarhub.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jarhub.constants.FrameWorkConstants;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;
    public static ExtentTest test;

    private ExtentReport()
    {

    }

    public static void initReports() throws Exception {
        if(Objects.isNull(extent))
        {
            extent=new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setDocumentTitle("JAR HUB Selenium Automation Framework");
            spark.config().setReportName("JAR HUB Automation Report");
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Jagrat Gupta");
        }
    }
    public static void flushReports() throws Exception {
        if(Objects.nonNull(extent))
        {
            extent.flush();
        }
        ExtentManager.unload();
        Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
    }
    public static void createTest(String testCaseName)
    {
       test = extent.createTest(testCaseName);
       ExtentManager.setExtentTest(test);
    }
}