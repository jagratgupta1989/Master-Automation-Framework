package com.jarhub.pages;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public final class LoginPage extends BasePage{

    private static final By textBoxEmail=By.id("userEmail");
    private static final By textBoxPassword=By.id("userPassword");
    private static final By buttonLogin=By.id("login");
    private static final By labelLogIn=By.xpath("//h1[@class=\"login-title\"]");
    private static final By linkRegisterHere = By.xpath("//a[text()='Register here']");

    public LoginPage enterEmail(String email) throws Exception {
        sendKeys(WaitStrategy.PRESENCE,textBoxEmail,email,"Email");
        return this;
    }

    public LoginPage enterPassword(String password) throws Exception {
        sendKeys(WaitStrategy.PRESENCE,textBoxPassword,password,"Password");
        return this;
    }

    public DashBoardPage clickLoginButton() throws Exception {
        click(WaitStrategy.CLICKABLE,buttonLogin,"Login button");
        return new DashBoardPage();
    }

    public RegistrationPage clickRegisterHere() {
        WebElement element = DriverManager.getDriver().findElement(linkRegisterHere);
        pressDownKey();
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
        return new RegistrationPage();
    }

    public String getLogInLable()
    {
        return getLabelValue(WaitStrategy.VISIBLE,labelLogIn);
    }

    public String getTitle()
    {
        return DriverManager.getDriver().getTitle();
    }
}
