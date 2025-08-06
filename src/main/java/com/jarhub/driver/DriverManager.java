package com.jarhub.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    protected DriverManager()
    {

    }
    private static ThreadLocal<WebDriver> dr=new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return dr.get();
    }

    public static void setDriver(WebDriver drref)
    {
        dr.set(drref);
    }

    public static void unload()
    {
        dr.remove();
    }
}
