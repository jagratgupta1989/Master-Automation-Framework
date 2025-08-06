package com.jarhub.tests;

import com.jarhub.pages.LoginPage;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Epic("Login Module")
@Feature("Valid Login")
public final class LoginTest extends BaseTest{

    LoginPage loginPage=new LoginPage();

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login with valid user and password.")
    @Story("User logs in with valid credentials")
    @Step("Login Functionality Test")
    @Test(description = "Verify user login with valid credentials")
    public void loginTest() throws Exception {
        loginPage.enterEmail("qalearningrepository@gmail.com").enterPassword("Renu@17061989").clickLoginButton();
        Allure.step("Login Test Passed");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Logout Functionality.")
    @Story("User logged out from Application")
    @Step("Logout Functionality Test")
    @Test(description = "Verify user logout functionality")
    public void logoutTest() throws Exception {
        String label = loginPage.enterEmail("qalearningrepository@gmail.com").enterPassword("Renu@17061989").clickLoginButton()
                .clickLogoutButton().getLogInLable();
        Assertions.assertThat(label).describedAs("Log In Label Validation")
                .isEqualTo("Log in");
        Allure.step("Logout Test Passed");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Title Check Functionality.")
    @Step("Title Check Functionality Test")
    @Test(description = "Verify Title Check Functionality")
    public void titleCheckTest()
    {
        Assertions.assertThat(loginPage.getTitle()).describedAs("Title Validation")
                .isEqualTo("Let's Shop");
        Allure.step("Title Check Test Passed");
    }

}
