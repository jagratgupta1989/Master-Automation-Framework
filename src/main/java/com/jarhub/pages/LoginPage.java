package com.jarhub.pages;

import com.jarhub.driver.DriverManager;
import com.jarhub.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage{

    private static final By textBoxEmail=By.id("userEmail");
    private static final By textBoxPassword=By.id("userPassword");
    private static final By buttonLogin=By.id("login");
    private static final By labelLogIn=By.xpath("//h1[@class=\"login-title\"]");

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

    public String getLogInLable()
    {
        return getLabelValue(WaitStrategy.VISIBLE,labelLogIn);
    }

    public String getTitle()
    {
        return DriverManager.getDriver().getTitle();
    }
}
