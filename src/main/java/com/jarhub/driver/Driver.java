package com.jarhub.driver;

import com.jarhub.constants.FrameWorkConstants;
import com.jarhub.enums.ConfigProperties;
import com.jarhub.factories.DriverFactory;
import com.jarhub.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class Driver {

    protected Driver()
    {

    }

    public static void initDriver(String browser) throws Exception {
        if(Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory.getDriver(browser));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameWorkConstants.getImplicitWait()));
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
