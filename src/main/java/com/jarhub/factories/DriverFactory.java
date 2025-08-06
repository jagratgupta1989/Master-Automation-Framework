package com.jarhub.factories;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.ConfigProperties;
import com.jarhub.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class DriverFactory {

    private DriverFactory()
    {

    }

    public static WebDriver getDriver(String browser) throws Exception {
        WebDriver driver=null;
        if(Objects.isNull(DriverManager.getDriver()))
        {
            if(PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("local")) {
                if (browser.equalsIgnoreCase("chrome")) {
                    driver = new ChromeDriver();
                }
                if (browser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                }
            }
        }
        return driver;
    }
}
