package com.jarhub.reports;


import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    protected ExtentManager()
    {

    }
    private static ThreadLocal<ExtentTest> extTest=new ThreadLocal<>();

    public static ExtentTest getExtentTest()
    {
        return extTest.get();
    }

    public static void setExtentTest(ExtentTest test)
    {
        extTest.set(test);
    }

    public static void unload()
    {
        extTest.remove();
    }
}
