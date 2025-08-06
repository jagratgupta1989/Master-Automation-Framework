package com.jarhub.tests;

import com.jarhub.driver.Driver;
import com.jarhub.enums.ConfigProperties;
import com.jarhub.utils.PropertyUtils;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class BaseTest {

    protected BaseTest(){

    }

    @BeforeMethod
    public void setUp() throws Exception {
        Driver.initDriver(PropertyUtils.get(ConfigProperties.BROWSER));
    }

    @AfterMethod
    public void tearDown()
    {
        Driver.quitDriver();
    }
}
