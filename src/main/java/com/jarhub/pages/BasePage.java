package com.jarhub.pages;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.WaitStrategy;
import com.jarhub.factories.ExplicitWaitFactory;
import com.jarhub.logger.ExtentLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {

    JavascriptExecutor js;

    @Step("Element is entered successfully")
    protected void sendKeys(WaitStrategy waitStrategy,By by, String value, String elementname) throws Exception {
        ExplicitWaitFactory.explicitWaitFactory(waitStrategy,by).sendKeys(value);
        ExtentLogger.pass(elementname+" "+"is entered successfully",true);
    }

    @Step("Element is clicked successfully")
    protected void click(WaitStrategy waitStrategy,By by,String elementname) throws Exception {
        ExplicitWaitFactory.explicitWaitFactory(waitStrategy,by).click();
        ExtentLogger.pass(elementname+" "+"is clicked successfully",true);
    }

    @Step("Label is fetched successfully")
    protected String getLabelValue(WaitStrategy waitStrategy,By by) {
        return ExplicitWaitFactory.explicitWaitFactory(waitStrategy,by).getText();
    }

    @Step("Element is Visible")
    protected void validateElementVisibility(By by)
    {
        DriverManager.getDriver().findElement(by).isDisplayed();
    }
    @Step("Element is Enable")
    protected void validateElementEnability(By by)
    {
        DriverManager.getDriver().findElement(by).isEnabled();
    }

    @Step("Down Key is pressed successfully")
    protected void pressDownKey()
    {
        Actions actions=new Actions(DriverManager.getDriver());
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
    }

    @Step("Value is selected successfully")
    protected void selectValueFromBootStrapDropdown(By by, String value, String elementname) throws Exception {
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(value)) {
                element.click();
                break;
            }
        }
        ExtentLogger.pass(elementname+" "+"is selected successfully",true);
    }

    @Step("Scroll Down Operation")
    protected void scrollDown()
    {
        js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("scroll(0,4000);");
    }
    protected void scrollUntilElementIsVisible(By by)
    {
        js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("argument[0].scrollIntoView({behavior:'smooth',block:'center'});",DriverManager.getDriver().findElement(by));
    }


}
