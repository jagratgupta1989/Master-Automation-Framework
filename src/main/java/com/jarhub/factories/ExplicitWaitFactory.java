package com.jarhub.factories;

import com.jarhub.constants.FrameWorkConstants;
import com.jarhub.driver.DriverManager;
import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

        public static WebElement explicitWaitFactory(WaitStrategy waitStrategy, By by)
        {
            WebElement element =null;
            if(waitStrategy==WaitStrategy.CLICKABLE)
            {
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitWait()))
                        .until(ExpectedConditions.elementToBeClickable(by));
            }
            else if(waitStrategy==WaitStrategy.PRESENCE)
            {
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitWait()))
                        .until(ExpectedConditions.presenceOfElementLocated(by));
            }
            else if(waitStrategy==WaitStrategy.VISIBLE)
            {
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitWait()))
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            else {
                element=DriverManager.getDriver().findElement(by);
            }
            return element;
        }


}
