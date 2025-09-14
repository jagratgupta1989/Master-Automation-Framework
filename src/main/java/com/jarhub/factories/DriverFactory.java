package com.jarhub.factories;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.ConfigProperties;
import com.jarhub.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Objects;

public class DriverFactory {

    private DriverFactory()
    {

    }

    public static WebDriver getDriver(String browser) throws Exception {
        WebDriver driver=null;
        if(Objects.isNull(DriverManager.getDriver()))
        {
            if (browser.equalsIgnoreCase("chrome"))
            {
                if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("chrome");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                } else {
                    driver = new ChromeDriver();
                }
            }
            if (browser.equalsIgnoreCase("firefox"))
            {
                if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName("firefox");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                } else {
                    driver = new FirefoxDriver();
                }
            }
        }
        return driver;
    }
}
